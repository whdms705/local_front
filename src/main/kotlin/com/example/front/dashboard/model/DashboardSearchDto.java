package com.example.front.dashboard.model;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class DashboardSearchDto {
    @NotNull
    private String stationName;
    @NotNull
    private String startDate;
    @NotNull
    private String endDate;
}
