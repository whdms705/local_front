package com.example.front.skeleton.service;

public enum ApiType {
    SKELETON_TYPE("ST"),
    DEMO_TYPE("DM");

    private String apiTypeCode;

    ApiType(String apiTypeCode){
        this.apiTypeCode = apiTypeCode;
    }

    public String getApiTypeCode(){
        return apiTypeCode;
    }
}
