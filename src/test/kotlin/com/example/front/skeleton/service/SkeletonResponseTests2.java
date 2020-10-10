package com.example.front.skeleton.service;

import com.example.front.skeleton.model.Demo;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkeletonResponseTests2  extends TestCase {

    @Autowired
    private SkeletonResponse skeletonResponse;

    @Test
    public void 호출_테스트(){
        List<Demo> list = skeletonResponse.getList();

        assertTrue(list.size()>0);
    }
}
