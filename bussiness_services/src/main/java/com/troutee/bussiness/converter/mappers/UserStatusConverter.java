package com.troutee.bussiness.converter.mappers;


import com.troutee.bussiness.exceptions.ServiceException;
import com.troutee.domain.Status;
import org.dozer.CustomConverter;

import javax.ejb.Stateless;

/**
 * Created by vicente on 17/03/15.
 */
@Stateless
public class UserStatusConverter implements CustomConverter {


    public Object convert(Object destination, Object source, Class destClass, Class sourceClass) {
        if (source == null) {
            return null;
        }

        try{
            if(source instanceof String){
                return Status.fromValue((String) source);
            }else if(source instanceof Status){
                return ((Status) source).getValue();
            }
        }catch(Exception ex){
            throw new ServiceException("bussiness exception error mapping objects User RegistrationStatus Enum");
        }
        return null;
    }
}
