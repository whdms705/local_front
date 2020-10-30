package com.example.front.dashboard.client;

import com.example.front.dashboard.service.AbstractApiCallResponseTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AirDataClient extends AbstractApiCallResponseTemplate {
    private final static Logger LOGGER = LoggerFactory.getLogger(AirDataClient.class);

    @Value("${api.call.url}")
    private String RESOURCE;

    @Override
    public String urlMake(Map params) {
        String callUrl = "";
        if(!params.isEmpty()){
            callUrl = RESOURCE +"airs/"+ params.get("startDate")+"/"+params.get("endDate")+"/"+params.get("stationName");
        }
        return callUrl;
    }
}
