package com.example.connectsalud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchHome(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void launchRegister(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}