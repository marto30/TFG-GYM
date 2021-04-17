package com.tema7.tema7ejemplo2.Fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tema7.tema7ejemplo2.R;

public class InfoFragment extends Fragment {

    private FloatingActionButton btnInfo;

    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        btnInfo = (FloatingActionButton) view.findViewById(R.id.botonInfo);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alerta = new AlertDialog.Builder(getContext());
                alerta.setMessage("Este dialogo de alerta es solo para mostrar un mensaje informativo normal al usuario,nada con lo que interartuar")
                        .setCancelable(true)
                        .setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                try {
                                    InfoFragment.this.finalize();
                                } catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }

                            }

                        });
                AlertDialog titulo = alerta.create();
                titulo.setTitle("Información");
                titulo.show();


            }
        });
        return view;
    }
}