package com.troutee.bussiness.model.request;


import com.troutee.bussiness.validation.decl.ValidToken;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vicente on 10/03/15.
 */

@XmlRootElement
public class XUpdatePasswordRequest {

    @NotNull(message = "{user.id.required}")
    private Integer id;
    @NotNull(message = "{user.password.required}")
    @Size(min = 2, max = 50, message = "{user.password.invalid.size}")
    private String password;
    @ValidToken
    private String token;

    public XUpdatePasswordRequest() {
    }

    public XUpdatePasswordRequest(Integer id, String password, String token) {
        this.id = id;
        this.password = password;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
