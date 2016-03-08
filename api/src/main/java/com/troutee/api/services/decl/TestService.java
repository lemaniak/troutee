package com.troutee.api.services.decl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by vicente on 10/03/15.
 */
@Path("/test")
public interface TestService {

    @Path("/test")
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    public String deleteMessages();
}
