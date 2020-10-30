package com.example.front.dashboard.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class AirDataResponse {
    private ApiCallResponseFactory apiCallResponseFactory;

    public Map<String, Object> getList(Map<String, Object> params){
        AbstractApiCallResponseTemplate client = apiCallResponseFactory.getClient(ClientType.AIRDATA_TYPE.getApiTypeCode());

        String callUrl = client.urlMake(params);

        return null;
    }
}
