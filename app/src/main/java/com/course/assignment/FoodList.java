package com.course.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class FoodList extends AppCompatActivity {

    DBHelper helper;
    SQLiteDatabase db;

    String date;

    FoodAdapter adapter = new FoodAdapter();

    ImageButton btn_food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        helper = new DBHelper(this, "food.db", null, 1);
        db = helper.getWritableDatabase();

        Intent intent = getIntent();
        date = intent.getStringExtra("date");

        dbSelect();
        recyclerView.setAdapter(adapter);

        //식사 분석 버튼
        btn_food = findViewById(R.id.btn_food);

        btn_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodList.this, Research.class);

                for(int i = 0; i < adapter.getItemCount();i++) {
                    ArrayList<FoodItem> items = adapter.getItems();
                    intent.putExtra("food"+i, items.get(i).food_name);
                    intent.putExtra("number"+i,items.get(i).food_count);
                }
                intent.putExtra("length",adapter.getItemCount());
                startActivity(intent);
            }

        });
    }

    private void dbSelect() {
        String sql = "select * from food where date = \'" + date + "\';";
        Cursor cursor = db.rawQuery(sql, null);
        adapter.clear();

        while(cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String food_name = cursor.getString(1);
            String food_count = cursor.getString(2);
            String content = cursor.getString(3);
            String place = cursor.getString(4);
            String date = cursor.getString(5);
            String time = cursor.getString(6);
            byte[] image = cursor.getBlob(7);
            FoodItem item = new FoodItem(id, food_name, food_count, content, place, date, time, image);
            adapter.addItem(item);
        }
    }
}