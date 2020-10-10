package com.example.front.skeleton.service;

import com.example.front.skeleton.client.SkeletonClient;
import com.example.front.skeleton.model.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class SkeletonResponse {
    private final static Logger LOGGER = LoggerFactory.getLogger(SkeletonResponse.class);

    @Autowired
    private SkeletonClient skeletonClient;


    @Cacheable(value = "getSkeletonList" , keyGenerator = "skeletonKeyGenerator")
    public List<Demo> getList(){
        System.out.println(123);
        Map<String , Object> demoInfo = skeletonClient.getDemo();

        List<Demo> lists = new ArrayList<>();
        Demo demo = new Demo();
        demo.setName((String)demoInfo.get("name"));
        demo.setNumber((long)demoInfo.get("number"));
        lists.add(demo);

        return lists;
    }
}
