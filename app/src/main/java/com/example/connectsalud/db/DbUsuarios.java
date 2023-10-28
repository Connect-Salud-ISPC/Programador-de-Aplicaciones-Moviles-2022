package com.example.connectsalud.db;

import android.content.Context;

import androidx.annotation.Nullable;

public class DbUsuarios extends DbHelper {

    Context context;

    public DbUsuarios(@Nullable Context context) {
        super(context);
        this.context = context;
    }
}
