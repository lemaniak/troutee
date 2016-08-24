package com.troutee.bussiness.converter.mappers;


import com.troutee.bussiness.exceptions.ServiceException;
import com.troutee.bussiness.util.Utils;
import com.troutee.domain.Status;
import org.dozer.CustomConverter;

import javax.ejb.Stateless;
import java.util.Date;

/**
 * Created by vicente on 17/03/15.
 */
@Stateless
public class DateConverter implements CustomConverter {


    public Object convert(Object destination, Object source, Class destClass, Class sourceClass) {
        if (source == null) {
            return null;
        }

        try{
            Date date = (Date) source;
            return Utils.dateToSimpleString(date);
        }catch(Exception ex){
            throw new ServiceException("bussiness exception error mapping objects User RegistrationStatus Enum");
        }
    }
}
