package com.troutee.converter.mappers;


import com.troutee.domain.UserStatus;
import com.troutee.exceptions.ServiceException;
import org.dozer.CustomConverter;

import javax.ejb.Stateless;

/**
 * Created by vicente on 17/03/15.
 */
@Stateless
public class UserStatusConverter implements CustomConverter {

    @Override
    public Object convert(Object destination, Object source, Class destClass, Class sourceClass) {
        if (source == null) {
            return null;
        }

        try{
            if(source instanceof String){
                return UserStatus.fromValue((String) source);
            }else if(source instanceof  UserStatus){
                return ((UserStatus) source).getValue();
            }
        }catch(Exception ex){
            throw new ServiceException("bussiness exception error mapping objects User Status Enum");
        }
        return null;
    }
}
