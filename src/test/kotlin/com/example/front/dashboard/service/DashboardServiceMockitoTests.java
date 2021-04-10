package com.example.front.dashboard.service;

import com.example.front.dashboard.model.AirData;
import com.example.front.dashboard.model.DashboardSearchDto;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class DashboardServiceMockitoTests extends TestCase {

    @Mock
    private AirDataResponse airDataResponse;

    @InjectMocks
    private DashboardService service;

    @Test
    @DisplayName("airData 조회")
    public void getStationNames() {
        List<AirData> airDatas = new ArrayList<>();
        AirData dummy1 = new AirData();
        AirData dummy2 = new AirData();
        airDatas.add(dummy1);
        airDatas.add(dummy2);

        given(airDataResponse.getList(new DashboardSearchDto())).willReturn(airDatas);

        List<AirData> response = service.GetAirData(new DashboardSearchDto());
        System.out.println(1);

    }

}
