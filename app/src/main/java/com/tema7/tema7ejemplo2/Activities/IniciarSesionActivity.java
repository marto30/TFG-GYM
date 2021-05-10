package com.tema7.tema7ejemplo2.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tema7.tema7ejemplo2.R;

public class IniciarSesionActivity extends AppCompatActivity {

    Button btnLogin, btnRegistrar, btnRecuperar;
    EditText loginEmail, loginPass;

    FirebaseAuth firebaseAuth;
    AwesomeValidation awesomeValidation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        firebaseAuth = FirebaseAuth.getInstance();
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        loginEmail = findViewById(R.id.textIniciarEmail);
        loginPass = findViewById(R.id.textIniciarPassword);

        btnLogin = findViewById(R.id.btnIniciarLogin);
        btnRegistrar = findViewById(R.id.btnIniciarRegistrar);
        btnRecuperar = findViewById(R.id.btnIniciarRecuperar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(IniciarSesionActivity.this, RegistrarUsuariosActivity.class);
                StartActivity(i);
            }

            private void StartActivity(Intent i) {
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }//Fin de OnCreate

   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_iniciar_sesion, container, false);
    }*/

    private void mensajeError(String error) {

    }
}