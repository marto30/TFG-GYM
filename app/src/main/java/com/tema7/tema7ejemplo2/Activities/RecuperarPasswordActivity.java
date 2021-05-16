package com.tema7.tema7ejemplo2.Activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import com.tema7.tema7ejemplo2.R;

public class RecuperarPasswordActivity extends AppCompatActivity {

    private EditText textOlvidadoEmail;
    private Button btnReset;

    private String email = "";
    private FirebaseAuth mAuth;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_password);
        mAuth=FirebaseAuth.getInstance();
        mDialog= new ProgressDialog(this);
        textOlvidadoEmail=(EditText)findViewById(R.id.resetPassEmail);
        btnReset=(Button)findViewById(R.id.resetPassBtn);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = textOlvidadoEmail.getText().toString();
                if(!email.isEmpty()){
                    if(email.contains("@")){
                        mDialog.setMessage("Espera mientras verificamos los datos...");
                        mDialog.setCanceledOnTouchOutside(false);
                        mDialog.show();
                        reset();
                    }
                    Toast.makeText(getApplicationContext(), "El email debe contener '@'", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Debe ingresar el email", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void reset(){
        mAuth.setLanguageCode("es");
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Se ha enviado un correo de verificación para reestablecer la contraseña", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Error, No se pudo enviar el correo de reestablecimiento de contraseña", Toast.LENGTH_SHORT).show();
                }
                mDialog.dismiss();
            }
        });
    }
}