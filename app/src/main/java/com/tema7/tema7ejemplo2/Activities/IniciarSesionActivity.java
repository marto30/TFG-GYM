package com.tema7.tema7ejemplo2.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
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
import com.tema7.tema7ejemplo2.Validaciones.Validaciones;

public class IniciarSesionActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private String email, password;
    private EditText textEmail, textPassword;
    private Button btnIniciarSesion, btnResetPass, btnRegistrar;

    private Switch recordar;

    private SharedPreferences prefs;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        //Para inicializar la instancia de autenticación
        mAuth = FirebaseAuth.getInstance();
        //Referenciamos los objetos de la vista
        textEmail = (EditText) findViewById(R.id.textIniciarEmail);
        textPassword = (EditText) findViewById(R.id.textIniciarPassword);
        btnIniciarSesion = (Button) findViewById(R.id.btnIniciarLogin);
        btnRegistrar = (Button) findViewById(R.id.btnIniciarRegistrar);
        btnResetPass = (Button) findViewById(R.id.btnIniciarRecuperar);
        //admin= (TextView)findViewById(R.id.admin) ;
        //noAdmin= (TextView)findViewById(R.id.noAdmin) ;
        //recordar = (Switch)findViewById(R.id.remember_me_switch);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        //Acciones de cuando se oprime el boton login
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = textEmail.getText().toString();
                password = textPassword.getText().toString();
                if (!(email.isEmpty() && password.isEmpty())) {
                    Toast.makeText(getApplicationContext(), "Sesión iniciada correctamente", Toast.LENGTH_SHORT).show();
                    IniciarSesion();
                } else {
                    Toast.makeText(getApplicationContext(), "Es necesario rellenar los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Acción de el boton de restablecer contraseña
        btnResetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RecuperarPasswordActivity.class);
                startActivity(intent);
            }
        });

        //Acción que te envia el registro de usuarios
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistrarUsuariosActivity.class);
                startActivity(intent);
            }
        });

        //se auto-rellenan el email y contraseña en caso de haberse guardado
        //prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        //setCredentialsIfExist();
    }

    private void IniciarSesion() {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
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
                                    Intent intent = new Intent(getApplicationContext(), RegistrarUsuariosActivity.class);
                                    startActivity(intent);
                                } else if (tipo.equalsIgnoreCase("instructor")) {
                                    Intent intent = new Intent(getApplicationContext(), RegistrarInstructoresActivity.class);
                                    startActivity(intent);
                                } else if (tipo.equalsIgnoreCase("administrador")) {
                                    Intent intent = new Intent(getApplicationContext(), RegistrarAdminActivity.class);
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


            //método que guarda el email y contraseña introducidos
            private void saveOnPreferences(String email, String password) {
                if (recordar.isChecked()) {
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("email", email);
                    editor.putString("password", password);
                    editor.apply();

                } else {
                    Validaciones.removeSharedPreferences(prefs);
                }
            }

}
