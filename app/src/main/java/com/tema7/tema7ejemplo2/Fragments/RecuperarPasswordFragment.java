package com.tema7.tema7ejemplo2.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.firebase.auth.FirebaseAuth;
import com.tema7.tema7ejemplo2.R;

public class RecuperarPasswordFragment extends Fragment {

<<<<<<< Updated upstream:app/src/main/java/com/tema7/tema7ejemplo2/Fragments/RecuperarPasswordFragment.java
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecuperarPasswordFragment() {
        // Required empty public constructor
    }

    public static RecuperarPasswordFragment newInstance(String param1, String param2) {
        RecuperarPasswordFragment fragment = new RecuperarPasswordFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
=======
public class IniciarSesionFragment extends AppCompatActivity {

    Button btn_login, btn_registrar, btn_recuperar;
    EditText usuMail, usuPass;

    FirebaseAuth firebaseAuth;
    AwesomeValidation awesomeValidation;
>>>>>>> Stashed changes:app/src/main/java/com/tema7/tema7ejemplo2/Fragments/IniciarSesionFragment.java

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
                Intent i = new Intent(IniciarSesionFragment.this, RegistrarUsuarioFragment.class);
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
<<<<<<< Updated upstream:app/src/main/java/com/tema7/tema7ejemplo2/Fragments/RecuperarPasswordFragment.java
        return inflater.inflate(R.layout.fragment_recuperar_password, container, false);
=======
        return inflater.inflate(R.layout.fragment_iniciar_sesion, container, false);
    }*/

    private void mensajeError(String error){

>>>>>>> Stashed changes:app/src/main/java/com/tema7/tema7ejemplo2/Fragments/IniciarSesionFragment.java
    }
}