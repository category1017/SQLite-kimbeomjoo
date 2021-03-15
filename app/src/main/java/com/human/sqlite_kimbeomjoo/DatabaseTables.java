package com.human.sqlite_kimbeomjoo;

import android.provider.BaseColumns;

/*
DatabaseTables 클래스는 물리테이블과 DAO클래스와 데이터연동할 때 필요
일반적인 용어로 Contract(계약서)라고 한다.
 */
public class DatabaseTables {
    //학생테이블용 필드값 클래스로 지정(Contract)
    //중첩클래스 데이터형클래스를 여러개 생성할때 필요한 클래스 구조: 관리향상
    public static class StudentTable implements BaseColumns{
        public static final String TABLE_NAME = "student";
        public static final String GRADE = "grade";
        public static final String NUMBER = "number";
        public static final String NAME = "name";
    }
}
