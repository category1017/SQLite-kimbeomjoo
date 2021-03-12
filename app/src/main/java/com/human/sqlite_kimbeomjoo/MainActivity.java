package com.human.sqlite_kimbeomjoo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.human.sqlite_kimbeomjoo.DatabaseTables.StudentTable;
public class MainActivity extends AppCompatActivity {
    //현재클래스에서 사용할 멤버변수 생성(아래)
    private DatabaseHelper mDatabaseHelper; //우리가 만든
    private SQLiteDatabase mSqLiteDatabase; //안드로이드에서 만들어준//sql템플릿(insert,select...)이 여기 포함
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //신규 데이터베이스 객체 생성=메모리에 올리기=실행가능하게 만들기(아래)
        //=데이터베이스헬퍼클래스의 생성자 메서드 실행
        mDatabaseHelper = new DatabaseHelper(this,"student.db",null,1);
        //데이터베이스 파일 만들기(아래)
        mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();
        //테스트로 mSqliteDatabse 객체를 이용해서 더미데이터 인서트 테스트
        //자바의 HashMap형식과 비슷한 안드로이드 데이터형 ContentValues형
        ContentValues contentValues = new ContentValues();
        contentValues.put(StudentTable.GRADE,2);
        contentValues.put(StudentTable.NUMBER,20210002);
        contentValues.put(StudentTable.NAME,"김범주");
        mSqLiteDatabase.insert(StudentTable.TABLE_NAME,null,contentValues);
    }
}