package com.example.front.dashboard.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DashboardService {

    public List<String> getStationNames(){
        List<String> lists = Arrays.asList(LocalType.values())
                                                        .stream()
                                                        .map(s->s.getLocalName())
                                                        .collect(Collectors.toList());
        return lists;
    }
}
