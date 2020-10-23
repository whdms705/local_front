package com.example.front.dashboard.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class AbstractApiCallResponseTemplate implements ApiCallResponseTemplate{

    private RestTemplate restTemplate;

    @Override
    public List getList(String url) {
        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);
        ResponseEntity<Map> resultMap = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
        return null;
    }

    @Override
    public String urlMake(Map params) {
        return "";
    }
}
