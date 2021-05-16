package com.tema7.tema7ejemplo2.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tema7.tema7ejemplo2.R;

import java.util.HashMap;
import java.util.Map;

public class RegistrarInstructoresActivity extends AppCompatActivity {

    private EditText textNombre, textApellidos, textEmail, textPassword,  textTelefono;
    private Button btnRegistrar, btnLogin;
    private Spinner spinnerCiudad;
    private String nombre, apellidos, email, password,  telefono, ciudad;
    private ProgressDialog cargando;
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_instructores);

        btnLogin=(Button)findViewById(R.id.btnInstLogin);
        btnRegistrar=(Button)findViewById(R.id.btnInstRegistrar);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        cargando = new ProgressDialog(this);

        btnRegistrar = (Button) findViewById(R.id.btnInstRegistrar);
        textNombre = (EditText) findViewById(R.id.textInstNombre);
        textApellidos = (EditText) findViewById(R.id.textInstApellido);
        textEmail = (EditText) findViewById(R.id.textInstCorreo);
        textPassword = (EditText) findViewById(R.id.textInstPassword);
        textTelefono = (EditText) findViewById(R.id.textInstTelefono);
        spinnerCiudad = (Spinner) findViewById(R.id.spinnerInstCiudad);
        cargarSpinner();


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nombre = textNombre.getText().toString();
                apellidos = textApellidos.getText().toString();
                email = textEmail.getText().toString();
                password = textPassword.getText().toString();
                telefono = textTelefono.getText().toString();
                ciudad = spinnerCiudad.getSelectedItem().toString();

                if (! (nombre.equals("") || apellidos.equals("") || email.equals("") || password.equals("") || ciudad.equals("") || telefono.equals(""))) {

                    if (password.length() > 5) {
                        if(!(email.contains("@"))) {
                            Toast.makeText(getApplicationContext(), "El correo electronico debe contener '@'", Toast.LENGTH_SHORT).show();
                        }else{
                            crearCuenta();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "La contraseña debe contener 6 o más caracteres", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "Todos los campos son requeridos", Toast.LENGTH_SHORT).show();
                }


            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrarInstructoresActivity.this, IniciarSesionActivity.class);
                startActivity(intent);
            }
        });
    }

    private void cargarSpinner() {
        String[] provincias = {"", "Álava", "Albacete", "Alicante", "Almería", "Asturias", "Ávila", "Badajoz", "Barcelona", "Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón", "Ciudad Real", "Córdoba", "Cuenca", "Gerona", "Granada", "Guadalajara", "Guipúzkoa", "Huelva", "Huesca", "Islas Baleares", "Jaén", "La Coruña", "La Rioja", "Las Palmas", "León", "Lérida", "Madrid", "Málaga", "Murcia", "Navarra", "Ourense", "Palencia", "Pontevedra", "Salamanca", "Sta Cruz de Tenerife", "Segovia", "Sevilla", "Soria", "Tarragona", "Teruel", "Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, provincias);
        spinnerCiudad.setAdapter(adapter);

    }
    private void crearCuenta(){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Map<String, Object> map = new HashMap<>();
                    map.put("nombre", nombre);
                    map.put("apellidos", apellidos);
                    map.put("email", email);
                    map.put("password", password);

                    map.put("telefono", telefono);
                    map.put("ciudad", ciudad);
                    map.put("tipo","instructor");

                    String id = mAuth.getCurrentUser().getUid();

                    mDatabase.child("Usuarios").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if(task2.isSuccessful()){

                                Intent intent = new Intent(getApplicationContext(), IniciarSesionActivity.class);
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(getApplicationContext(), "No se ha podido crear el Instructor correctamente", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Error al crear la cuenta", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}