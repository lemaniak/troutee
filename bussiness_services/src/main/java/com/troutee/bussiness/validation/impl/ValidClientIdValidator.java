package com.troutee.bussiness.validation.impl;

import com.troutee.bussiness.beans.client.decl.ClientFinder;
import com.troutee.bussiness.beans.session.decl.SessionFinder;
import com.troutee.bussiness.exceptions.AuthorizationException;
import com.troutee.bussiness.exceptions.ValidationException;
import com.troutee.bussiness.util.CryptoUtils;
import com.troutee.bussiness.util.Utils;
import com.troutee.bussiness.validation.decl.ValidClientId;
import com.troutee.bussiness.validation.decl.ValidToken;
import com.troutee.domain.Client;
import com.troutee.domain.Session;
import com.troutee.domain.Status;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by vicente on 04/04/16.
 */
public class ValidClientIdValidator implements ConstraintValidator<ValidClientId,Integer> {
    @Inject
    private ClientFinder clientFinder;

    public void initialize(ValidClientId validClientId) {

    }

    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if(value==null){
             throw new ValidationException("client.id.invalid");
        }else{
            Client client = clientFinder.find_by_id(value);
            if(client==null){
                throw new ValidationException("client.id.invalid");
            }else{
                return true;
            }
        }
    }
}
