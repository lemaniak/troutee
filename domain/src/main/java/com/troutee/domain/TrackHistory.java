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
@Table(name = "track_history", catalog = "troutee", schema = "troutee")
public class TrackHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "track_first_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trackFirstTimestamp;
    @Column(name = "track_last_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trackLastTimestamp;
    @Basic(optional = false)
    @Column(name = "lat")
    private double lat;
    @Basic(optional = false)
    @Column(name = "lon")
    private double lon;
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    @ManyToOne
    private Device deviceId;


    public TrackHistory() {
    }

    public TrackHistory(Integer id) {
        this.id = id;
    }

    public TrackHistory(Integer id, Date trackFirstTimestamp, double lat, double lon) {
        this.id = id;
        this.trackFirstTimestamp = trackFirstTimestamp;
        this.lat = lat;
        this.lon = lon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTrackFirstTimestamp() {
        return trackFirstTimestamp;
    }

    public void setTrackFirstTimestamp(Date trackFirstTimestamp) {
        this.trackFirstTimestamp = trackFirstTimestamp;
    }

    public Date getTrackLastTimestamp() {
        return trackLastTimestamp;
    }

    public void setTrackLastTimestamp(Date trackLastTimestamp) {
        this.trackLastTimestamp = trackLastTimestamp;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
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
        if (TrackHistory.class.isInstance(obj)) {
            TrackHistory trackHistory= TrackHistory.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.id, trackHistory.getId());
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
