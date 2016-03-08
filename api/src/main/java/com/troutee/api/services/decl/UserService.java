package com.troutee.api.services.decl;

import com.troutee.model.request.XLogin;
import com.troutee.model.request.XSignup;
import com.troutee.model.validation.decl.ValidEmail;

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
    Response signup(@Context HttpServletRequest request,@NotNull(message="{troutee.validation.empty.request}") @Valid XSignup signUp);

    @POST
    @Path("/login")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    Response login(@Context HttpServletRequest request,@NotNull(message="{troutee.validation.empty.request}") @Valid XLogin login);

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
