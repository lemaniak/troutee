package com.troutee.api.services.impl;

import com.troutee.api.services.decl.ClientService;
import com.troutee.api.util.Utils;
import com.troutee.bussiness.beans.client.decl.ClientFinder;
import com.troutee.bussiness.beans.client.decl.ClientUpdater;
import com.troutee.bussiness.beans.clientVisit.decl.ClientVisitCreator;
import com.troutee.bussiness.converter.mappers.ClientMapper;
import com.troutee.bussiness.converter.mappers.ClientRequestMapper;
import com.troutee.bussiness.converter.mappers.ClientVisitMapper;
import com.troutee.bussiness.exceptions.ValidationException;
import com.troutee.bussiness.model.request.XCheckinRequest;
import com.troutee.bussiness.model.request.XClientIds;
import com.troutee.bussiness.model.request.XClientRequest;
import com.troutee.bussiness.model.request.XTokenRequest;
import com.troutee.bussiness.model.response.XClientResponse;
import com.troutee.bussiness.model.response.XClientVersion;
import com.troutee.bussiness.model.response.XClientVersions;
import com.troutee.bussiness.model.response.XClientsResponse;
import com.troutee.domain.Client;
import com.troutee.domain.ClientStatus;
import com.troutee.domain.ClientVisit;
import com.troutee.domain.Tuser;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vicente on 27/06/16.
 */
@Named
@Stateless
public class ClientServiceImpl implements ClientService {

    @Inject
    private ClientMapper clientMapper;

    @Inject
    private ClientVisitMapper clientVisitMapper;

    @Inject
    private ClientRequestMapper clientRequestMapper;

    @Inject
    private ClientFinder clientFinder;

    @Inject
    private ClientUpdater clientUpdater;

    @Inject
    private ClientVisitCreator clientVisitCreator;

    public Response find_by_id(@NotNull(message = "{client.id.required}") Integer id) {
        Client client = clientFinder.find_by_id(id);
        return Response.status(Response.Status.OK)
                .entity(clientMapper.convertFrom(client))
                .build();
    }

    public Response find_by_name(@NotNull(message = "{client.name.required}") String name) {
        List<Client> clients = clientFinder.find_by_name("%" + name + "%");
        if(clients!=null && !clients.isEmpty()){
            XClientsResponse clientsResponse = new XClientsResponse();
            clientsResponse.setClients(new ArrayList<XClientResponse>());
            for(Client c :clients){
                clientsResponse.getClients().add(clientMapper.convertFrom(c));
            }
            return Response.status(Response.Status.OK)
                    .entity(clientsResponse)
                    .build();
        }else{
            return Response.status(Response.Status.OK)
                    .entity(null)
                    .build();
        }

    }

    public Response find_by_code(@NotNull(message = "{client.code.required}") String code) {
        List<Client> clients = clientFinder.find_by_code("%" + code + "%");
        if(clients!=null && !clients.isEmpty()){
            XClientsResponse clientsResponse = new XClientsResponse();
            clientsResponse.setClients(new ArrayList<XClientResponse>());
            for(Client c :clients){
                clientsResponse.getClients().add(clientMapper.convertFrom(c));
            }
            return Response.status(Response.Status.OK)
                    .entity(clientsResponse)
                    .build();
        }else{
            return Response.status(Response.Status.OK)
                    .entity(null)
                    .build();
        }
    }

    public Response find_all(@Context HttpServletRequest request, @NotNull(message = "{troutee.validation.empty.request}") @Valid XTokenRequest xTokenRequest) {
        List<Client> clients = clientFinder.find_all();
        if(clients!=null && !clients.isEmpty()){
            XClientsResponse clientsResponse = new XClientsResponse();
            clientsResponse.setClients(new ArrayList<XClientResponse>());
            for(Client c :clients){
                clientsResponse.getClients().add(clientMapper.convertFrom(c));
            }
            return Response.status(Response.Status.OK)
                    .entity(clientsResponse)
                    .build();
        }else{
            return Response.status(Response.Status.OK)
                    .entity(null)
                    .build();
        }
    }

