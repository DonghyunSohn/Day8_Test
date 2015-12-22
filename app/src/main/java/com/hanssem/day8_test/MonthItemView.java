package com.hanssem.day8_test;

import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 일자에 표시하는 텍스트뷰 정의
 *
 * @author Mike
 */


//텍스트뷰2개(날짜와 날씨)와이미지뷰1개(날씨아이콘)를 넣어주기위해 리니어 레이아웃으로~
public class MonthItemView extends LinearLayout {



    TextView text01;	//날짜용
    TextView text02;	//날씨용
    ImageView weatherImage;	//날씨아이콘용


    private MonthItem item;


    public MonthItemView(Context context) {
        super(context);

        init(context);
    }

    public MonthItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        setBackgroundColor(Color.WHITE);

        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.monthview,this,true);	//monthview.xml 인플레이터

        text01=(TextView) findViewById(R.id.text01);
        text02=(TextView) findViewById(R.id.text02);
        weatherImage=(ImageView)findViewById(R.id.weatherImage);

    }


    public MonthItem getItem() {
        return item;
    }

    public void setItem(MonthItem item) {
        this.item = item;
        int day = item.getDay();
        String saveWeather=item.getWeather(); //가져온 날씨정보

        if (day != 0) {
            text01.setText(String.valueOf(day));
            getweatherImage(saveWeather);	//아이콘 뿌려자
            text02.setText(saveWeather);	//텍스트도 뿌리자

        } else {
            text01.setText("");


        }

    }

    public void setTextColor(int color){
        text01.setTextColor(color);

    }



    public void getweatherImage(String weather){



        if(weather==null){//날씨정보 없을때
            weatherImage.setVisibility(View.INVISIBLE);	//기존에 디스플레이된것이 달을 옮겨도 따라다닌다
        }else{				//날씨정보 있을때				//새로운걸 뿌리는건 되지만 아무것도안하면 안지워지니깐
            weatherImage.setVisibility(View.VISIBLE);	//없을땐 가리고 있을땐 보여주고
            if(weather.toString().equals("맑음")){
                weatherImage.setImageResource(R.drawable.clear);
            }else if(weather.toString().equals("흐림")){
                weatherImage.setImageResource(R.drawable.cloudy);
            }else if(weather.toString().equals("구름 조금")){
                weatherImage.setImageResource(R.drawable.partly_cloudy);
            }else if(weather.toString().equals("구름 많음")){
                weatherImage.setImageResource(R.drawable.mostly_cloudly);
            }else if(weather.toString().equals("비")){
                weatherImage.setImageResource(R.drawable.rain);
            }else if(weather.toString().equals("눈")){
                weatherImage.setImageResource(R.drawable.snow);
            }else if(weather.toString().equals("눈/비")){
                weatherImage.setImageResource(R.drawable.snow_rain);
            }else{
                text02.setText("날씨아이콘 없음");
            }
        }


    }



}
