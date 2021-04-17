package com.example.tfg_gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.tema7.tema7ejemplo2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil_cliente);
        SharedPreferences mPrefs =  PreferenceManager.getDefaultSharedPreferences(this);

    }


}