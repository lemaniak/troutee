package com.troutee.bussiness.model.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vicente on 30/06/16.
 */
@XmlRootElement
public class XClientVersion {
    private Integer clientid;
    private Integer versionid;

    public XClientVersion() {
    }

    public XClientVersion(Integer clientid, Integer versionid) {
        this.clientid = clientid;
        this.versionid = versionid;
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public Integer getVersionid() {
        return versionid;
    }

    public void setVersionid(Integer versionid) {
        this.versionid = versionid;
    }
}
