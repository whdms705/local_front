package com.example.front.skeleton.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DemoResponse {
    private final static Logger LOGGER = LoggerFactory.getLogger(DemoResponse.class);

    @Autowired
    private ClientFactory clientFactory;

    @Value("${api.serviceKey}")
    private String servicekey;

    @Cacheable(value = "getDemoList" , keyGenerator = "customerGenerator")
    public Map<String, Object> getList(){
        AbstractCallTemplate client = clientFactory.getClient(ApiType.DEMO_TYPE.getApiTypeCode());
        Map<String, Object> params = new HashMap<>();
        params.put("serviceKey",servicekey);

        String callUrl = client.urlMake(params);
        Map<String, Object> lists = client.apiGetCall(callUrl);

        return lists;
    }
}
