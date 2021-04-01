package com.example.sqlitetrial;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "User.db";
    public static String TABLE_NAME = "User";
    public static String COL_NAME = "Name";
    public static String COL_AGE = "Age";
    public static String COL_ID = "Id";
    public static int VERSION = 1;
    public String create_table = " create table User(Id integer primary key,Name text,Age text)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertData(String name, String age){

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME,name);
        contentValues.put(COL_AGE,age);
        SQLiteDatabase sqLiteDatabase =getWritableDatabase();
        long id =sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
        return id;

    }
}
