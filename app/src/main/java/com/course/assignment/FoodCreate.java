package com.course.assignment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class FoodCreate extends AppCompatActivity {

    DBHelper helper;
    SQLiteDatabase db;
    ImageButton btnCamera, saveButton;
    ImageView imageView;
    Bitmap imageBitmap;
    EditText foodNameEditText, foodCountEditText, contentEditText, timeEditText;
    Intent mainIntent;
    String selectedPlace;
    RadioButton radio_1, radio_2, radio_3;
    Button place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_create);

        // db 생성
        helper = new DBHelper(this, "food.db", null, 1);
        db = helper.getWritableDatabase();
        mainIntent = getIntent();

        btnCamera = findViewById(R.id.imageButton);
        imageView = findViewById(R.id.imageView);
        saveButton = findViewById(R.id.imageButton2);
        foodCountEditText = findViewById(R.id.foodCountEditText);
        foodNameEditText = findViewById(R.id.foodNameEditText);
        contentEditText = findViewById(R.id.contentEditText);
        timeEditText = findViewById(R.id.timeText);

        radio_1 = findViewById(R.id.radio_1);
        radio_2 = findViewById(R.id.radio_2);
        radio_3 = findViewById(R.id.radio_3);

        place = findViewById(R.id.placeButton);
        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radio_1.isChecked()) {
                    selectedPlace = "상록원 1층";
                } else if (radio_2.isChecked()) {
                    selectedPlace = "상록원 2층";
                } else if (radio_3.isChecked()) {
                    selectedPlace = "기숙사 식당";
                }
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 카메라 촬영 클릭 이벤트
                // 카메라 기능을 Intent
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, 0);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(selectedPlace) || TextUtils.isEmpty(timeEditText.getText().toString())
                        || imageBitmap == null || TextUtils.isEmpty(foodCountEditText.getText().toString())
                        || TextUtils.isEmpty(foodNameEditText.getText().toString())
                        || TextUtils.isEmpty(contentEditText.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "입력되지 않은 값이 존재합니다!!!", Toast.LENGTH_LONG).show();
                    return;
                }

                ContentValues values = new ContentValues();
                values.put("food_name", foodNameEditText.getText().toString());
                values.put("food_count", foodCountEditText.getText().toString());
                values.put("place", selectedPlace);
                values.put("content", contentEditText.getText().toString());

                String date = mainIntent.getStringExtra("date");
                if (TextUtils.isEmpty(date)) {
                    Toast.makeText(getApplicationContext(), "날짜 정보가 없습니다!", Toast.LENGTH_LONG).show();
                    return;
                }
                values.put("date", date);

                values.put("time", timeEditText.getText().toString());
                byte[] image = getByteFromBitmap(imageBitmap);
                values.put("image", image);

                db.insert("food", null, values);
                Toast.makeText(getApplicationContext(), "성공적으로 저장되었습니다.", Toast.LENGTH_LONG).show();
                db.close();
                finish();
            }
        });
    }

    public byte[] getByteFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        return stream.toByteArray();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 카메라 촬영을 하면 이미지뷰에 사진 삽입
        if (requestCode == 0 && resultCode == RESULT_OK) {
            // Bundle로 데이터를 입력
            Bundle extras = data.getExtras();

            // Bitmap으로 컨버전
            imageBitmap = (Bitmap) extras.get("data");

            // 이미지뷰에 Bitmap으로 이미지를 입력
            imageView.setImageBitmap(imageBitmap);
        }
    }
}
