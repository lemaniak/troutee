package com.troutee.bussiness.model.response;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by vicente on 27/06/16.
 */
@XmlRootElement
public class XClientsResponse {

    List<XClientResponse> clients;

    public XClientsResponse() {
    }

    public XClientsResponse(List<XClientResponse> clients) {
        this.clients = clients;
    }

    public List<XClientResponse> getClients() {
        return clients;
    }

    public void setClients(List<XClientResponse> clients) {
        this.clients = clients;
    }
}
