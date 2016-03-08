package com.troutee.model.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vicente on 01/03/16.
 */
@XmlRootElement
public class XBaseErrorResponse {

    private Integer code;
    private String errorMessage;

    public XBaseErrorResponse(Integer code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
