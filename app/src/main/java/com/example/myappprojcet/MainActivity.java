package com.example.myappprojcet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }



    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent item1 = new Intent(this, MainActivity.class);
                startActivity(item1);
                Toast.makeText(this, "หน้าแรก", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Intent item2 = new Intent(this, maintwoActivity.class);
                startActivity(item2);
                Toast.makeText(this, "สายพันธุ์ปลากัดไทย", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item3:
                Intent item3 = new Intent(this, MainfourActivity.class);
                startActivity(item3);
                Toast.makeText(this, "วิธีการเลี้ยงและคำแนะนำ", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item4:
                Intent item4 = new Intent(this, QuizActivity.class);
                startActivity(item4);
                Toast.makeText(this, "แบบทดสอบ", Toast.LENGTH_SHORT).show();
                return true;


            default:
                return super.onOptionsItemSelected(item);



        }
    }
}