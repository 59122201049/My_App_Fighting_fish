package com.example.myappprojcet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowtwoActivity extends AppCompatActivity {
    private int resId1;
    private String breed1;
    private String description1;
    private ImageView imageView1;
    private TextView tvDescription1;
    private TextView tvBreed1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showtwo);
        initInstances1();
    }
    private void initInstances1() {

        resId1 = getIntent().getIntExtra("resId1",0);
        breed1 = getIntent().getStringExtra("breed1");
        description1 = getIntent().getStringExtra("desc1");

        tvDescription1 = (TextView) findViewById(R.id.desc1);
        tvBreed1 = (TextView) findViewById(R.id.title1);
        imageView1 = (ImageView) findViewById(R.id.image1);

        tvDescription1.setText(description1);
        tvBreed1.setText(breed1);
        imageView1.setImageResource(resId1);
    }
}
