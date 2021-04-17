package com.example.tfg_gym.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.tema7.tema7ejemplo2.R;

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