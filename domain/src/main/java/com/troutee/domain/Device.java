/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.troutee.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author vicente
 */
@Entity
@Table(name = "device", catalog = "troutee", schema = "troutee")
public class Device implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "phone")
    private String phone;
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "track_unit")
    private String trackUnit;
    @Basic(optional = false)
    @Column(name = "track_value")
    private int trackValue;
    @Basic(optional = false)
    @Column(name = "track_start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trackStartTime;
    @Basic(optional = false)
    @Column(name = "track_end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trackEndTime;
    @Basic(optional = false)
    @Column(name = "track_status")
    @Enumerated(EnumType.STRING)
    private TrackStatus trackStatus;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private Tuser userId;

    public Device() {
    }

    public Device(Integer id) {
        this.id = id;
    }

    public Device(Integer id, String firstname, String lastname, String image, Status status, String phone, String code, String trackUnit, int trackValue, Date trackStartTime, Date trackEndTime, TrackStatus trackStatus, Tuser userId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.image = image;
        this.status = status;
        this.phone = phone;
        this.code = code;
        this.trackUnit = trackUnit;
        this.trackValue = trackValue;
        this.trackStartTime = trackStartTime;
        this.trackEndTime = trackEndTime;
        this.trackStatus = trackStatus;
        this.userId = userId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTrackUnit() {
        return trackUnit;
    }

    public void setTrackUnit(String trackUnit) {
        this.trackUnit = trackUnit;
    }

    public int getTrackValue() {
        return trackValue;
    }

    public void setTrackValue(int trackValue) {
        this.trackValue = trackValue;
    }

    public Date getTrackStartTime() {
        return trackStartTime;
    }

    public void setTrackStartTime(Date trackStartTime) {
        this.trackStartTime = trackStartTime;
    }

    public Date getTrackEndTime() {
        return trackEndTime;
    }

    public void setTrackEndTime(Date trackEndTime) {
        this.trackEndTime = trackEndTime;
    }

    public Tuser getUserId() {
        return userId;
    }

    public void setUserId(Tuser userId) {
        this.userId = userId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TrackStatus getTrackStatus() {
        return trackStatus;
    }

    public void setTrackStatus(TrackStatus trackStatus) {
        this.trackStatus = trackStatus;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(this.id);
        return hcb.toHashCode();
    }

    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (Device.class.isInstance(obj)) {
            Device device= Device.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.id, device.getId());
            equals = eb.isEquals();
        }
        return equals;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
    
}
