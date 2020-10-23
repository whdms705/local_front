package com.example.front.skeleton.service;

import com.example.front.skeleton.client.SkeletonClient;
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
    private SkeletonClient skeletonClient;


    @Cacheable(value = "getSkeletonList" , keyGenerator = "skeletonKeyGenerator")
    public Map<String, Object> getList(){
        System.out.println(123);
        Map<String, Object> params = new HashMap<>();
        params.put("serviceKey","4f6f76ee9c6c53ca2a7f2e5fd367a2697");
        String callUrl = skeletonClient.urlMake(params);
        Map<String, Object> lists = skeletonClient.apiCall(callUrl);

        return lists;
    }
}
