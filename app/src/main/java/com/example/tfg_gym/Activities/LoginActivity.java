package com.example.tfg_gym.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tfg_gym.Util.Util;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.tema7.tema7ejemplo2.R;

public class LoginActivity extends AppCompatActivity {

    //Elementos necesarios del activity
    RelativeLayout gallery1;
    LinearLayout gallery2;
    Button btnlogin, btnreset, btnsignup;
    TextView textoSplashScreen;
    EditText mMail, mPassword;
    private FirebaseAuth mAuth;
    private ProgressDialog barraCarga;
    private SharedPreferences prefs;
    private Switch rememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        gallery1 =findViewById(R.id.gallery1);
        gallery2 = findViewById(R.id.gallery2);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnsignup = (Button) findViewById(R.id.btnsignup);
        btnreset = (Button) findViewById(R.id.btnreset);
        mMail = (EditText) findViewById(R.id.mail);
        mPassword = (EditText) findViewById(R.id.password);
        rememberMe= (Switch) findViewById(R.id.remember_me_switch);
        barraCarga=new ProgressDialog(this);

        //Para inicializar la instancia de autenticación
        mAuth = FirebaseAuth.getInstance();


        //Botón que nos lleva al activity de registro
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        //Al activity de reseteo de contraseña
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RecuperarActivity.class);
                startActivity(intent);
            }
        });


        //Botón de login
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();

            }
        });


        //se auto-rellenan el email y contraseña en caso de haberse guardado
        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        setCredentialsIfExist();





    }
    private boolean login(String email, String password) {
        if (!isValidEmail(email)) {
            Toast.makeText(this, "Email no válido, por favor inténtalo de nuevo", Toast.LENGTH_LONG).show();
            return false;
        } else if (!isValidPassword(password)) {
            Toast.makeText(this, "Password incorrecta, 4 carácteres mínimo, por favor intentalo de nuevo", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }
    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 4;
    }

    private void login() {
        //Se recogen las credenciales para loguear al usuario
        String email= mMail.getText().toString();
        String password= mPassword.getText().toString();
        if(login(email,password)) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) { //Si el usuario y contraseña son correctos, se carga el UserActivity.
                                // Sign in success, update UI with the signed-in user's information
                                barraCarga.dismiss();
                                Toast.makeText(LoginActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                                saveOnPreferences(mMail.getText().toString().trim(), mPassword.getText().toString().trim());

                                Intent intent = new Intent(getApplication(), MainActivity.class);
                                startActivity(intent);

                                finish();

                            } else {
                                // If sign in fails, display a message to the user.
                                barraCarga.dismiss();
                                Toast.makeText(LoginActivity.this, "Error, compruebe el usuario o contraseña", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    //método que fija el email y contraseña que se hayan guardado
    private void setCredentialsIfExist() {
        String email = Util.getUserMailPrefs(prefs);
        String password = Util.getUserPassPrefs(prefs);
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            mMail.setText(email);
            mPassword.setText(password);
            rememberMe.setChecked(true);
        }
    }

    //método que guarda el email y contraseña introducidos
    private void saveOnPreferences(String email, String password) {
        if (rememberMe.isChecked()) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("email", email);
            editor.putString("pass", password);
            editor.apply();


        } else {
            Util.removeSharedPreferences(prefs);
        }
    }

}