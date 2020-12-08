package com.example.demo_library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.library.LoginActivity;

public class MainActivity extends AppCompatActivity {

    LoginActivity loginActivity = new LoginActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}