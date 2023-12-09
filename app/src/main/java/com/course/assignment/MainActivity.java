package com.course.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public CalendarView calendarView;
    public TextView diaryTextView;
    public ImageButton save_Btn, move_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);  // 캘린더
        diaryTextView = findViewById(R.id.diaryTextView);  // 선택한 날짜 출력
        save_Btn=findViewById(R.id.save_Btn); // 식사 입력 페이지 이동
        move_Btn = findViewById(R.id.move_Btn); // 저장된 식사 리스트 액티비티 이동

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                diaryTextView.setText(String.format("%d / %d / %d",year,month+1,dayOfMonth));
                save_Btn.setVisibility(View.VISIBLE);
                move_Btn.setVisibility(View.VISIBLE);
            }
        });

        save_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FoodCreate.class);
                String date = diaryTextView.getText().toString();
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });

        move_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FoodList.class);
                String date = diaryTextView.getText().toString();
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });
    }
}