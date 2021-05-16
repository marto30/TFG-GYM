package com.tema7.tema7ejemplo2.Fragments;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import com.tema7.tema7ejemplo2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilClienteFragment_editar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilClienteFragment_editar extends Fragment {


    private FloatingActionButton edit;
    private RecyclerView recycler;
    private EditText TextNewLink;
    EditText nombre, apellidos, correo, telefono,ubicacion, sexo,objetivos, descripcion;
    ImageView imagen;
    Uri imageUri;
    FirebaseStorage storage;
    Button Subir;
    StorageReference storageReference;
    public PerfilClienteFragment_editar() {
        // Required empty public constructor
    }


    public static PerfilClienteFragment_editar newInstance(String param1, String param2) {
        PerfilClienteFragment_editar fragment = new PerfilClienteFragment_editar();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_perfil_cliente_editar, container, false);
        imagen= root.findViewById(R.id.FotoPerfil);
        Subir = root.findViewById(R.id.buttonSubir);
        edit=root.findViewById(R.id.fabSave);
        TextNewLink = (EditText)root.findViewById(R.id.TextFotoSubir); //LINK
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();


        Subir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cogemos el link
                String link = TextNewLink.getText().toString();

                //Comprobamos que no no esté vacio
                if (link.length() > 0)
                    cargarImagen(link); //Llamamos al metodo cargar imagen
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                //ActualizarPerfil();
                Fragment fragment=new PerfilClienteFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
            }
        });


        return root;


    }

    private void cargarImagen(String link) {
        Picasso.get()
                .load(link)
                .fit()
                .into(imagen);
    }




    }


   /* @Override
    public void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String currentuid = user.getUid();

        documentReference.collection("user").document(currentuid);
        Task<DocumentSnapshot> documentSnapshotTask = documentReference.get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {


                        if (task.getResult().exists()) {
                            String nombreresul = task.getResult().getString("nombre");
                            String apellidosresul = task.getResult().getString("apellidos");
                            String correoresul = task.getResult().getString("correo");
                            String telefonoresul = task.getResult().getString("telefono");
                            String ubicacionresul = task.getResult().getString("ubicacion");
                            String sexoresul = task.getResult().getString("sexo");
                            String objetivosresul = task.getResult().getString("objetivo");
                            String descripcionresul = task.getResult().getString("descripcion");

                            nombre.setText(nombreresul);
                            apellidos.setText(apellidosresul);
                            correo.setText(correoresul);
                            telefono.setText(telefonoresul);
                            ubicacion.setText(ubicacionresul);
                            sexo.setText(sexoresul);
                            objetivos.setText(objetivosresul);
                            descripcion.setText(descripcionresul);
                        } else {
                            Toast.makeText(getContext(), "Error al crear la cuenta", Toast.LENGTH_SHORT).show();
                        }
                        ;
                    }
                };
    };*/