    public Response get_client_versions(@Context HttpServletRequest request, @NotNull(message = "{troutee.validation.empty.request}") @Valid XTokenRequest xTokenRequest) {
        List<Client> clients = clientFinder.find_all();
        if(clients!=null && !clients.isEmpty()){
            XClientVersions xClientVersions= new XClientVersions();
            xClientVersions.setClientVersions(new ArrayList<XClientVersion>());
            StringBuilder clientIds=new StringBuilder(clients.size()*2);
            Iterator<Client> clientIterator = clients.iterator();
            while (clientIterator.hasNext()){
                Client c = clientIterator.next();
                if(clientIterator.hasNext()){//is not last record
                    clientIds.append(c.getId() + ",");
                }else{//is last record
                    clientIds.append(c.getId()+"");
                }
                xClientVersions.getClientVersions().add(new XClientVersion(c.getId(),c.getVersion()));
            }
            xClientVersions.setClientids(clientIds.toString());
            return Response.status(Response.Status.OK)
                    .entity(xClientVersions)
                    .build();
        }else{
            return Response.status(Response.Status.OK)
                    .entity(null)
                    .build();
        }
    }

    public Response get_client_by_ids(@Context HttpServletRequest request, @NotNull(message = "{troutee.validation.empty.request}") @Valid XClientIds xClientIds) {
        List<Client> clients= clientFinder.find_all_range(xClientIds.getClientids());
        if(clients!=null && !clients.isEmpty()){
            XClientsResponse clientsResponse = new XClientsResponse();
            clientsResponse.setClients(new ArrayList<XClientResponse>());
            for(Client c :clients){
                clientsResponse.getClients().add(clientMapper.convertFrom(c));
            }
            return Response.status(Response.Status.OK)
                    .entity(clientsResponse)
                    .build();
        }else{
            return Response.status(Response.Status.OK)
                    .entity(null)
                    .build();
        }
    }

    public Response update(@Context HttpServletRequest request, @NotNull(message = "{troutee.validation.empty.request}") @Valid XClientRequest xClientRequest) {
           Client clientrequest = clientRequestMapper.convertTo(xClientRequest);
           Client client= clientFinder.find_by_id(xClientRequest.getId());
           clientrequest.setVersion(client.getVersion() + 1);
           if(clientrequest.getLat()!=null && clientrequest.getLon()!=null){//Validate coordenates do not belong to another client
                if(!clientFinder.isUniqueCoodinates(clientrequest.getId(), clientrequest.getLat(),clientrequest.getLon())){
                    throw new ValidationException("client.coordinates.invalid");
                }
           }
           clientrequest.setStatus(ClientStatus.UPDATED);
           client=clientUpdater.update(clientrequest);

           XClientResponse clientResponse =clientMapper.convertFrom(client);
        return Response.status(Response.Status.OK)
                .entity(clientResponse)
                .build();
    }

    public Response checkin(@Context HttpServletRequest request, @NotNull(message = "{troutee.validation.empty.request}") @Valid XCheckinRequest xCheckinRequest) {
        Client client=clientFinder.find_by_id(xCheckinRequest.getClientid());
        if(client.getLat()==null || client.getLon()==null){
            throw new ValidationException("client.coordinates.empty");
        }else{
            Double distance = Utils.distance(xCheckinRequest.getLat(), xCheckinRequest.getLon(), client.getLat(),client.getLon(),"MT");
            if(distance > 50){
                throw new ValidationException("client.coordinates.not_near_checkin_location");
            }else{
                ClientVisit visit = clientVisitMapper.convertTo(xCheckinRequest);
                visit.setLastLogin(new Date());
                clientVisitCreator.create(visit);

                return Response.status(Response.Status.OK)
                        .entity(null)
                        .build();
            }
        }
    }


}
