package com.troutee.converter.mappers;

import com.troutee.domain.Tuser;
import com.troutee.exceptions.ServiceException;
import com.troutee.model.request.XSignup;
import com.troutee.model.response.XUserResponse;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.dozer.MappingException;

import javax.ejb.Stateless;

/**
 * Created by vicente on 29/02/16.
 */
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

    public Tuser convertTo(XSignup signUp) {
        try{
            Tuser user= mapper.map(signUp, Tuser.class);
            return user;
        }catch(MappingException me){
            throw new ServiceException("troutee.general.error");
        }
    }
}
