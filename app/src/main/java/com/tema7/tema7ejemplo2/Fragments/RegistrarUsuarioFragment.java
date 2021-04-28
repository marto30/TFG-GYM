package com.tema7.tema7ejemplo2.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.tema7.tema7ejemplo2.R;

public class RegistrarUsuarioFragment extends AppCompatActivity {
    EditText usuMail, usuPass;
    Button btn_registrar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_registrar_usuario);

            usuMail =findViewById(R.id.usuMail);
        usuPass =findViewById(R.id.usuPass);
    }

   private void mensajeError(String error){

   }
}