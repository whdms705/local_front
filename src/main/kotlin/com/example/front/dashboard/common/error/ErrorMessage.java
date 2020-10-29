package com.example.front.dashboard.common.error;

public enum ErrorMessage {
    INVALID_PARAMETER("파라미터(%s) 값이 올바르지 않습니다.");

    private String errorMessage;

    ErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){return errorMessage;}
}
