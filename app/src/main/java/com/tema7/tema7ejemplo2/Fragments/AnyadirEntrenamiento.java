
package com.tema7.tema7ejemplo2.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tema7.tema7ejemplo2.Adapter.EntrenamientoAdapter;
import com.tema7.tema7ejemplo2.Model.Entrenamiento;
import com.tema7.tema7ejemplo2.R;

import java.util.List;


public class AnyadirEntrenamiento extends Fragment {

    //Boton flotante GUARDAR y VER IMAGEN
    private FloatingActionButton fabSave;
    private FloatingActionButton FabAddEntrenamiento;

    //Conector BBDD
    private DatabaseReference mDataBase;

    //Atirbutos Layaout
    private EditText NombreEntrenador;
    private EditText NombreCliente;
    private EditText Fecha;
    private EditText Lugar;
    private EditText Precio;

    //Atributos restantes
    private String cityId;
    private String entrenadorName;
    private String clienteName;
    private String fecha;
    private String precio;
    private String lugar;
    Entrenamiento c;
    private boolean isCreation;
    private List<Entrenamiento> entrenamientos;

    //Adapter
    private EntrenamientoAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Abrimos el activity


    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_anyadir_entrenamiento, container, false);

        //Instancias Firebase
        mDataBase = FirebaseDatabase.getInstance().getReference();

        //Cogemos los identficiadores
        NombreEntrenador = (EditText)root.findViewById(R.id.editTextNombreEntrenador); //LINK
        NombreCliente=(EditText) root.findViewById(R.id.editTextNombreCliente); //NOMBRE
        Fecha=(EditText) root.findViewById(R.id.editTextFecha);
        Lugar=(EditText) root.findViewById(R.id.editTextLugar);//DESCRIPCION
        Precio = (EditText) root.findViewById(R.id.editTextPrecio);//IMAGEN
        fabSave= root.findViewById(R.id.fabSave); //GUARDAR
        FabAddEntrenamiento= root.findViewById(R.id.fabAddEntrenamiento); //VER IMAGEN


        //Comprobar si la acción es para editar o para añadir
        if(getActivity().getIntent().getExtras() != null){
            getActivity().setTitle(R.string.titulo_editarentrenamiento); //Añadimos el titulo

            //Recogemos los datos pasados del CityActivty
            cityId = getActivity().getIntent().getExtras().getString("id");
            entrenadorName = getActivity().getIntent().getExtras().getString("name_entrenador");
            clienteName = getActivity().getIntent().getExtras().getString("nombre_cliente");
            fecha = getActivity().getIntent().getExtras().getString("fecha");
            precio = getActivity().getIntent().getExtras().getString("precio");
            lugar = getActivity().getIntent().getExtras().getString("lugar");

            //Ponemos los datso en los Text
            meterDatos();
            //Variable para saber si editamos o creamos una ciudad
            isCreation=false;
        }else{
            //Variable para saber si editamos o creamos una ciudad
            isCreation=true;
            getActivity().setTitle(R.string.titulo_nuevo_entrenamiento);//Añadimos el titulo

        }

        //Evento del botón guardar
        fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment=new EntrenamientoFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
                //Guardanos los datos en la nube



        //Añadimos los datos a la nube
            //Validamos los datos entregados
            if (isValisDataForNewCity()) {
                //Cogemos los datos de los campos
                NombreEntrenador = (EditText) root.findViewById(R.id.editTextNombreEntrenador);
                String entrenador = NombreEntrenador.getText().toString();

                NombreCliente = (EditText) root.findViewById(R.id.editTextNombreCliente);
                String cliente = NombreCliente.getText().toString();

                Fecha = (EditText) root.findViewById(R.id.editTextFecha);
                String fecha = Fecha.getText().toString();

                Lugar = (EditText) root.findViewById(R.id.editTextLugar);
                String lugar = Lugar.getText().toString();



                //Añadimos los atributos al objeto
                Entrenamiento entrenamiento = new Entrenamiento();
                entrenamiento.setNombre_entrenador(entrenador);
                entrenamiento.setNombre_cliente(cliente);
                entrenamiento.setFecha(fecha);
                entrenamiento.setLugar(lugar);

                //En caso de que sea ediccion pasamos el ID
                if (!isCreation) {
                    entrenamiento.setId(cityId);
                    mDataBase.child("tfg-gym-default-rtdb").child(cityId).child("name_entrenador").setValue(entrenador);
                    mDataBase.child("tfg-gym-default-rtdb").child(cityId).child("nombre_cliente").setValue(cliente);
                    mDataBase.child("tfg-gym-default-rtdb").child(cityId).child("fecha_entrenamiento").setValue(fecha);
                    mDataBase.child("tfg-gym-default-rtdb").child(cityId).child("lugar_entrenamiento").setValue(lugar);

                    //Aqui añadimos una nuev ciudad
                } else {
                    //Subimos la nueva ciudad
                    mDataBase.child("tfg-gym-default-rtdb").push().setValue(entrenador).addOnCompleteListener((task) -> {
                        //Si se ha subido la ciudad Mensajes de ERROR y SUCCESFUL
                        if (task.isSuccessful()) {
                            Toast.makeText(getActivity().getApplicationContext(), "" +
                                    "Entrenamiento creado con éxito", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getActivity().getApplicationContext(), "Error al crear un entrenamiento", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }else{
                //En caso de tener campos vacios salta este mensaje
                Toast.makeText(getActivity().getApplicationContext(), "Hay campos vacios", Toast.LENGTH_LONG).show();
            }
        }
    });

        return root;

    }



    //Ponemos los datos en los editext y estrellas (EDITAR)
    private void meterDatos() {
        NombreEntrenador.setText(entrenadorName);
        NombreCliente.setText(clienteName);
        Fecha.setText(lugar);
        Lugar.setText(fecha);
    }


    private boolean isValisDataForNewCity() {
        if(NombreEntrenador.getText().toString().length() > 0 &&
                NombreCliente.getText().toString().length() > 0 &&
                Fecha.getText().toString().length() > 0 ) {
            return true;
        }else{
            return false;
        }
    }


}