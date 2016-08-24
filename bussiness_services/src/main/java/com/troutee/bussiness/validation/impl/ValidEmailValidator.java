package com.troutee.bussiness.validation.impl;

import com.troutee.bussiness.beans.user.decl.UserFinder;
import com.troutee.bussiness.validation.decl.ValidEmail;
import org.apache.commons.lang.StringUtils;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by vicente on 29/02/16.
 */
public class ValidEmailValidator implements ConstraintValidator<ValidEmail,String> {

    @Inject
    private UserFinder userFinder;

    private boolean emailExistValidate;

    public void initialize(ValidEmail validEmail) {
        this.emailExistValidate=validEmail.emailExistValidate();
    }

    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(!StringUtils.isBlank(value) && value.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            if(emailExistValidate && userFinder.isEmailRegistered(value)){
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate("{user.email.already.in.use}").addConstraintViolation();
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
}
