package com.example.barojlpt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class QuestionDBHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "test.db"; // DBHelper 생성자. table마다 이름을 다르게 해야한다.

    public QuestionDBHelper(@Nullable Context context, int version) {
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE if not exists Question ("
                + "q_id integer primary key autoincrement,"
                + "type int,"
                + "txt text,"
                + "answer1 text,"
                + "answer2 text,"
                + "answer3 text,"
                + "answer4 text,"
                + "correctAnswer int);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE if exists Question";

        db.execSQL(sql);
        onCreate(db);
    }
}
