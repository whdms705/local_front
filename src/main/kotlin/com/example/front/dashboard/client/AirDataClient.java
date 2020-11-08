package com.example.front.dashboard.client;

import com.example.front.dashboard.model.DashboardSearchDto;
import com.example.front.dashboard.service.AbstractApiCallResponseTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class AirDataClient extends AbstractApiCallResponseTemplate<DashboardSearchDto> {
    private final static Logger LOGGER = LoggerFactory.getLogger(AirDataClient.class);

    @Value("${api.call.url}")
    private String RESOURCE;

    @Override
    public String urlMake(DashboardSearchDto params) {
        String callUrl = "";
        if(params != null){
            callUrl = RESOURCE +"airs/"+ params.getStartDate()+"/"+params.getEndDate()+"/"+params.getStationName();
        }
        return callUrl;
    }
}
