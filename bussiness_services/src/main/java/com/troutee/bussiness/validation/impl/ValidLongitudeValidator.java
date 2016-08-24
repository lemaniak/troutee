package com.troutee.bussiness.validation.impl;

import com.troutee.bussiness.validation.decl.ValidLongitude;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by vicente on 29/02/16.
 */
public class ValidLongitudeValidator implements ConstraintValidator<ValidLongitude,Double> {


    public void initialize(ValidLongitude validCoordinate) {
    }

    public boolean isValid(Double value, ConstraintValidatorContext constraintValidatorContext) {
        if(value!= null &&  (value > -181 && value < 181) ){
            return true;
        }else{
            return false;
        }
    }
}
