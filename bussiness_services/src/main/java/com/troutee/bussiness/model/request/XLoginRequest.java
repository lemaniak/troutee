package com.troutee.bussiness.model.request;



import com.troutee.bussiness.validation.decl.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vicente on 02/03/16.
 */
@XmlRootElement
public class XLoginRequest {

    @NotNull(message = "{user.email.required}")
    @ValidEmail
    private String email;
    @NotNull(message = "{user.password.required}")
    @Size(min = 2, max = 50, message = "{user.password.invalid.size}")
    private String password;

    public XLoginRequest() {
    }

    public XLoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
