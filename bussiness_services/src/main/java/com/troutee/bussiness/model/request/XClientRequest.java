package com.troutee.bussiness.model.request;

import com.troutee.bussiness.validation.decl.ValidClientId;
import com.troutee.bussiness.validation.decl.ValidLatitude;
import com.troutee.bussiness.validation.decl.ValidLongitude;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vicente on 27/06/16.
 */
@XmlRootElement
public class XClientRequest extends XTokenRequest{

    @ValidClientId
    private Integer id;
    @NotNull(message = "{client.code.required}")
    @Size(min = 2, max = 50, message = "{client.code.invalid.size}")
    private String code;
    @NotNull(message = "{client.name.required}")
    @Size(min = 2, max = 50, message = "{client.name.invalid.size}")
    private String name;
    private String phone;
    private String status;
    @ValidLatitude
    private double lat;
    @ValidLongitude
    private double lon;
    private Integer version;

    public XClientRequest() {
    }

    public XClientRequest(Integer id, String code, String name, String phone, String status, Double lat, Double lon, Integer version) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.status = status;
        this.lat = lat;
        this.lon = lon;
        this.version = version;
    }

    public XClientRequest(String token, Integer id, String code, String name, String phone, String status, Double lat, Double lon, Integer version) {
        super(token);
        this.id = id;
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.status = status;
        this.lat = lat;
        this.lon = lon;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
