package com.example.front.dashboard.service;

import com.example.front.dashboard.common.error.ErrorMessage;
import com.example.front.dashboard.common.exception.ApiException;
import com.example.front.dashboard.model.AirData;
import com.example.front.dashboard.model.DashboardSearchDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DashboardService {

    private AirDataResponse airDataResponse;


    public List<String> getStationNames(){
        List<String> lists = Arrays.asList(LocalType.values())
                                                        .stream()
                                                        .map(s->s.getLocalName())
                                                        .collect(Collectors.toList());
        return lists;
    }

    /*public List<AirData> GetAirData(DashboardSearchDto dto){

    }*/

    public void ValidDashboardSearch(DashboardSearchDto dto , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            FieldError error = bindingResult.getFieldError();
            throw new ApiException(
                    String.format(ErrorMessage.INVALID_PARAMETER.getErrorMessage(),error.getField())
                    , HttpStatus.BAD_REQUEST);
        }

    }
}
