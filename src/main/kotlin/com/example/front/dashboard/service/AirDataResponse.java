package com.example.front.dashboard.service;

import com.example.front.dashboard.model.AirData;
import com.example.front.dashboard.model.DashboardSearchDto;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AirDataResponse {
    private ApiCallResponseFactory apiCallResponseFactory;

    @Cacheable(value = "getAirDataList" , keyGenerator = "customerGenerator")
    public List<AirData> getList(DashboardSearchDto params){
        AbstractApiCallResponseTemplate client = apiCallResponseFactory.getClient(ClientType.AIRDATA_TYPE.getApiTypeCode());

        String callUrl = client.urlMake(params);
        ResponseEntity<AirData> response = client.getList(callUrl);

        return null;
    }
}
