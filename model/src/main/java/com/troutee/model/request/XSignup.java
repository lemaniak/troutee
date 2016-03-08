package com.troutee.model.request;

import com.troutee.model.validation.decl.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vicente on 29/02/16.
 */
@XmlRootElement
public class XSignup {

    @NotNull(message = "{user.firstname.required}")
    @Size(min = 2, max = 50, message = "{user.firstname.invalid.size}")
    private String firstname;
    @NotNull(message = "{user.lastname.required}")
    @Size(min = 2, max = 50, message = "{user.lastname.invalid.size}")
    private String lastname;
    @ValidEmail
    private String email;
    @NotNull(message = "{user.password.required}")
    @Size(min = 2, max = 50, message = "{user.password.invalid.size}")
    private String password;
    private String image_url;

    public XSignup() {
    }

    public XSignup(String firstname, String lastname, String email, String password, String image_url) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.image_url = image_url;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
