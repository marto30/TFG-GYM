package com.tema7.tema7ejemplo2.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tema7.tema7ejemplo2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilClienteFragment} factory method to
 * create an instance of this fragment.
 */
public class PerfilClienteFragment extends Fragment {



    // TODO: Rename and change types of parameters

    private FloatingActionButton edit;
    EditText nombre, apellidos, correo,telefono,ubicacion,sexo,objetivos,descripcion;
    public PerfilClienteFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_perfil_cliente, container, false);

        edit=root.findViewById(R.id.fabedit);
        edit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Fragment fragment=new PerfilClienteFragment_editar();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
            }
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nombre = view.findViewById(R.id.nombre);
        edit=view.findViewById(R.id.fabedit);


    }
}
