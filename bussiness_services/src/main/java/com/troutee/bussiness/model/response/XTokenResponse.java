package com.troutee.bussiness.model.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vicente on 04/04/16.
 */
@XmlRootElement
public class XTokenResponse {

    private String token;
    private Boolean valid;

    public XTokenResponse() {
    }

    public XTokenResponse(String token, Boolean valid) {
        this.token = token;
        this.valid = valid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean isValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
