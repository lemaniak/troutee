package com.troutee.bussiness.model.response;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by vicente on 10/03/15.
 */

@XmlRootElement
public class XUserResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String image;
    private String createdAt;
    private String lastLogin;
    private String status;
    private String token;
    private int totalDevices;

    public XUserResponse() {
    }

    public XUserResponse(Integer id, String firstName, String lastName, String email, String image, String createdAt, String lastLogin, String status, String token, int totalDevices) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.image = image;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
        this.status = status;
        this.token = token;
        this.totalDevices = totalDevices;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getTotalDevices() {
        return totalDevices;
    }

    public void setTotalDevices(int totalDevices) {
        this.totalDevices = totalDevices;
    }
}
