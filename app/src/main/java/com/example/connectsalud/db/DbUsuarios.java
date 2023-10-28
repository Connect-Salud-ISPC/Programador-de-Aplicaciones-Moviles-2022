package com.example.connectsalud.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.connectsalud.Entidades.Usuarios;

import java.util.ArrayList;

public class DbUsuarios extends DbHelper {

    Context context;

    public DbUsuarios(@Nullable Context context) {
        super(context);
        this.context = context;
    }
}
