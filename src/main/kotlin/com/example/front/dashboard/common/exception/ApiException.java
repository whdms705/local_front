package com.example.front.dashboard.common.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends AbstractException{
    String exceptionCode;

    String exceptionInfo;

    boolean logable = false;

    public ApiException(Throwable cause , HttpStatus httpStatus){
        super(cause);
    }

    private HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    public boolean isLogable() {
        return logable;
    }

    public void setLogable(boolean logable) {
        this.logable = logable;
    }
}
