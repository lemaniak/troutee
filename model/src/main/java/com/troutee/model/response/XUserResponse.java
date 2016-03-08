package com.troutee.model.response;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by vicente on 10/03/15.
 */

@XmlRootElement
public class XUserResponse {

    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private Date createdAt;
    private String status;

    public XUserResponse() {
    }

    public XUserResponse(Integer id, String firstname, String lastname, String email, Date createdAt, String status) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.createdAt = createdAt;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
