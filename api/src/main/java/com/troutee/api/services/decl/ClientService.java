package com.troutee.api.services.decl;

import com.troutee.bussiness.model.request.XCheckinRequest;
import com.troutee.bussiness.model.request.XClientIds;
import com.troutee.bussiness.model.request.XClientRequest;
import com.troutee.bussiness.model.request.XTokenRequest;
import com.troutee.bussiness.validation.decl.ValidToken;

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
@Path("/client")
public interface ClientService {

    @GET
    @Path("/find_by_id")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    Response find_by_id(@NotNull(message = "{client.id.required}") @QueryParam("id") Integer id);

    @GET
    @Path("/find_by_name")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    Response find_by_name(@NotNull(message = "{client.name.required}") @QueryParam("name") String name);

    @GET
    @Path("/find_by_code")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    Response find_by_code(@NotNull(message = "{client.code.required}") @QueryParam("code") String code);

    @POST
    @Path("/find_all")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    Response find_all(@Context HttpServletRequest request,@NotNull(message="{troutee.validation.empty.request}") @Valid XTokenRequest xTokenRequest);


    @POST
    @Path("/get_client_versions")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    Response get_client_versions(@Context HttpServletRequest request,@NotNull(message="{troutee.validation.empty.request}") @Valid XTokenRequest xTokenRequest);

    @POST
    @Path("/get_client_by_ids")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    Response get_client_by_ids(@Context HttpServletRequest request,@NotNull(message="{troutee.validation.empty.request}") @Valid XClientIds xClientIds);

    @POST
    @Path("/update")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    Response update(@Context HttpServletRequest request,@NotNull(message="{troutee.validation.empty.request}") @Valid XClientRequest xClientRequest);


    @POST
    @Path("/checkin")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    Response checkin(@Context HttpServletRequest request,@NotNull(message="{troutee.validation.empty.request}") @Valid XCheckinRequest xCheckinRequest);
}
