package com.tema7.tema7ejemplo2.Model;

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
import com.tema7.tema7ejemplo2.Fragments.PerfilClienteFragment;
import com.tema7.tema7ejemplo2.R;

public class Usuario {

    private String id;
    private String foto;
    private String nombre;
    private String apellidos;
    private int telefono;
    private String sexo;
    private String email;
    private String ciudad;
    private String ubicacion;

    public Usuario() {
    }

    public Usuario(String id, String foto, String nombre, String apellidos, int telefono, String sexo,
                   String email, String ciudad, String ubicacion) {
        this.id = id;
        this.foto = foto;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.sexo = sexo;
        this.email = email;
        this.ciudad = ciudad;
        this.ubicacion = ubicacion;
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getFoto() {return foto;}

    public void setFoto(String foto) {this.foto = foto;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellidos() {return apellidos;}

    public void setApellidos(String apellidos) {this.apellidos = apellidos;}

    public int getTelefono() {return telefono;}

    public void setTelefono(int telefono) {this.telefono = telefono;}

    public String getSexo() {return sexo;}

    public void setSexo(String sexo) {this.sexo = sexo;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getCiudad() {return ciudad;}

    public void setCiudad(String ciudad) {this.ciudad = ciudad;}

    public String getUbicacion() {return ubicacion;}

    public void setUbicacion(String ubicacion) {this.ubicacion = ubicacion;}

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", foto='" + foto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono=" + telefono +
                ", sexo='" + sexo + '\'' +
                ", email='" + email + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }

    /**
     * A simple {@link Fragment} subclass.
     * Use the {@link PerfilClienteFragment_editar#newInstance} factory method to
     * create an instance of this fragment.
     */
    public static class PerfilClienteFragment_editar extends Fragment {


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
}