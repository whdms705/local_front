package com.example.front.dashboard.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AirData {

    private Long seq;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime dataTime;

    private Double so2Value;

    private Double coValue;

    private Double o3Value;

    private Double no2Value;

    private Double pm10Value;

    private Double pm10value24;

    private Double pm25Value;

    private Double pm25Value24;

    private Double khaiValue;

    private Double khaiGrade;

    private Double so2Grade;

    private Double coGrade;

    private Double o3Grade;

    private Double no2Grade;

    private Double pm10Grade;

    private Double pm25Grade;

    private Double pm10Grade1h;

    private Double pm25Grade1h;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime regdate;

    private String stationName;
}
