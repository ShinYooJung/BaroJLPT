package com.example.barojlpt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SimilarityDBHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "test1.db"; // DBHelper 생성자. table마다 이름을 다르게 해야한다.

    public SimilarityDBHelper(@Nullable Context context, int version) {
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE if not exists Similarity ("
                + "q_id1 int,"
                + "q_id2 int,"
                + "sim float,"
                + "PRIMARY KEY (q_id1, q_id2));";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE if exists Question";

        db.execSQL(sql);
        onCreate(db);
    }
}
