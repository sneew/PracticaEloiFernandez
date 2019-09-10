package com.example.practicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InspirActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspir);

        getSupportActionBar().setTitle(R.string.inspira);
    }
}
