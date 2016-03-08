package com.troutee.api.exception;


import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class NotFoundException extends RuntimeException {
    private String message;

    public NotFoundException(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
