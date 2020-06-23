package com.example.myappprojcet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BubbleActivity extends AppCompatActivity {

    private ListView listView;
    List<Betta> bettas = new ArrayList<>();
    int dataSize;
    public Betta listBetta = new Betta();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble);
        listView = (ListView) findViewById(R.id.list_item);
        initInstances();


    }

    private void initInstances() {

        prepareData();

        ListAdapter adapter = new ListAdapter(BubbleActivity.this, listBetta);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listViewClickListener);

    }

    private void prepareData() {

        int resId[] = {R.drawable.f1, R.drawable.f2, R.drawable.f3, R.drawable.f4
                , R.drawable.f5};

        String breed[] = {"ปลากัดป่าภาคกลางและภาคเหนือ(ปลากัดแก้มแดง)", "ปลากัดป่าภาคอีสาน(ปลากัดกีตาร์)", "ปลากัดป่าภาคใต้(ปลากัดแก้มเขียว)", "ปลากัดป่ามหาชัย",
                 "ปลากัดป่าภาคตะวันออก"};

        String description[] = {getString(R.string.t1), getString(R.string.t2), getString(R.string.t3), getString(R.string.t4)
                , getString(R.string.t5),};
        dataSize = resId.length;

//
//        Log.d("khem", "dataSize " + resId.length);
//        Log.d("khem", "breed " + resId.length);
//        Log.d("khem", "description " + resId.length);



        for (int i = 0; i < dataSize; i++) {
//            Log.d("khem", " " + i);
            Betta betta = new Betta(resId[i], breed[i], description[i]);
            bettas.add(betta);
        }

        listBetta.setBettas(bettas);

        //Log.d("khem",listDog);
    }

    /*************************
     * Listener
     ***************************/

    AdapterView.OnItemClickListener listViewClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            Toast.makeText(BubbleActivity.this, "POSITION:= " + position,
//                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(BubbleActivity.this,ShowActivity.class);
            intent.putExtra("resId",listBetta.getBettas().get(position).getResId());
            intent.putExtra("breed",listBetta.getBettas().get(position).getBreed());
            intent.putExtra("desc",listBetta.getBettas().get(position).getDescription());

            startActivity(intent);
        }
    };



}
