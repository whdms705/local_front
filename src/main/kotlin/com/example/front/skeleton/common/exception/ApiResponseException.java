package com.example.front.skeleton.common.exception;

import org.springframework.http.HttpMethod;

public class ApiResponseException extends Exception {

    String reponseString;
    ApiExceptionResponse response;
    int httpStatus;
    HttpMethod method;

    public ApiResponseException(Throwable cause){
        super(cause);
    }

    public ApiResponseException(ApiExceptionResponse response,String reponseString , int httpStatus ,HttpMethod httpMethod){
        setResponse(response);
        setHttpStatus(httpStatus);
        setReponseString(reponseString);
        setMethod(httpMethod);
    }

    public ApiResponseException(ApiExceptionResponse response,String reponseString , int httpStatus ,HttpMethod httpMethod,String message,Throwable cause){
        super(message,cause);
        setResponse(response);
        setHttpStatus(httpStatus);
        setReponseString(reponseString);
        setMethod(httpMethod);
    }

    public String getReponseString() {
        return reponseString;
    }

    public void setReponseString(String reponseString) {
        this.reponseString = reponseString;
    }

    public ApiExceptionResponse getResponse() {
        return response;
    }

    public void setResponse(ApiExceptionResponse response) {
        this.response = response;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public String getExceptionMessage(){
        if(response != null){
            return response.getExceptionMessage();
        }
        return null;
    }

    public Object getExceptionInfo(){
        if(response != null){
            return response.getExceptionInfo();
        }
        return null;
    }
}
