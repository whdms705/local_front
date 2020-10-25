package com.example.front.skeleton.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClientFactory {

    @Autowired
    @Qualifier("skeletonClient")
    private AbstractCallTemplate skeletonClient;

    @Autowired
    @Qualifier("demoClient")
    private AbstractCallTemplate demoClient;

    public AbstractCallTemplate getClient(String apiType){
        AbstractCallTemplate ret = null;
        switch (apiType){
            case "DM":
                ret = demoClient;
                break;
            case "ST":
                ret = skeletonClient;
                break;
            default:
                break;
        }

        return  Optional.ofNullable(ret)
                    .orElseThrow(() -> new NoSuchElementException(apiType+"에 해당하는 객체를 찾을 수 없습니다."));

    }
}
