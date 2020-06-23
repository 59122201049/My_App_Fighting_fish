package com.example.myappprojcet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myappprojcet.data.DbHelper;

import java.util.List;

public class QuizActivity extends AppCompatActivity {
    List<Question> quesList;
    int score = 0;
    int qid = 0;
    Question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    Button butNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        DbHelper db = new DbHelper(this);
        quesList = db.getAllQuestions();
        currentQ = quesList.get(qid);
        txtQuestion = (TextView) findViewById(R.id.textView1);
        rda = (RadioButton) findViewById(R.id.radio0);
        rdb = (RadioButton) findViewById(R.id.radio1);
        rdc = (RadioButton) findViewById(R.id.radio2);
        butNext = (Button) findViewById(R.id.button1);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup1);
                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                grp.clearCheck();
                Log.d("yourans", currentQ.getANSWER() + " " + answer.getText());
                if (currentQ.getANSWER().equals(answer.getText())) {
                    score++;
                    Log.d("score", "Your score" + score);
                }
                if (qid < 5) {
                    currentQ = quesList.get(qid);
                    setQuestionView();
                } else {
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);
                    finish();
                }
            }
        });
    }


    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity_quiz, menu);
//        return true;
//    }
    private void setQuestionView() {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        qid++;
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