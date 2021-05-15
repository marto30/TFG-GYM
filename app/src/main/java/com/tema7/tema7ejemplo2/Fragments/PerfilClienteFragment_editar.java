package com.tema7.tema7ejemplo2.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.tema7.tema7ejemplo2.Activities.MainActivity;
import com.tema7.tema7ejemplo2.R;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilClienteFragment_editar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilClienteFragment_editar extends Fragment {


    private FloatingActionButton edit;
    private RecyclerView recycler;
    EditText nombre, apellidos, correo, telefono,ubicacion, sexo,objetivos, descripcion;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference;
    DocumentReference documentReference;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ImageView imagen;
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

    public void clickar(View view) {
        cargarImagen();
    }

    private void cargarImagen() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(Intent.createChooser(intent,"Seleccione la Aplicacion"),10);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Uri path=data.getData();
            imagen.setImageURI(path);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_perfil_cliente_editar, container, false);
        imagen= root.findViewById(R.id.FotoPerfil);
        edit=root.findViewById(R.id.fabSave);
        nombre = root.findViewById(R.id.TextNombreedit);
        apellidos = root.findViewById(R.id.TextApellidosedit);
        correo = root.findViewById(R.id.TextCorreoedit);
        telefono = root.findViewById(R.id.TextTelefonoedit);
        ubicacion = root.findViewById(R.id.TextUbicacion);
        sexo= root.findViewById(R.id.TextSexosedit);
        objetivos = root.findViewById(R.id.TextObjetivosedit);
        descripcion = root.findViewById(R.id.TextDescripcionedit);
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
}
