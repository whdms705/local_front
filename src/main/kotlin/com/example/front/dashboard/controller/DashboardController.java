package com.example.front.dashboard.controller;


import com.example.front.dashboard.model.DashboardSearchDto;
import com.example.front.dashboard.service.DashboardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/ui")
@AllArgsConstructor
public class DashboardController {

    private DashboardService service;

    @GetMapping("")
    public ModelAndView index(@Valid @ModelAttribute DashboardSearchDto params, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashBoard");
        Map<String, Object> map = new HashMap<>();
        map.put("station",service.getStationNames());

        if("Y".equals(params.getIsSearch())){
            service.ValidDashboardSearch(params);
            map.put("air",service.GetAirData(params));
        }

        modelAndView.addObject("data", map);
        return modelAndView;
    }

}