package com.troutee.api.exception.mappers;


import com.troutee.api.util.Utils;
import com.troutee.bussiness.exceptions.AuthorizationException;
import com.troutee.bussiness.exceptions.ValidationException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by vicente on 19/03/15.
 */
@Provider
public class AuthorizationExceptionMapper implements ExceptionMapper<AuthorizationException> {

    @Context
    private HttpServletRequest request;

    public Response toResponse(AuthorizationException se) {
        return Response.status(Response.Status.UNAUTHORIZED).entity(Utils.getErrorResponse(request.getLocale(),se.getMessage())).build();
    }
}