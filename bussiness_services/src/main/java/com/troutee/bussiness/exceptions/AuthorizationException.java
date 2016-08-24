package com.troutee.bussiness.exceptions;




import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class AuthorizationException extends RuntimeException {
    private String message;

    public AuthorizationException(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}