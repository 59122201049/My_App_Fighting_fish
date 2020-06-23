package com.example.myappprojcet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MouthActivity extends AppCompatActivity {
    private ListView aa;
    List<Bettatwo> bettatwos = new ArrayList<>();
    int dataSize1;
    public Bettatwo listBettatwo = new Bettatwo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mouth);
        aa = (ListView) findViewById(R.id.list_itemtwo);
        initInstances1();


    }

    private void initInstances1() {

        prepareData1();

        ListAdaptertwo adaptertwo = new ListAdaptertwo(MouthActivity.this, listBettatwo);

        aa.setAdapter(adaptertwo);
        aa.setOnItemClickListener(listViewClickListener);

    }

    private void prepareData1() {

        int resId1[] = {R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4
                , R.drawable.b5,R.drawable.b6};

        String breed1[] = {"ปลากัดอมไข่ภาคตะวันออก(ปลากัดหัวโม่งจันทบุรี)", "ปลากัดอมไข่ภาคใต้(ปลากัดอมไข่กระบี่)", "ปลากัดอมไข่น้ำแดงหรือป่าพรุ(ปลากัดช้าง)", "ปลากัดอมไข่ภูเขา",
                "ปลากัดอมไข่ อะพอล์ลอน","ปลากัดอมไข่สงขลา(ปลากัดฟีร็อกซ์)"};

        String description1[] = {getString(R.string.tt1), getString(R.string.tt2), getString(R.string.tt3), getString(R.string.tt4)
                , getString(R.string.tt5),getString(R.string.tt6),};
        dataSize1 = resId1.length;

//
//        Log.d("khem", "dataSize " + resId.length);
//        Log.d("khem", "breed " + resId.length);
//        Log.d("khem", "description " + resId.length);



        for (int i = 0; i < dataSize1; i++) {
//            Log.d("khem", " " + i);
            Bettatwo bettatwo = new Bettatwo (resId1[i], breed1[i], description1[i]);
            bettatwos.add(bettatwo);
        }

        listBettatwo.setBettastwos(bettatwos);

        //Log.d("khem",listDog);
    }

    /*************************
     * Listener
     ***************************/

    AdapterView.OnItemClickListener listViewClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            Toast.makeText(MouthActivity.this, "POSITION:= " + position,
//                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MouthActivity.this,ShowtwoActivity.class);
            intent.putExtra("resId1",listBettatwo.getBettatwos().get(position).getResId1());
            intent.putExtra("breed1",listBettatwo.getBettatwos().get(position).getBreed1());
            intent.putExtra("desc1",listBettatwo.getBettatwos().get(position).getDescription1());

            startActivity(intent);
        }
    };


}
