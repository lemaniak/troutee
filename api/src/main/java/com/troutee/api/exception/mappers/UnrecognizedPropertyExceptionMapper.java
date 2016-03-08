package com.troutee.api.exception.mappers;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.troutee.api.util.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by vicente on 17/03/15.
 */
@Provider
public class UnrecognizedPropertyExceptionMapper implements ExceptionMapper<UnrecognizedPropertyException> {

    @Context
    private HttpServletRequest request;

    public Response toResponse(UnrecognizedPropertyException se) {
        return Response.status(Response.Status.BAD_REQUEST).entity(Utils.getErrorResponse(request.getLocale(),se.getMessage())).build();
    }
}