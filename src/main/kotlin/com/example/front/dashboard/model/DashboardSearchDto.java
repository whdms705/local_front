package com.example.front.dashboard.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DashboardSearchDto {

    private String stationName;

    private String startDate;

    private String endDate;

    private String isSearch = "N";

}
