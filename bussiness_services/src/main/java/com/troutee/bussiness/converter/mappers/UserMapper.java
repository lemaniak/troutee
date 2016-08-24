package com.troutee.bussiness.converter.mappers;

import com.troutee.bussiness.exceptions.ServiceException;
import com.troutee.bussiness.model.request.XSignupRequest;
import com.troutee.bussiness.model.response.XUserResponse;
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
public class UserMapper {
    private Mapper mapper= DozerBeanMapperSingletonWrapper.getInstance();

    public XUserResponse convertFrom(Tuser user) {
        try{
            XUserResponse signUpResponse= mapper.map(user, XUserResponse.class);
            return signUpResponse;
        }catch (MappingException me){
            throw new ServiceException("troutee.general.error");
        }

    }

    public Tuser convertTo(XSignupRequest xSignupRequest) {
        try{
            Tuser user= mapper.map(xSignupRequest, Tuser.class);
            return user;
        }catch(MappingException me){
            throw new ServiceException("troutee.general.error");
        }
    }
}
