package com.troutee.api.services.impl;


import com.troutee.api.services.decl.UserService;
import com.troutee.bussiness.converter.mappers.UserMapper;
import com.troutee.bussiness.exceptions.AuthorizationException;
import com.troutee.bussiness.exceptions.ValidationException;
import com.troutee.bussiness.model.request.*;
import com.troutee.bussiness.model.response.XTokenResponse;
import com.troutee.bussiness.model.response.XUserResponse;
import com.troutee.bussiness.util.CryptoUtils;
import com.troutee.api.util.Utils;
import com.troutee.bussiness.validation.decl.ValidEmail;
import com.troutee.domain.Session;
import com.troutee.domain.Tuser;
import com.troutee.domain.Status;
import com.troutee.bussiness.beans.session.decl.SessionCreator;
import com.troutee.bussiness.beans.session.decl.SessionFinder;
import com.troutee.bussiness.beans.session.decl.SessionUpdater;
import com.troutee.bussiness.beans.user.decl.UserCreator;
import com.troutee.bussiness.beans.user.decl.UserFinder;
import com.troutee.bussiness.beans.user.decl.UserUpdater;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.Date;

/**
 * Created by vicente on 29/02/16.
 */
@Named
@Stateless
public class UserServiceImpl implements UserService {

    @Inject
    private UserCreator userCreator;
    @Inject
    private UserFinder userFinder;
    @Inject
    private UserUpdater userUpdater;
    @Inject
    private UserMapper userMapper;
    @Inject
    private SessionUpdater sessionUpdater;
    @Inject
    private SessionCreator sessionCreator;
    @Inject
    private SessionFinder sessionFinder;

    public Response signup(@Context HttpServletRequest request, @NotNull(message = "{troutee.validation.empty.request}") @Valid XSignupRequest xSignupRequest) {
            Tuser tuser = userMapper.convertTo(xSignupRequest);
            tuser.setCreatedAt(new Date());
            tuser.setLastLogin(new Date());
            tuser.setStatus(Status.ACTIVE);
            tuser.setCredential(CryptoUtils.encrypt(tuser.getCredential()));
            userCreator.create(tuser);
            if(xSignupRequest.getImage()!=null){
                String image_url = Utils.uploadImage(xSignupRequest.getImage());
                tuser.setImage(image_url);
                userUpdater.update(tuser);
            }
            String token = Utils.getToken(tuser);
            sessionCreator.create(new Session(token, Status.ACTIVE, tuser));
            XUserResponse userResponse= userMapper.convertFrom(tuser);
            userResponse.setToken(token);
            return Response.status(Response.Status.CREATED)
                    .entity(userResponse)
                    .build();

    }

    public Response login(@Context HttpServletRequest request, @NotNull(message = "{troutee.validation.empty.request}") @Valid XLoginRequest login) {
        Tuser tuser = userFinder.getByEmail(login.getEmail());
        String stored_password=tuser.getCredential();
        String login_password = CryptoUtils.encrypt(login.getPassword());
        if(!stored_password.equals(login_password)){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Utils.getErrorResponse(request.getLocale(), "troutee.error.invalid_password"))
                    .build();
        }else{
            XUserResponse loginResponse = userMapper.convertFrom(tuser);
            sessionUpdater.disableUserTokens(tuser.getId());
            String token = Utils.getToken(tuser);
            sessionCreator.create(new Session(token,Status.ACTIVE,tuser));
            loginResponse.setToken(token);
            tuser.setLastLogin(new Date());
            userUpdater.update(tuser);
            return Response.status(Response.Status.OK)
                    .entity(loginResponse)
                    .build();
        }
    }

    public Response logout(@Context HttpServletRequest request, @NotNull(message = "{troutee.validation.empty.request}") @Valid XTokenRequest xTokenRequest) {
        sessionUpdater.disableUserToken(xTokenRequest.getToken());
        return Response.status(Response.Status.OK)
                .build();
    }

    public Response update(@Context HttpServletRequest request, @NotNull(message = "{troutee.validation.empty.request}") @Valid XUpdateUserRequest xupdateUserRequest) {
        Tuser tuser=sessionFinder.getUserFromToken(xupdateUserRequest.getToken());
        if(tuser.getId()!=xupdateUserRequest.getId()){
            throw new AuthorizationException("troutee.error.invalid_token");
        }
        if(xupdateUserRequest.getEmail()!=null && !xupdateUserRequest.getEmail().isEmpty() && xupdateUserRequest.getEmail().compareTo(tuser.getEmail()) != 0){//email changed
            if(userFinder.isEmailRegistered(xupdateUserRequest.getEmail())){
                throw new ValidationException("user.email.already.in.use");
            }else{
                tuser.setEmail(xupdateUserRequest.getEmail());
            }
        }
        tuser.setFirstname(xupdateUserRequest.getFirstName());
        tuser.setLastname(xupdateUserRequest.getLastName());

        if(xupdateUserRequest.getImage()!=null){
            String image_url = Utils.uploadImage(xupdateUserRequest.getImage());
            tuser.setImage(image_url);
        }

        userUpdater.update(tuser);
        sessionUpdater.disableUserTokens(tuser.getId());
        String token = Utils.getToken(tuser);
        sessionCreator.create(new Session(token, Status.ACTIVE, tuser));
        XUserResponse userResponse= userMapper.convertFrom(tuser);
        userResponse.setToken(token);
        return Response.status(Response.Status.OK)
                .entity(userResponse)
                .build();
    }

    public Response updatePassword(@Context HttpServletRequest request, @NotNull(message = "{troutee.validation.empty.request}") @Valid XUpdatePasswordRequest xUpdatePasswordRequest) {
        Tuser tuser=sessionFinder.getUserFromToken(xUpdatePasswordRequest.getToken());
        if(tuser.getId()!=xUpdatePasswordRequest.getId()){
            throw new ValidationException("troutee.error.invalid_token");
        }
        tuser.setCredential(CryptoUtils.encrypt(xUpdatePasswordRequest.getPassword()));
        userUpdater.update(tuser);
        sessionUpdater.disableUserTokens(tuser.getId());
        String token = Utils.getToken(tuser);
        sessionCreator.create(new Session(token, Status.ACTIVE, tuser));
        XUserResponse userResponse= userMapper.convertFrom(tuser);
        userResponse.setToken(token);
        return Response.status(Response.Status.OK)
                .entity(userResponse)
                .build();
    }


    public Response validateToken(@Context HttpServletRequest request, @NotNull(message = "{troutee.validation.empty.request}") @Valid XTokenRequest xTokenRequest) {
        return Response.status(Response.Status.OK)
                .entity(new XTokenResponse(xTokenRequest.getToken(),Boolean.TRUE))
                .build();
    }

    public Response find_by_id(Integer id) {
        Tuser tuser= userFinder.get(id);
        return Response.status(Response.Status.OK)
                .entity(userMapper.convertFrom(tuser))
                .build();
    }

    public Response find_by_email(@NotNull(message = "{user.email.required}") @ValidEmail String email) {
        Tuser tuser= userFinder.getByEmail(email);
        return Response.status(Response.Status.OK)
                .entity(userMapper.convertFrom(tuser))
                .build();
    }


}
