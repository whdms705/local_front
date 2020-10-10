package com.example.front.skeleton.service;


import com.example.front.skeleton.client.SkeletonClient;
import com.example.front.skeleton.model.Demo;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkeletonResponseTests extends TestCase {

    @MockBean
    private SkeletonClient skeletonClient;

    @SpyBean
    private SkeletonResponse skeletonResponse;

    @Test
    public void skeletonResponse_cashing처리_혹인() {
        //given
        Map<String , Object> result = new HashMap<>();
        result.put("name","eunho");
        result.put("number",0L);

        //when
        when(skeletonClient.getDemo()).thenReturn(result);
        skeletonResponse.getList();
        skeletonResponse.getList();
        skeletonResponse.getList();


        //then
        // 1번 이하로 호출했는지 체크
        verify(skeletonResponse, atMostOnce()).getList();
    }

    @Test
    public void getList_호출_테스트(){

        Map<String , Object> result = new HashMap<>();
        result.put("name","eunho");
        result.put("number",0L);

        when(skeletonClient.getDemo()).thenReturn(result);

        //given
        List<Demo> list = skeletonResponse.getList();

        //then
        assertNotNull(list);
    }



}
