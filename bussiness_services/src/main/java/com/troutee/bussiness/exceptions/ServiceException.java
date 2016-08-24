package com.troutee.bussiness.exceptions;




import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class ServiceException extends RuntimeException {
    private String message;

    public ServiceException(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}