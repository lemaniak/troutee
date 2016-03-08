package com.troutee.converter.mappers;

import com.troutee.domain.Tuser;
import com.troutee.exceptions.ServiceException;
import com.troutee.model.request.XSignup;
import com.troutee.model.response.XLoginResponse;
import com.troutee.model.response.XUserResponse;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.dozer.MappingException;

import javax.ejb.Stateless;

/**
 * Created by vicente on 29/02/16.
 */
@Stateless
public class LoginMapper {
    private Mapper mapper= DozerBeanMapperSingletonWrapper.getInstance();

    public XLoginResponse convertFrom(Tuser user) {
        try{
            XLoginResponse loginResponse= mapper.map(user, XLoginResponse.class);
            return loginResponse;
        }catch (MappingException me){
            throw new ServiceException("troutee.general.error");
        }

    }

    public Tuser convertTo(XLoginResponse loginResponse) {
        try{
            Tuser user= mapper.map(loginResponse, Tuser.class);
            return user;
        }catch(MappingException me){
            throw new ServiceException("troutee.general.error");
        }
    }
}
