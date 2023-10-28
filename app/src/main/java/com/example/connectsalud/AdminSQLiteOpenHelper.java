package com.example.connectsalud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    // crear constructor:
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // crear tablas de la DB:
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table usuarios (\n" +
                "\tdni integer primary key,\n" +
                "\tnombre text,\n" +
                "\tapellido text,\n" +
                "\ttelefono integer,\n" +
                "\tnacimiento text,\n" +
                "\temail text,\n" +
                "\tpass text,\n" +
                "\tpassagain text\n" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}