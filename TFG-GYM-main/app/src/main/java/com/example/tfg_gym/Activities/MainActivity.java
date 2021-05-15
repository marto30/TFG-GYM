package com.example.tfg_gym.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tfg_gym.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}