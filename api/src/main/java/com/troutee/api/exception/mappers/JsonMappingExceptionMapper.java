package com.troutee.api.exception.mappers;


import com.fasterxml.jackson.databind.JsonMappingException;
import com.troutee.api.util.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by vicente on 07/03/16.
 */
@Provider
public class JsonMappingExceptionMapper implements ExceptionMapper<JsonMappingException>{

    @Context
    private HttpServletRequest request;

    public Response toResponse(JsonMappingException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(Utils.getErrorResponse(request.getLocale(), "troutee.general.error")).build();
    }
}
