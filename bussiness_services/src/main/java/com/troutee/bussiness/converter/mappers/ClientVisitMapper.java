package com.troutee.bussiness.converter.mappers;

import com.troutee.bussiness.beans.client.decl.ClientFinder;
import com.troutee.bussiness.beans.session.decl.SessionFinder;
import com.troutee.bussiness.exceptions.ServiceException;
import com.troutee.bussiness.model.request.XCheckinRequest;
import com.troutee.bussiness.model.response.XClientResponse;
import com.troutee.domain.Client;
import com.troutee.domain.ClientVisit;
import com.troutee.domain.Session;
import com.troutee.domain.Tuser;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.dozer.MappingException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by vicente on 29/02/16.
 */
@Named
@Stateless
public class ClientVisitMapper {
    @Inject
    private ClientFinder clientFinder;
    @Inject
    private SessionFinder sessionFinder;

    private Mapper mapper= DozerBeanMapperSingletonWrapper.getInstance();

    public ClientVisit convertTo(XCheckinRequest xCheckinRequest) {
        try{
            ClientVisit clientVisit= mapper.map(xCheckinRequest, ClientVisit.class);
            Client client=clientFinder.find_by_id(xCheckinRequest.getClientid());
            if(client!=null){
                clientVisit.setClientId(client);
            }

            Tuser tuser= sessionFinder.getUserFromToken(xCheckinRequest.getToken());
            if(tuser!=null){
                clientVisit.setUserId(tuser);
            }
            return clientVisit;
        }catch(MappingException me){
            throw new ServiceException("troutee.general.error");
        }
    }
}
