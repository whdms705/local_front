package com.example.front.dashboard.service;

public enum LocalType {

    Seoul("서울"),
    Busan("부산"),
    Daegu("대구"),
    Incheon("부산"),
    Gwangju("광주"),
    Daejeon("대전"),
    Ulsan("울산"),
    Sejong("세종"),
    Gyeonggido("경기도"),
    Gangwon("강원"),
    Chungbuk("충북"),
    Chungnam("층남"),
    Jeonbuk("전북"),
    Jeonnam("전남"),
    Gyeongbuk("경북"),
    Gyeongnam("경남"),
    Jeju("제주");

    private String localName;

    LocalType(String localName){
        this.localName = localName;
    }

    public String getLocalName(){return localName;}
}
