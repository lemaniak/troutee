package com.troutee.bussiness.exceptions;




import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class ValidationException extends RuntimeException {
    private String message;

    public ValidationException(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}