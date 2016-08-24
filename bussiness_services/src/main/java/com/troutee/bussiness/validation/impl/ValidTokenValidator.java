package com.troutee.bussiness.validation.impl;

import com.troutee.bussiness.exceptions.AuthorizationException;
import com.troutee.bussiness.beans.session.decl.SessionFinder;
import com.troutee.bussiness.exceptions.ValidationException;
import com.troutee.bussiness.util.CryptoUtils;
import com.troutee.bussiness.util.Utils;
import com.troutee.bussiness.validation.decl.ValidToken;
import com.troutee.domain.Session;
import com.troutee.domain.Status;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by vicente on 04/04/16.
 */
public class ValidTokenValidator  implements ConstraintValidator<ValidToken,String> {
    @Inject
    private SessionFinder sessionFinder;

    public void initialize(ValidToken validToken) {

    }

    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("{troutee.validation.token.required}").addConstraintViolation();
            return false;
        } else {
            Session session = sessionFinder.get(value);
            if (session.getStatus() == Status.INACTIVE) {
                throw new AuthorizationException("troutee.error.invalid_token");
            } else {
                String decryptedToken = CryptoUtils.decrypt(value);
                Boolean expired = Utils.isExpiredToken(decryptedToken);
                if (!expired) {
                    return true;
                } else {
                    throw new AuthorizationException("troutee.error.invalid_token");
                }
            }
        }
    }
}
