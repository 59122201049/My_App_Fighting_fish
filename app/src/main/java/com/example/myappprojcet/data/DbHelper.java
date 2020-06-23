package com.example.myappprojcet.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myappprojcet.Question;

import java.util.ArrayList;
import java.util.List;

import static com.example.myappprojcet.data.QuizContract.MovieEntry.KEY_ANSWER;
import static com.example.myappprojcet.data.QuizContract.MovieEntry.KEY_ID;
import static com.example.myappprojcet.data.QuizContract.MovieEntry.KEY_OPTA;
import static com.example.myappprojcet.data.QuizContract.MovieEntry.KEY_OPTB;
import static com.example.myappprojcet.data.QuizContract.MovieEntry.KEY_OPTC;
import static com.example.myappprojcet.data.QuizContract.MovieEntry.KEY_QUES;
import static com.example.myappprojcet.data.QuizContract.MovieEntry.TABLE_QUEST;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "aa";
    // tasks table name

    private SQLiteDatabase dbase;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_QUES + " TEXT, " +
                KEY_ANSWER+ " TEXT, "+
                KEY_OPTA +" TEXT, " +
                KEY_OPTB +" TEXT, "+
                KEY_OPTC+" TEXT)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }
    private void addQuestions()
    {
        Question q1=new Question("สัตว์น้ำประจำชาติไทยคือสัตว์ชนิดใด?","ช้าง", "ปลากัด", "ปลาตีน", "ปลากัด");
        this.addQuestion(q1);
        Question q2=new Question("ปลากัดกีตาร์พบได้ในภาคไหนของประเทศไทย?", "ภาคกลางและเหนือ", "ภาคอีสาน", "ภาคใต้", "ภาคอีสาน");
        this.addQuestion(q2);
        Question q3=new Question("ปลากัด หรือ เบ็ตต้า (ชื่อทางวิทยาศาสตร์ Betta splendens) ได้คำว่า เบ็ตต้า มาจากอะไร ?","มาจากนักรบเอเชียโบราณเบ็ตตาช(Bettah)", "มาจากนักรบแอฟริกาโบราณ เบ็ตตาช(Bettah)","มาจากนักรบยุโรปโบราณ เบ็ตตาช(Bettah)", "มาจากนักรบเอเชียโบราณเบ็ตตาช(Bettah)" );
        this.addQuestion(q3);
        Question q4=new Question("ปลากัดไทยได้เป็นสัตว์น้ำประจำชาติเมื่อวันที่?", "5 กุมภาพันธ์ 2562", "14 กุมภาพันธ์ 2562", "16 กุมภาพันธ์ 2562","5 กุมภาพันธ์ 2562");
        this.addQuestion(q4);
        Question q5=new Question("คณะรัฐมนตรี ได้พิจารณาให้ปลากัดไทยเป็นสัตว์น้ำประจำชาติ โดยพิจารณาองค์ประกอบสำคัญกี่มิติ ","1 มิติ","2 มิติ","3 มิติ","3 มิติ");
        this.addQuestion(q5);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }


    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}
