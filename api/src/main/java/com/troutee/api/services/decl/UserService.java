package com.troutee.api.services.decl;


import com.troutee.bussiness.model.request.*;
import com.troutee.bussiness.validation.decl.ValidEmail;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by vicente on 29/02/16.
 */
@Path("/user")
public interface UserService {

    @POST
    @Path("/signup")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    Response signup(@Context HttpServletRequest request,@NotNull(message="{troutee.validation.empty.request}") @Valid XSignupRequest xUser);

    @POST
    @Path("/login")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    Response login(@Context HttpServletRequest request,@NotNull(message="{troutee.validation.empty.request}") @Valid XLoginRequest login);

    @POST
    @Path("/logout")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    Response logout(@Context HttpServletRequest request,@NotNull(message="{troutee.validation.empty.request}") @Valid XTokenRequest xTokenRequest);

    @POST
    @Path("/update")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    Response update(@Context HttpServletRequest request,@NotNull(message="{troutee.validation.empty.request}") @Valid XUpdateUserRequest xupdateUserRequest);

    @POST
    @Path("/update/password")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    Response updatePassword(@Context HttpServletRequest request,@NotNull(message="{troutee.validation.empty.request}") @Valid XUpdatePasswordRequest xUpdatePasswordRequest);

    @POST
    @Path("/validate_token")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    Response validateToken(@Context HttpServletRequest request,@NotNull(message="{troutee.validation.empty.request}") @Valid XTokenRequest xTokenRequest);


    @GET
    @Path("/find_by_id")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    Response find_by_id (@NotNull(message = "{user.id.required}") @QueryParam("id") Integer id);

    @GET
    @Path("/find_by_email")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    Response find_by_email (@NotNull(message = "{user.email.required}") @QueryParam("email") @ValidEmail String email);
}
