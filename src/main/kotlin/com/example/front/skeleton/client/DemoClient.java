package com.example.front.skeleton.client;

import com.example.front.skeleton.service.AbstractCallTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;




// ClientFactory 클래스 예시를 위한 클래스
// 국내 카운터
@Component
public class DemoClient extends AbstractCallTemplate {
    private final static String RESOURCE = "https://api.corona-19.kr/korea/?";

    @Override
    public String urlMake(Map<String, Object> params) {
        String callUrl = "";
        if(!params.isEmpty()){
            callUrl = RESOURCE +"serviceKey="+ params.get("serviceKey");
        }
        return callUrl;
    }
}
