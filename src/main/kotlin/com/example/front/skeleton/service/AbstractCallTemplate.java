package com.example.front.skeleton.service;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.*;
import org.springframework.http.MediaType;

public abstract class AbstractCallTemplate implements CallTemplate {

    @Override
    public Map<String, Object> apiCall(String url) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
System.out.printf("url "+url);
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        return response;
    }

    public abstract String urlMake(Map<String, Object> params);

}
