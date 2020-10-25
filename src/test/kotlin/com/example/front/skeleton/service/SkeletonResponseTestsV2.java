package com.example.front.skeleton.service;

import com.example.front.skeleton.client.SkeletonClient;
import com.example.front.skeleton.common.exception.ApiResponseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkeletonResponseTestsV2 {
    @Autowired
    private SkeletonClient skeletonClient;

    @Autowired
    private SkeletonResponse skeletonResponse;

    @Test
    public void getList_호출_테스트() throws ApiResponseException {
        Map<String, Object> list = skeletonResponse.getList();
        System.out.println(list);
    }
}
