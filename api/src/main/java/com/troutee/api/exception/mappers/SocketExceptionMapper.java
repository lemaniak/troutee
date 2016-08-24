package com.troutee.api.exception.mappers;

import com.troutee.api.util.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.net.SocketException;

/**
 * Created by vicente on 17/03/16.
 */
@Provider
public class SocketExceptionMapper implements ExceptionMapper<SocketException> {

    @Context
    private HttpServletRequest request;

    public Response toResponse(SocketException e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Utils.getErrorResponse(request.getLocale(),e.getMessage())).build();
    }
}
