package com.example.tfg_gym;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.tema7.tema7ejemplo2.R;

public class RegistrarUsuariosActivity extends AppCompatActivity {
    EditText usuMail, usuPass;
    Button btn_registrar;

    //aRCHIVOA ddbb
    FirebaseAuth firebaseAuth;
    AwesomeValidation awesomeValidation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuarios);

        firebaseAuth = FirebaseAuth.getInstance();
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.usuMail, Patterns.EMAIL_ADDRESS,R.string.invalid_mail);
        awesomeValidation.addValidation(this,R.id.usuPass,".{6,}",R.string.invalid_password);

        usuMail = findViewById(R.id.usuMail);
        usuPass = findViewById(R.id.usuPass);
        btn_registrar = findViewById(R.id.btn_registrar);

        btn_registrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String mail= usuMail.getText().toString();
                String pass= usuPass.getText().toString();

                if (awesomeValidation.validate()){
                    firebaseAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(RegistrarUsuariosActivity.this,"Enhorabuena, usuario creado con exito", Toast.LENGTH_SHORT).show();
                                finish();
                            }else{
                                String errorCode= ((FirebaseAuthException) task.getException()).getErrorCode();
                                dameToastdeerror(errorCode);
                            }
                        }
                    });
                }else{
                    Toast.makeText(RegistrarUsuariosActivity.this,"Completa todos los datos!!", Toast.LENGTH_SHORT).show();
                }
            }

            private void StartActivity(Intent i) {
            }
        });
    }

    private void dameToastdeerror(String error){

    }
}