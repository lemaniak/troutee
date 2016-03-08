package com.troutee.api.exception.mappers;

import com.fasterxml.jackson.core.JsonParseException;
import com.troutee.api.util.Utils;
import com.troutee.model.response.XBaseErrorResponse;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by vicente on 17/03/15.
 */
@Provider
public class JsonParseExceptionMapper implements ExceptionMapper<JsonParseException> {

    @Context
    private HttpServletRequest request;

    public Response toResponse(JsonParseException se) {
        return Response.status(Response.Status.BAD_REQUEST).entity(Utils.getErrorResponse(request.getLocale(),"troutee.validation.invalid.request")).build();
    }
}