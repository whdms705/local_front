package com.example.front.dashboard.service;

public enum ClientType {
    AIRDATA_TYPE("AD");

    private String ClientType;

    ClientType(String ClientType){
        this.ClientType = ClientType;
    }

    public String getApiTypeCode(){
        return ClientType;
    }
}
