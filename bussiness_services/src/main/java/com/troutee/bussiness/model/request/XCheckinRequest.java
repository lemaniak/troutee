package com.troutee.bussiness.model.request;

import com.troutee.bussiness.validation.decl.ValidClientId;
import com.troutee.bussiness.validation.decl.ValidLatitude;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vicente on 27/06/16.
 */
@XmlRootElement
public class XCheckinRequest extends XTokenRequest{

    @ValidClientId
    private Integer clientid;
    @ValidLatitude
    private Double lat;
    @ValidLatitude
    private Double lon;

    public XCheckinRequest() {
    }

    public XCheckinRequest(Integer clientid, Double lat, Double lon) {
        this.clientid = clientid;
        this.lat = lat;
        this.lon = lon;
    }

    public XCheckinRequest(String token, Integer clientid, Double lat, Double lon) {
        super(token);
        this.clientid = clientid;
        this.lat = lat;
        this.lon = lon;
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
