package com.example.front.dashboard.service;

import java.util.List;
import java.util.Map;

public interface ApiCallResponseTemplate<T> {
    List<T> getList(String url);
}
