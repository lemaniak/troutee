package com.troutee.bussiness.model.request;

import com.troutee.bussiness.validation.decl.ValidToken;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vicente on 02/03/16.
 */
@XmlRootElement
public class XTokenRequest {

    @ValidToken
    private String token;

    public XTokenRequest() {
    }

    public XTokenRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

