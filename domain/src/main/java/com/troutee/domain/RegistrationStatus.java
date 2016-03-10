package com.troutee.domain;

/**
 * Created by vicente on 25/02/16.
 */
public enum RegistrationStatus {
    REGISTERED("registered"),
    UNREGISTERED("unregistered");

    private RegistrationStatus(String value){
        this.value=value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static RegistrationStatus fromValue(String v){
        for(RegistrationStatus cs : RegistrationStatus.values()){
            if(cs.value.equals(v)){
                return cs;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
