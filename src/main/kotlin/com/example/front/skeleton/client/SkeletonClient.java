package com.example.front.skeleton.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SkeletonClient {
    private final static Logger LOGGER = LoggerFactory.getLogger(SkeletonClient.class);

    public Map<String , Object> getDemo(){
        LOGGER.info("getDemo");
        Map<String , Object> result = new HashMap<>();
        result.put("name","eunho");
        result.put("number",0L);
        return result;
    }

}
