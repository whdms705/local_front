package com.example.front.dashboard.service;

public enum LocalType {

    Seoul("서울","SU"),
    Busan("부산","BS"),
    Daegu("부산","DG"),
    Incheon("부산","IC"),
    Gwangju("부산","GJ"),
    Daejeon("대전","DJ"),
    Ulsan("울산","US"),
    Sejong("세종","SJ"),
    Gyeonggido("경기도","GGD"),
    Gangwon("강원","GW"),
    Chungbuk("충북","CB"),
    Chungnam("층남","CN"),
    Jeonbuk("전북","JB"),
    Jeonnam("전남","JN"),
    Gyeongbuk("경북","GB"),
    Gyeongnam("경남","GN"),
    Jeju("제주","JJ");

    private String localName;
    private String localCode;

    LocalType(String localName,String localCode){
        this.localName = localName;
        this.localCode = localCode;
    }

    public String getLocalName(){return localName;}

    public String getLocalCode(){return localCode;}
}
