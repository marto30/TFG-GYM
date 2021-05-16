package com.tema7.tema7ejemplo2.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tema7.tema7ejemplo2.R;

public class EmailFragment extends Fragment implements View.OnClickListener, DialogInterface.OnClickListener {

    private FloatingActionButton btnEmail;
    private TextView miEmail;
    private EditText nuevoEmail;
    private AlertDialog.Builder builder;
    public EmailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_email, container, false);
        btnEmail = (FloatingActionButton) view.findViewById(R.id.botonEmail);
        btnEmail.setOnClickListener(this);
        miEmail = (TextView)view.findViewById(R.id.textoEmail);
        return view;

    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if(i==DialogInterface.BUTTON_POSITIVE){

            String email = nuevoEmail.getText().toString();
            if(!email.isEmpty()){
                miEmail.setText(email);
            }
        }else if(i==DialogInterface.BUTTON_NEGATIVE){
            dialogInterface.cancel();
        }
    }

    @Override
    public void onClick(View view) {
        builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Ingresa tu correo");
        builder.setMessage("Escribe tu correo para ponerlo en la pantalla principal.");

        nuevoEmail=new EditText(getContext());
        nuevoEmail.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        builder.setView(nuevoEmail);

        builder.setPositiveButton("Aceptar correo", this);
        builder.setNegativeButton("Cancelar", this);
        builder.show();
    }
}