package com.troutee.model.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vicente on 01/03/16.
 */
@XmlRootElement
public class XBaseResponse {

    private String data_type;
    private Object data;

    public XBaseResponse(String data_type, Object data) {
        this.data_type = data_type;
        this.data = data;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
