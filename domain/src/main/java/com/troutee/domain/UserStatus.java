package com.troutee.domain;

/**
 * Created by vicente on 25/02/16.
 */
public enum UserStatus {
    ACTIVE("active"),
    INACTIVE("inactive");

    private UserStatus(String value){
        this.value=value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static UserStatus fromValue(String v){
        for(UserStatus cs : UserStatus.values()){
            if(cs.value.equals(v)){
                return cs;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
