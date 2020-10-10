package com.example.front.skeleton.controller;

import com.example.front.skeleton.model.Demo;
import com.example.front.skeleton.service.SkeletonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api")
public class DemoContoller {
    private final static Logger LOGGER = LoggerFactory.getLogger(DemoContoller.class);

    @Autowired
    private SkeletonResponse skeletonResponse;

    @GetMapping("/demo")
    public List<Demo> getDemo(){
        return skeletonResponse.getList();
    }
}
