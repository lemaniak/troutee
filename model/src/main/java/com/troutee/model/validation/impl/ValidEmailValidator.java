package com.troutee.model.validation.impl;

import com.troutee.model.validation.decl.ValidEmail;
import org.apache.commons.lang.StringUtils;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by vicente on 29/02/16.
 */
public class ValidEmailValidator implements ConstraintValidator<ValidEmail,String> {


    public void initialize(ValidEmail validEmail) {

    }

    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(!StringUtils.isBlank(value) && value.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            return true;
        }else{
            return false;
        }
    }
}
