package com.troutee.domain;

/**
 * Created by vicente on 25/02/16.
 */
public enum Status {
    REGISTERED("registered"),
    UNREGISTERED("unregistered");

    private Status(String value){
        this.value=value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static Status fromValue(String v){
        for(Status cs : Status.values()){
            if(cs.value.equals(v)){
                return cs;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
