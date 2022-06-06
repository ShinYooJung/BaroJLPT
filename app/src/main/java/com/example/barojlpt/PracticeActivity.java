package com.example.barojlpt;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PracticeActivity extends AppCompatActivity {

    private static final String type1 = "유형1";
    private static final String type2 = "유형2";
    private static final String type3 = "유형3";
    private static final String type4 = "유형4";
    private static final String type5 = "유형5";

    TextView type;
    TextView question;
    Button answer1;
    Button answer2;
    Button answer3;
    Button answer4;
    TextView answer1_text;
    TextView answer2_text;
    TextView answer3_text;
    TextView answer4_text;

    QuestionDBHelper questionDBHelper;
    SimilarityDBHelper similarityDBHelper;
    SQLiteDatabase qDB;
    SQLiteDatabase sDB;

    private int q_id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        type = findViewById(R.id.type);
        question = findViewById(R.id.question);
        answer1 = findViewById(R.id.answer1_button);
        answer2 = findViewById(R.id.answer2_button);
        answer3 = findViewById(R.id.answer3_button);
        answer4 = findViewById(R.id.answer4_button);
        answer1_text = findViewById(R.id.answer1_text);
        answer2_text = findViewById(R.id.answer2_text);
        answer3_text = findViewById(R.id.answer3_text);
        answer4_text = findViewById(R.id.answer4_text);

        Intent intent = getIntent();
        int failedQ = intent.getExtras().getInt("q_id");

        questionDBHelper = new QuestionDBHelper(this, 1);
        qDB = questionDBHelper.getReadableDatabase();
        similarityDBHelper = new SimilarityDBHelper(this,1);
        sDB = similarityDBHelper.getReadableDatabase();
        Cursor cursor;

        if(failedQ == 0){
            cursor = qDB.rawQuery("SELECT q_id FROM Question ORDER BY RANDOM() LIMIT 1;", null);
            cursor.moveToFirst();
            q_id = cursor.getInt(0);
        }
        else{
            cursor = sDB.rawQuery("SELECT q_id2 FROM Similarity WHERE q_id1 = "+ failedQ +" ORDER BY similarity DESC",null);
            cursor.moveToFirst();
            q_id = cursor.getInt(0);
        }

        cursor = qDB.rawQuery("SELECT * FROM Question WHERE q_id = "+ q_id +"",null);
        cursor.moveToFirst();
        type.setText((cursor.getInt(1))+"");
        question.setText(cursor.getString(2));
        answer1_text.setText(cursor.getString(3));
        answer2_text.setText(cursor.getString(4));
        answer3_text.setText(cursor.getString(5));
        answer4_text.setText(cursor.getString(6));
        int correct_answer = cursor.getInt(7);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correct_answer == 1){
                    Toast.makeText(getApplicationContext(), "정답", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),PracticeActivity.class);
                    intent.putExtra("q_id",0);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "오답", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),PracticeActivity.class);
                    intent.putExtra("q_id",q_id);
                    startActivity(intent);
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correct_answer == 1){
                    Toast.makeText(getApplicationContext(), "정답", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),PracticeActivity.class);
                    intent.putExtra("q_id",0);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "오답", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),PracticeActivity.class);
                    intent.putExtra("q_id",q_id);
                    startActivity(intent);
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correct_answer == 1){
                    Toast.makeText(getApplicationContext(), "정답", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),PracticeActivity.class);
                    intent.putExtra("q_id",0);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "오답", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),PracticeActivity.class);
                    intent.putExtra("q_id",q_id);
                    startActivity(intent);
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correct_answer == 1){
                    Toast.makeText(getApplicationContext(), "정답", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),PracticeActivity.class);
                    intent.putExtra("q_id",0);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "오답", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),PracticeActivity.class);
                    intent.putExtra("q_id",q_id);
                    startActivity(intent);
                }
            }
        });

    }
}
