package com.troutee.bussiness.model.request;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by vicente on 30/06/16.
 */
@XmlRootElement
public class XClientIds  extends XTokenRequest{

    @NotNull(message = "{client.ids.required}")
    private List<Integer> clientids;

    public XClientIds() {
    }

    public XClientIds(List<Integer> clientids) {
        this.clientids = clientids;
    }

    public List<Integer> getClientids() {
        return clientids;
    }

    public void setClientids(List<Integer> clientids) {
        this.clientids = clientids;
    }
}
