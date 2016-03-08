package com.troutee.api.util;

/**
 * Created by vicente on 01/03/16.
 */
public class ErrorData {

    private String error;
    private Integer code;

    public ErrorData(String error, Integer code) {
        this.error = error;
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
