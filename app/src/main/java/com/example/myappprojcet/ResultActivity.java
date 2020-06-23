package com.example.myappprojcet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private Button butback;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        butback =(Button) findViewById(R.id.back);
        //get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        //get text view
        TextView t=(TextView)findViewById(R.id.textResult);
        //get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        //display score
        bar.setRating(score);
        switch (score)
        {
            case 0: t.setText("คะแนนของคุณ คือ 0 ");
                break;
            case 1: t.setText("คะแนนของคุณ คือ 1 ");
                break;
            case 2: t.setText("คะแนนของคุณ คือ 2 ");
                break;
            case 3: t.setText("คะแนนของคุณ คือ 3 ");
                break;
            case 4:t.setText("คะแนนของคุณ คือ 4 ");
                break;
            case 5:t.setText("คะแนนของคุณ คือ 5 ");
                break;
        }

        butback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(b);
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity_result, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            Intent settingsIntent = new Intent(this, QuizActivity.class);
//            startActivity(settingsIntent);
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
