package com.troutee.api.exception.mappers;

import com.troutee.api.util.ErrorData;
import com.troutee.api.util.Utils;
import com.troutee.model.response.XBaseErrorResponse;
import org.jboss.resteasy.api.validation.ResteasyViolationException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Locale;

/**
 * Created by vicente on 17/03/15.
 */
@Provider
public class ResteasyViolationExceptionMapper implements ExceptionMapper<ResteasyViolationException> {

    @Context
    private HttpServletRequest request;

    public Response toResponse(ResteasyViolationException exception) {
        String message = exception.getParameterViolations().get(0).getMessage().replace('{',' ').replace('}',' ').trim();
        return Response.status(Response.Status.BAD_REQUEST).entity(Utils.getErrorResponse(request.getLocale(),message)).build();
    }
}