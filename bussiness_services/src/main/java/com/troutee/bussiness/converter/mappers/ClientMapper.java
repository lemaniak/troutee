package com.troutee.bussiness.converter.mappers;

import com.troutee.bussiness.exceptions.ServiceException;
import com.troutee.bussiness.model.request.XSignupRequest;
import com.troutee.bussiness.model.response.XClientResponse;
import com.troutee.bussiness.model.response.XUserResponse;
import com.troutee.domain.Client;
import com.troutee.domain.Tuser;
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
public class ClientMapper {
    private Mapper mapper= DozerBeanMapperSingletonWrapper.getInstance();

    public XClientResponse convertFrom(Client user) {
        try{
            XClientResponse xClientResponse= mapper.map(user, XClientResponse.class);
            return xClientResponse;
        }catch (MappingException me){
            throw new ServiceException("troutee.general.error");
        }

    }

    public Client convertTo(XClientResponse xClientResponse) {
        try{
            Client client= mapper.map(xClientResponse, Client.class);
            return client;
        }catch(MappingException me){
            throw new ServiceException("troutee.general.error");
        }
    }
}
