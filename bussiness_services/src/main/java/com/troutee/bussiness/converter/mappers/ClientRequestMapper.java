package com.troutee.bussiness.converter.mappers;

import com.troutee.bussiness.exceptions.ServiceException;
import com.troutee.bussiness.model.request.XClientRequest;
import com.troutee.bussiness.model.response.XClientResponse;
import com.troutee.domain.Client;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.dozer.MappingException;

import javax.ejb.Stateless;
import javax.inject.Named;

/**
 * Created by vicente on 29/02/16.
 */
@Named
@Stateless
public class ClientRequestMapper {
    private Mapper mapper= DozerBeanMapperSingletonWrapper.getInstance();

    public XClientRequest convertFrom(Client user) {
        try{
            XClientRequest xClientRequest= mapper.map(user, XClientRequest.class);
            return xClientRequest;
        }catch (MappingException me){
            throw new ServiceException("troutee.general.error");
        }

    }

    public Client convertTo(XClientRequest xClientRequest) {
        try{
            Client client= mapper.map(xClientRequest, Client.class);
            return client;
        }catch(MappingException me){
            throw new ServiceException("troutee.general.error");
        }
    }
}
