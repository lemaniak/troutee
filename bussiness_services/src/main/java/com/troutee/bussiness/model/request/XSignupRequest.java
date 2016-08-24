package com.troutee.bussiness.model.request;

import com.troutee.bussiness.validation.decl.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vicente on 29/02/16.
 */
@XmlRootElement
public class XSignupRequest {

    @NotNull(message = "{user.firstname.required}")
    @Size(min = 2, max = 50, message = "{user.firstname.invalid.size}")
    private String firstName;
    @NotNull(message = "{user.lastname.required}")
    @Size(min = 2, max = 50, message = "{user.lastname.invalid.size}")
    private String lastName;
    @ValidEmail(emailExistValidate = true)
    private String email;
    @NotNull(message = "{user.password.required}")
    @Size(min = 2, max = 50, message = "{user.password.invalid.size}")
    private String password;
    private byte[] image;

    public XSignupRequest() {
    }

    public XSignupRequest(String firstName, String lastName, String email, String password, byte[] image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.image = image;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
