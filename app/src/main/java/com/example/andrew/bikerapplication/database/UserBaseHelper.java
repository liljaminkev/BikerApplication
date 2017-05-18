package com.example.andrew.bikerapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.andrew.bikerapplication.database.UserDbSchema;

/**
 * Created by kevinchan on 5/17/17.
 */

public class UserBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "bikerDatabase.db";

    public UserBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + UserTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                UserTable.Cols.UUID + ", " +
                UserTable.Cols.TITLE + ", " +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
