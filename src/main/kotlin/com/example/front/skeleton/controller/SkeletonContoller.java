package com.example.front.skeleton.controller;


import com.example.front.skeleton.service.SkeletonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.*;

@EnableWebMvc
@Controller
public class SkeletonContoller {
    private final static Logger LOGGER = LoggerFactory.getLogger(SkeletonContoller.class);

    @Autowired
    private SkeletonResponse skeletonResponse;

    @Value("${password}")
    private String servicekey;

    @GetMapping("/demoUi")
    public ModelAndView getDemo(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashBoard");

        //Map demo = skeletonResponse.getList();

        Map<String, Object> map = new HashMap<>();
        map.put("name",servicekey);
        map.put("number",1);
        modelAndView.addObject("data", map);

        return modelAndView;
    }

}
