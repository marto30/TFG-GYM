package com.tema7.tema7ejemplo2.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tema7.tema7ejemplo2.Adapter.EntrenamientoAdapter;
import com.tema7.tema7ejemplo2.Model.Entrenamiento;
import com.tema7.tema7ejemplo2.R;

import java.util.ArrayList;
import java.util.List;


public class EntrenamientoFragment extends Fragment {

    private FloatingActionButton fab; //Boton flotante
    private List<Entrenamiento> entrenamientos;
    private EntrenamientoAdapter adapter; //Adaptar
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private DatabaseReference mDataBase; //BBDD
    private FirebaseAuth mAuth; //Firebase

    //Se inicia al abrir el layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.entrenamiento_activity, container, false);

        //Instanciamos Firebase
        mAuth = FirebaseAuth.getInstance();
        mDataBase= FirebaseDatabase.getInstance().getReference();

        entrenamientos = new ArrayList<Entrenamiento>();
        layoutManager = new LinearLayoutManager(getActivity());

        //Redimensionamos el recycler
        recyclerView= (RecyclerView) root.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //Boton añadir cogemos ID
        fab= root.findViewById(R.id.fabAddEntrenamiento);

        //Metodo para cargar las tarjeta de las ciudades
        getEntrenamientosFromFirebase();

        //Método para que el boton desaparezca al bajar
        setHideShowFAB();

        //Añadir una ciudad
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Fragment fragment=new AnyadirEntrenamiento();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
            }
        });
        return root;
    }

    //Lee las ciudades de Firebase
    private void getEntrenamientosFromFirebase() {
        mDataBase.child("tfg-gym-default-rtdb").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                EntrenamientoAdapter.OnItemClickListener itemListener = null;
                EntrenamientoAdapter.OnButtonClickListener btnListener = null;

                //Si hay datos...
                if (dataSnapshot.exists()) {
                    //Actuliza la lista
                    entrenamientos.clear();
                    //Busca todos los datos
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String nombreEntrenador = ds.child("nombre_entrenador").getValue().toString();
                        String nombreCliente = ds.child("nombre_cliente").getValue().toString();
                        String id  = ds.getKey();
                        String fecha = ds.child("fecha_entrenamiento").getValue().toString();
                        String lugar = ds.child("lugar_entrenamiento").getValue().toString();
                        //Creamos una ciudad
                        Entrenamiento entrenamiento2 = new Entrenamiento(nombreEntrenador, nombreCliente, fecha, lugar);
                        //Añadimos la ciudad al List
                        entrenamientos.add(entrenamiento2);
                    }
                }

                //Adaptador
                adapter = new EntrenamientoAdapter(entrenamientos, R.layout.fragment_entrenamiento, new EntrenamientoAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Entrenamiento entrenamiento, int position) {
                        //En caso de dar click a la tarjeta enviamos los datos
                        Intent intent = new Intent(getActivity(), AnyadirEntrenamiento.class);
                        intent.putExtra("id", entrenamientos.get(position).getId());
                        intent.putExtra("name_entrenador", entrenamientos.get(position).getNombre_entrenador());
                        intent.putExtra("nombre_cliente", entrenamientos.get(position).getNombre_cliente());
                        intent.putExtra("fecha_entrenamiento", entrenamientos.get(position).getFecha());
                        intent.putExtra("lugar_entrenamiento", entrenamientos.get(position).getLugar());

                        float ss = (float) entrenamientos.get(position).getPrecio();
                        String enviar = Float.toString(ss);

                        startActivity(intent);
                    }
                    //Boton eliminar
                }, new  EntrenamientoAdapter.OnButtonClickListener() {
                    @Override
                    public void onButtonClick(Entrenamiento entrenamiento, int position) {
                        //Alerta para confirma borrar una ciudad
                        alertDelete("Borrar", "Estas seguro que quieres cancelar ?", position);
                    }
                });

                //Cargamos el recycler metiendo el adaptador
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    //Mensaje para confirmar la eliminaciónde borrar una ciudad
    private void alertDelete(String title, String message, int position) {
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteCity(position); //Borramos la ciudad
                        //Mensaje
                        Toast.makeText(getActivity(), "Ha sido borrado exitosamente.", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("Cancelar", null).show();
    }

    //Metodo ocultar boton
    private void setHideShowFAB() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0)
                    fab.hide();
                else if (dy <= 0)//Aparece al volver arriba
                    fab.show();

            }
        });
    }

    //Metodo eliminar ciudad de firebase
    private void deleteCity(int position) {
        String id  = entrenamientos.get(position).getId(); //Cogemos el ID de la tarjeta seleccionada
        mDataBase.child("tfg-gym-default-rtdb").child(id).removeValue(); //Borramos a través del ID
        entrenamientos.clear(); //Limpiamos cada que eliminamos
    }
}