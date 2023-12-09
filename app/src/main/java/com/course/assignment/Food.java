
package com.course.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Food extends AppCompatActivity {

    TextView name;
    TextView count;
    TextView content;
    TextView place;
    TextView date;
    TextView time;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Intent intent = getIntent();

        name = findViewById(R.id.textView1);
        count = findViewById(R.id.textView2);
        content = findViewById(R.id.textView3);
        place = findViewById(R.id.textView4);
        date = findViewById(R.id.textView5);
        time = findViewById(R.id.textView6);
        image = findViewById(R.id.imageView2);

        name.setText(intent.getStringExtra("food_name"));
        count.setText(intent.getStringExtra("food_count"));
        content.setText(intent.getStringExtra("content"));
        place.setText(intent.getStringExtra("place"));
        date.setText(intent.getStringExtra("date"));
        time.setText(intent.getStringExtra("time"));
        byte[] b = intent.getByteArrayExtra("image");
        Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
        image.setImageBitmap(bitmap);

    }
}