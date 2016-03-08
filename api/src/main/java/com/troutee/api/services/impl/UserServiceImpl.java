package com.troutee.api.services.impl;

import com.troutee.api.beans.user.decl.UserCreator;
import com.troutee.api.beans.user.decl.UserFinder;
import com.troutee.api.services.decl.UserService;
import com.troutee.api.util.CryptoUtils;
import com.troutee.api.util.ErrorData;
import com.troutee.api.util.Utils;
import com.troutee.converter.mappers.LoginMapper;
import com.troutee.converter.mappers.UserMapper;
import com.troutee.domain.Tuser;
import com.troutee.domain.UserStatus;
import com.troutee.model.request.XLogin;
import com.troutee.model.request.XSignup;
import com.troutee.model.response.XBaseErrorResponse;
import com.troutee.model.response.XBaseResponse;
import com.troutee.model.response.XLoginResponse;
import com.troutee.model.validation.decl.ValidEmail;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.Date;

/**
 * Created by vicente on 29/02/16.
 */
public class UserServiceImpl implements UserService {

    @Inject
    private UserCreator userCreator;
    @Inject
    private UserFinder userFinder;
    @Inject
    private UserMapper userMapper;
    @Inject
    private LoginMapper loginMapper;


    public Response signup(@Context HttpServletRequest request, @NotNull(message = "{troutee.validation.empty.request}") @Valid XSignup signUp) {
        if(userFinder.isEmailRegistered(signUp.getEmail())){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Utils.getErrorResponse(request.getLocale(), "user.email.already.in.use"))
                    .build();
        }else{
            Tuser tuser = userMapper.convertTo(signUp);
            tuser.setCreatedAt(new Date());
            tuser.setStatus(UserStatus.INACTIVE);
            tuser.setCredential(CryptoUtils.encrypt(tuser.getCredential()));
            userCreator.create(tuser);
            XBaseResponse response = new XBaseResponse("user",userMapper.convertFrom(tuser));
            return Response.status(Response.Status.CREATED)
                    .entity(response)
                    .build();
        }

    }

    public Response login(@Context HttpServletRequest request, @NotNull(message = "{troutee.validation.empty.request}") @Valid XLogin login) {
        Tuser tuser = userFinder.getByEmail(login.getEmail());
        String stored_password=tuser.getCredential();
        String login_password = CryptoUtils.encrypt(login.getPassword());
        if(!stored_password.equals(login_password)){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Utils.getErrorResponse(request.getLocale(), "troutee.error.invalid_password"))
                    .build();
        }else{
            XLoginResponse loginResponse = loginMapper.convertFrom(tuser);
            String token = Utils.getToken(tuser);
            loginResponse.setToken(CryptoUtils.encrypt(token));
            XBaseResponse response = new XBaseResponse("login_response",loginResponse);
            return Response.status(Response.Status.OK)
                    .entity(response)
                    .build();
        }
    }

    public Response find_by_id(Integer id) {
        Tuser tuser= userFinder.get(id);
        XBaseResponse response = new XBaseResponse("user",userMapper.convertFrom(tuser));
        return Response.status(Response.Status.OK)
                .entity(response)
                .build();
    }

    public Response find_by_email(@NotNull(message = "{user.email.required}") @ValidEmail String email) {
        Tuser tuser= userFinder.getByEmail(email);
        XBaseResponse response = new XBaseResponse("user",userMapper.convertFrom(tuser));
        return Response.status(Response.Status.OK)
                .entity(response)
                .build();
    }


}
