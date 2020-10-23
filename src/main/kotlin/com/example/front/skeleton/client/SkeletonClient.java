package com.example.front.skeleton.client;

import com.example.front.skeleton.service.AbstractCallTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SkeletonClient  extends AbstractCallTemplate {
    private final static Logger LOGGER = LoggerFactory.getLogger(SkeletonClient.class);
    private final static String RESOURCE = "http://api.corona-19.kr/korea/country/new/?";

    @Override
    public String urlMake(Map<String, Object> params) {
        String callUrl = "";
        if(!params.isEmpty()){
            callUrl = RESOURCE +"serviceKey="+ params.get("serviceKey");
        }
        return callUrl;
    }
}
