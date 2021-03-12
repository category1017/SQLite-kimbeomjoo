package com.human.sqlite_kimbeomjoo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //현재클래스에서 사용할 멤버변수 생성(아래)
    private DatabaseHelper mDatabaseHelper; //우리가 만든
    private SQLiteDatabase mSqLiteDatabase; //안드로이드에서 만들어준
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //신규 데이터베이스 객체 생성=메모리에 올리기=실행가능하게 만들기(아래)
        //=데이터베이스헬퍼클래스의 생성자 메서드 실행
        mDatabaseHelper = new DatabaseHelper(this,"student.db",null,1);
        //데이터베이스 파일 만들기(아래)
        mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();
    }
}