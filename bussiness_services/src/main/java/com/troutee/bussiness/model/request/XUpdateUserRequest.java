package com.troutee.bussiness.model.request;

import com.troutee.bussiness.validation.decl.ValidToken;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vicente on 10/03/15.
 */

@XmlRootElement
public class XUpdateUserRequest {

    @NotNull(message = "{user.id.required}")
    private Integer id;
    @NotNull(message = "{user.email.required}")
    private String email;
    @NotNull(message = "{user.firstname.required}")
    @Size(min = 2, max = 50, message = "{user.firstname.invalid.size}")
    private String firstName;
    @NotNull(message = "{user.lastname.required}")
    @Size(min = 2, max = 50, message = "{user.lastname.invalid.size}")
    private String lastName;
    private byte[] image;
    @ValidToken
    private String token;

    public XUpdateUserRequest() {
    }

    public XUpdateUserRequest(Integer id, String email, String firstName, String lastName,  byte[] image, String token) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
