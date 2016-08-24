package com.troutee.bussiness.validation.impl;

import com.troutee.bussiness.validation.decl.ValidLatitude;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by vicente on 29/02/16.
 */
public class ValidLatitudeValidator implements ConstraintValidator<ValidLatitude,Double> {


    public void initialize(ValidLatitude validCoordinate) {
    }

    public boolean isValid(Double value, ConstraintValidatorContext constraintValidatorContext) {
        if(value!= null &&  (value > -91 && value < 91) ){
            return true;
        }else{
            return false;
        }
    }
}
