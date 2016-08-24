package com.troutee.api.exception.mappers;


import com.troutee.api.util.Utils;
import com.troutee.bussiness.exceptions.NotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by vicente on 19/03/15.
 */
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Context
    private HttpServletRequest request;

    public Response toResponse(NotFoundException se) {
        return Response.status(Response.Status.NOT_FOUND).entity(Utils.getErrorResponse(request.getLocale(),se.getMessage())).build();
    }
}