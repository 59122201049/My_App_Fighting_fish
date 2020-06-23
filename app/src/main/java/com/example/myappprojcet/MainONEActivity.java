package com.example.myappprojcet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainONEActivity extends AppCompatActivity {
    private Button butgo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_one);
        butgo =(Button) findViewById(R.id.buttonGO);
        butgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(go);
            }
        });
    }
}
