package com.example.front.dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ApiCallResponseFactory {

    @Autowired
    AbstractApiCallResponseTemplate AirDataClient;


    public AbstractApiCallResponseTemplate getClient(String apiType){
        AbstractApiCallResponseTemplate ret = null;
        switch (apiType){
            case "AD":
                ret = AirDataClient;
                break;
            default:
                break;
        }

        return  Optional.ofNullable(ret)
                .orElseThrow(() -> new NoSuchElementException(apiType+"에 해당하는 객체를 찾을 수 없습니다."));

    }

}
