package com.troutee.api.exception.mappers;



import com.troutee.api.util.ErrorData;
import com.troutee.api.util.Utils;
import com.troutee.exceptions.ServiceException;
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
public class ServiceExceptionMapper implements ExceptionMapper<ServiceException> {

    @Context
    private HttpServletRequest request;

    public Response toResponse(ServiceException se) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Utils.getErrorResponse(request.getLocale(),se.getMessage())).build();
    }
}