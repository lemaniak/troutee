package com.troutee.domain;

/**
 * Created by vicente on 25/02/16.
 */
public enum ClientStatus {
    UPDATED("updated"),
    NOT_UPDATED("not_updated");

    private ClientStatus(String value){
        this.value=value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static ClientStatus fromValue(String v){
        for(ClientStatus cs : ClientStatus.values()){
            if(cs.value.equals(v)){
                return cs;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
