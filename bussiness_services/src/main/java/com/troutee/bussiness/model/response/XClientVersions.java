package com.troutee.bussiness.model.response;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by vicente on 30/06/16.
 */
@XmlRootElement
public class XClientVersions {
    private List<XClientVersion> clientVersions;
    private String clientids;

    public XClientVersions() {
    }

    public XClientVersions(List<XClientVersion> clientVersions) {
        this.clientVersions = clientVersions;
    }

    public List<XClientVersion> getClientVersions() {
        return clientVersions;
    }

    public void setClientVersions(List<XClientVersion> clientVersions) {
        this.clientVersions = clientVersions;
    }

    public String getClientids() {
        return clientids;
    }

    public void setClientids(String clientids) {
        this.clientids = clientids;
    }
}
