package com.example.front.dashboard.service;

import com.example.front.dashboard.common.exception.ApiException;
import com.example.front.dashboard.model.DashboardSearchDto;
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
    public void 대기오염_검색_피라미터_검증_startDate가없는경우_exception확인(){
        expectedExcetption.expect(ApiException.class);
        expectedExcetption.expectMessage("파라미터(startDate) 값이(null) 올바르지 않습니다.");

        // when
        DashboardSearchDto dto = new DashboardSearchDto();
        dto.setIsSearch("Y");

        // then
        service.ValidDashboardSearch(dto);
    }

    @Test
    public void 대기오염_검색_피라미터_검증_stationName가_null인경우_exception확인(){
        expectedExcetption.expect(ApiException.class);
        expectedExcetption.expectMessage("파라미터(startDate) 값이(null) 올바르지 않습니다.");

        // when
        DashboardSearchDto dto = new DashboardSearchDto();
        dto.setIsSearch("Y");
        dto.setStartDate("2020-10-10");
        dto.setEndDate("2020-10-10");

        // then
        service.ValidDashboardSearch(dto);
    }



}
