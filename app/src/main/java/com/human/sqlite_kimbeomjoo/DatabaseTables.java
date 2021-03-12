package com.human.sqlite_kimbeomjoo;

import android.provider.BaseColumns;

/*
DatabaseTables 클래스는 물리테이블과 DAO클래스와 데이터연동할 때 필요
일반적인 용어로 Contract(계약서)라고 한다.
 */
public class DatabaseTables {
    //학생테이블용 필드값 클래스로 지정(Contract)
    public static class StudentTable implements BaseColumns{
        public static final String TABLE_NAME = "student";
        public static final String GRADE = "grade";
        public static final String NUMBER = "number";
        public static final String NAME = "name";
    }
}
