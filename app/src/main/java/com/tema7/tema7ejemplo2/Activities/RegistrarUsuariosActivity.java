package com.tema7.tema7ejemplo2.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tema7.tema7ejemplo2.Activities.IniciarSesionActivity;
import com.tema7.tema7ejemplo2.R;

import java.util.HashMap;
import java.util.Map;

public class RegistrarUsuariosActivity extends AppCompatActivity {

    EditText textUsuNombre, textUsuApellidos, textUsuEmail, textUsuPassword, textUsuTelefono;
    Button btnUsuRegistrar;

    FirebaseAuth firebaseAuth;
    AwesomeValidation awesomeValidation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuarios);

        firebaseAuth = FirebaseAuth.getInstance();
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        //awesomeValidation.addValidation(this,R.id.textUsuNombre);
        awesomeValidation.addValidation(this, R.id.textUsuEmail, Patterns.EMAIL_ADDRESS, R.string.invalid_mail);
        awesomeValidation.addValidation(this, R.id.textUsuPassword, ".{6,}", R.string.invalid_password);


        textUsuEmail = findViewById(R.id.textUsuEmail);
        textUsuPassword = findViewById(R.id.textUsuPassword);
        btnUsuRegistrar = findViewById(R.id.btnUsuRegistrar);

        btnUsuRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = textUsuEmail.getText().toString();
                String pass = textUsuPassword.getText().toString();

                if (awesomeValidation.validate()) {
                    firebaseAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegistrarUsuariosActivity.this, "Enhorabuena, usuario creado con exito", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                String errorCode = ((FirebaseAuthException) task.getException()).getErrorCode();
                                dameToastdeerror(errorCode);
                            }
                        }
                    });
                } else {
                    Toast.makeText(RegistrarUsuariosActivity.this, "Completa todos los datos!!", Toast.LENGTH_SHORT).show();
                }
            }

            private void StartActivity(Intent i) {
            }
        });
    }

    private void dameToastdeerror(String error) {

    }
}