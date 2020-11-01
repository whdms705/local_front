package com.example.front.dashboard.controller;

import com.example.front.dashboard.common.exception.ApiException;
import com.example.front.dashboard.model.DashboardSearchDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DashboardControllerTestas {

    private WebApplicationContext context; // MockMvc 객체 생성을 위한 context
    private MockMvc mockMvc;

    @Rule
    public ExpectedException expectedExcetption = ExpectedException.none();

    @Autowired
    DashboardController dashboardController;	// 테스트를 진행할 controller

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(dashboardController).build();     // test를 위한 MockMvc 객체 생성. testController 1개만 주입.
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();  // test를 위한 MockMvc 객체 생성. 스프링이 로드한 WebApplicationContext의 인스턴스로 작동.(standaloneSetup() 중 택 1)
    }

    @Test
    public void test() throws Exception {
        expectedExcetption.expect(ApiException.class);

        mockMvc.perform(get("/ui")        // controller의 /test URI를 get방식으로 호출
                .param("stationName", "test")  // 파라미터 number1에 1 입력1입력
                ) // 파라미터 number2에
                .andDo(print())                        // 결과를 print. MockMvcBuilders의 alwaysDo(print())로 대체 가능
                .andExpect(status().isBadRequest());           // 호출 결과값이 OK가 나오면 정상처리
    }

}
