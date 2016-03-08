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
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author vicente
 */
@Entity
@Table(name = "device_distance", catalog = "troutee", schema = "troutee")
public class DeviceDistance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "distance")
    private double distance;
    @Basic(optional = false)
    @Column(name = "distance_unit")
    private String distanceUnit;
    @Basic(optional = false)
    @Column(name = "distance_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date distanceDate;
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    @ManyToOne
    private Device deviceId;

    public DeviceDistance() {
    }

    public DeviceDistance(Integer id) {
        this.id = id;
    }

    public DeviceDistance(Integer id, double distance, String distanceUnit, Date distanceDate) {
        this.id = id;
        this.distance = distance;
        this.distanceUnit = distanceUnit;
        this.distanceDate = distanceDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public Date getDistanceDate() {
        return distanceDate;
    }

    public void setDistanceDate(Date distanceDate) {
        this.distanceDate = distanceDate;
    }

    public Device getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Device deviceId) {
        this.deviceId = deviceId;
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
        if (DeviceDistance.class.isInstance(obj)) {
            DeviceDistance deviceDistance= DeviceDistance.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.id, deviceDistance.getId());
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
