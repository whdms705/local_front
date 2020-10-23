package com.example.front.skeleton.common.exception;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiExceptionResponse extends ApiResponse<Object> {

    String exceptionMessage;
    String exception;
    String exceptionCode;
    Object exceptionInfo;

    Map<String, Object> customHeader;

    public ApiExceptionResponse(ApiResponse<?> res){
        super(res);
    }

    public ApiExceptionResponse(){
        super(null);
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public Object getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(Object exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    @JsonAnyGetter
    public Map<String, Object> getCustomHeader() {
        return customHeader;
    }

    public void setCustomHeader(Map<String, Object> customHeader) {
        this.customHeader = customHeader;
    }

    public void addCustomHeader(String key, Object value) {
        if(this.customHeader == null){
            this.customHeader = new HashMap<>();
        }

        this.customHeader.put(key,value);
    }
}
