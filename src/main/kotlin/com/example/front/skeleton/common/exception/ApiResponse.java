package com.example.front.skeleton.common.exception;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse<T> {
    T data;

    Map<String, Object> customHeader;
    HttpStatus httpStatus;

    public ApiResponse(ApiResponse<?> res) {
        if(res !=null){
            setHttpStatus(res.getHttpStatus());
        }
        setData(null);
    }

    public ApiResponse(@JsonProperty("data") T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    @JsonProperty("data")
    public void setData(T data) {
        this.data = data;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public int getHttpCode(){
        return this.httpStatus.value();
    }

    @JsonAnyGetter
    public Map<String, Object> getCustomHeader() {
        return customHeader;
    }

    public void setCustomHeader(Map<String, Object> customHeader) {
        this.customHeader = customHeader;
    }

    public void putAllCustomHeader(Map<String, Object> customHeader) {
        if(this.customHeader == null){
            this.customHeader = new HashMap<>();
        }

        this.customHeader.putAll(customHeader);
    }

    public void addCustomHeader(String key, Object value) {
        if(this.customHeader == null){
            this.customHeader = new HashMap<>();
        }

        this.customHeader.put(key,value);
    }


}
