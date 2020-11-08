package com.example.front.dashboard.service;

import com.example.front.dashboard.model.AirData;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public abstract class AbstractApiCallResponseTemplate<T> implements ApiCallResponseTemplate{

    @Override
    public ResponseEntity<AirData> getList(String url) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);
        ResponseEntity<AirData> resultMap = restTemplate.exchange(url, HttpMethod.GET, entity, AirData.class);

        return resultMap;
    }

    public abstract String urlMake(T params);
}
