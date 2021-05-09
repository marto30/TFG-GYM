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

    private FirebaseAuth mAuth;

    private String email, contrasena;

    private EditText textEmail, textPassword;

    private void login() {
        mAuth.signInWithEmailAndPassword(email, contrasena).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    saveOnPreferences(textEmail.getText().toString().trim(), textPassword.getText().toString().trim());
                    mAuth = FirebaseAuth.getInstance();
                    FirebaseUser user = mAuth.getCurrentUser();
                    DatabaseReference mDataBase = FirebaseDatabase.getInstance().getReference();

                    //Comando para buscar los  en la DDBB los datos solicitados
                    mDataBase.child("Usuarios").child(user.getUid()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                String tipo = dataSnapshot.child("tipo").getValue().toString();
                                if (tipo.equalsIgnoreCase("usuario")) {
                                    Intent intent = new Intent(getApplicationContext(), HomeUser.class);
                                    startActivity(intent);
                                } else if (tipo.equalsIgnoreCase("instructor")) {
                                    Intent intent = new Intent(getApplicationContext(), HomeAdmin.class);
                                    startActivity(intent);
                                } else if (tipo.equalsIgnoreCase("administrador")) {
                                    Intent intent = new Intent(getApplicationContext(), HomeAdmin.class);
                                    startActivity(intent);
                                }
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Error al autenticar datos, compruebe sus datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveOnPreferences(String trim, String trim1) {
    }
}
