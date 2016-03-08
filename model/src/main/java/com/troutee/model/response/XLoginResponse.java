package com.troutee.model.response;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by vicente on 10/03/15.
 */

@XmlRootElement
public class XLoginResponse extends XUserResponse{

    private String token;

    public XLoginResponse() {
    }

    public XLoginResponse(String token) {
        this.token = token;
    }

    public XLoginResponse(Integer id, String firstname, String lastname, String email, Date createdAt, String status, String token) {
        super(id, firstname, lastname, email, createdAt, status);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
