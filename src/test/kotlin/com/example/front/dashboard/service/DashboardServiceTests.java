package com.example.front.dashboard.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DashboardServiceTests extends TestCase {

    @Autowired
    private DashboardService service;

    @Test
    public void 지역이름리스트_조회확인(){
        List<String> lists = service.getStationNames();
        assertNotNull(lists);
    }
}
