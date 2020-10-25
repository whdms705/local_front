package com.example.front.skeleton.service;

import com.example.front.skeleton.client.SkeletonClient;
import com.example.front.skeleton.common.exception.ApiResponseException;
import com.example.front.skeleton.model.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SkeletonResponse {
    private final static Logger LOGGER = LoggerFactory.getLogger(SkeletonResponse.class);

    @Autowired
    private ClientFactory clientFactory;


    @Cacheable(value = "getSkeletonList" , keyGenerator = "skeletonKeyGenerator")
    public Map<String, Object> getList(){
        AbstractCallTemplate client = clientFactory.getClient(ApiType.SKELETON_TYPE.getApiTypeCode());
        Map<String, Object> params = new HashMap<>();
        params.put("serviceKey","");

        String callUrl = client.urlMake(params);
        Map<String, Object> lists = client.apiGetCall(callUrl);

        return lists;
    }
}
