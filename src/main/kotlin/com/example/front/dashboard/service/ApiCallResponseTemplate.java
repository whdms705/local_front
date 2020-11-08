package com.example.front.dashboard.service;

import com.example.front.dashboard.model.AirData;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ApiCallResponseTemplate<T> {
    ResponseEntity<T> getList(String url);
}
