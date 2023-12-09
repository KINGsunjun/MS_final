package com.course.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Research extends AppCompatActivity {

    TextView text;
    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    int cal = 0;
    int sum_cal = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research);
        ArrayList array = new ArrayList();
        Intent intent = getIntent();

        text = findViewById(R.id.textView8);

        int a = intent.getIntExtra("length",0);
        for(int i = 0; i<a; i++) {
            array.add(intent.getStringExtra("food"+i));
            if(intent.getStringExtra("food"+i).equals("ramen")){
                cal = 300*Integer.parseInt(intent.getStringExtra("number"+i));
                array.add(" : ");
                array.add(Integer.toString(cal));
                array.add("\n");
                sum_cal += cal;
            }
            if(intent.getStringExtra("food"+i).equals("cupbap") ){
                cal = 460*Integer.parseInt(intent.getStringExtra("number"+i));
                array.add(" : ");
                array.add(Integer.toString(cal));
                array.add("\n");
                sum_cal += cal;
            }
            if(intent.getStringExtra("food"+i).equals("초코우유")){
                cal = 350*Integer.parseInt(intent.getStringExtra("number"+i));
                array.add(" : ");
                array.add(Integer.toString(cal));
                array.add("\n");
                sum_cal += cal;
            }

            if(intent.getStringExtra("food"+i).equals("치킨")){
                cal = 1900*Integer.parseInt(intent.getStringExtra("number"+i));
                array.add(" : ");
                array.add(Integer.toString(cal));
                array.add("\n");
                sum_cal += cal;
            }

            if(intent.getStringExtra("food"+i).equals("오예스")){
                cal = 150*Integer.parseInt(intent.getStringExtra("number"+i));
                array.add(" : ");
                array.add(Integer.toString(cal));
                array.add("\n");
                sum_cal += cal;
            }

            if(intent.getStringExtra("food"+i).equals("짜파구리")){
                cal = 860*Integer.parseInt(intent.getStringExtra("number"+i));
                array.add(" : ");
                array.add(Integer.toString(cal));
                array.add("\n");
                sum_cal += cal;
            }

            if(intent.getStringExtra("food"+i).equals("된장찌개")){
                cal = 300*Integer.parseInt(intent.getStringExtra("number"+i));
                array.add(" : ");
                array.add(Integer.toString(cal));
                array.add("\n");
                sum_cal += cal;
            }

            if(intent.getStringExtra("food"+i).equals("커피")){
                cal = 10*Integer.parseInt(intent.getStringExtra("number"+i));
                array.add(" : ");
                array.add(Integer.toString(cal));
                array.add("\n");
                sum_cal += cal;
            }

        }
        array.add("\n종합 칼로리 : ");
        array.add(Integer.toString(sum_cal));
        String ab = null;
        for(int j = 0; j<array.size();j++){
            ab = String.join(" ",array);
        }
        text.setText(ab);
    }
}