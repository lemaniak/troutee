package com.troutee.bussiness.validation.impl;

import com.troutee.bussiness.validation.decl.ValidSize;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by vicente on 04/04/16.
 */
public class ValidSizeValidator implements ConstraintValidator<ValidSize,String> {
    private int min;

    private int max;

    public void initialize(ValidSize validSize) {
        min=validSize.min();
        max=validSize.max();
    }

    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value!=null && !value.isEmpty()){
            if(value.length() < min || value.length() > max){
                return false;
            }else{
                return true;
            }
        }else{
            return true;
        }
    }
}
