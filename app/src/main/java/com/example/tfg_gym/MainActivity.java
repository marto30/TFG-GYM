package com.example.tfg_gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.tema7.tema7ejemplo2.Fragments.IniciarSesionFragment;
import com.tema7.tema7ejemplo2.Fragments.RegistrarUsuarioFragment;
import com.tema7.tema7ejemplo2.Fragments.RegistrarUsuariosActivity;
import com.tema7.tema7ejemplo2.R;

public class MainActivity extends AppCompatActivity {

    Button btn_login, btn_registrar, btn_recuperar;
    EditText usuMail, usuPass;

    FirebaseAuth firebaseAuth;
    AwesomeValidation awesomeValidation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_iniciar_sesion);

        firebaseAuth = FirebaseAuth.getInstance();
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        usuMail = findViewById(R.id.usuMail);
        usuPass = findViewById(R.id.usuPass);

        btn_login = findViewById(R.id.btn_login);
        btn_registrar = findViewById(R.id.btn_registrar);
        btn_recuperar = findViewById(R.id.btn_recuperar);

        btn_registrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegistrarUsuariosActivity.class);
                StartActivity(i);
            }

            private void StartActivity(Intent i) {
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });
        btn_recuperar.setOnClickListener(new View.OnClickListener(){
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

    private void mensajeError(String error){

    }
}