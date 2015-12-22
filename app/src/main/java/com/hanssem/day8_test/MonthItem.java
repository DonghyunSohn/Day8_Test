package com.hanssem.day8_test;

/**
 * Created by 20150090 on 2015-12-22.
 */
public class MonthItem {

    private int dayValue;
    private String weatherValue=null;//날씨정보

    public MonthItem() {

    }
    //날씨정보 저장을 위해 인자와 변수를 만들었다.
    public MonthItem(int day,String weather) {
        dayValue = day;
        weatherValue = weather;
    }


    public int getDay() {
        return dayValue;
    }

    public void setDay(int day) {
        this.dayValue = day;
    }


    public String getWeather() {//날씨가져오기
        return weatherValue;
    }

    public void setWeather(String weather) {	//날씨 넣어주기
        this.weatherValue = weather;
    }



}

