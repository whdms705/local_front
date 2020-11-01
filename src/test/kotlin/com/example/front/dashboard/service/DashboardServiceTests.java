package com.example.front.dashboard.service;

import com.example.front.dashboard.common.exception.ApiException;
import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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

    @Rule
    public ExpectedException expectedExcetption = ExpectedException.none();

    @Test
    public void 지역이름리스트_조회확인(){
        // when
        List<String> lists = service.getStationNames();

        // then
        assertNotNull(lists);
    }

    @Test
    public void 대기오염_검색_피라미터_검증_exception확인(){
        expectedExcetption.expect(ApiException.class);
        //expectedExcetption.expectMessage("");

        //
        //service.ValidDashboardSearch();
    }



}
