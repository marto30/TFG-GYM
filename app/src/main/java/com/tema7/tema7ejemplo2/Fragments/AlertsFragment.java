package com.tema7.tema7ejemplo2.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tema7.tema7ejemplo2.Activities.MainActivity;
import com.tema7.tema7ejemplo2.R;

public class AlertsFragment extends Fragment implements View.OnClickListener, DialogInterface.OnClickListener {
    private AlertDialog.Builder builder;
    private Switch switchBtn;
    TextView textViewTitle;
    private FloatingActionButton btnAlerta;


    public AlertsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alerts, container, false);
        btnAlerta = (FloatingActionButton) view.findViewById(R.id.botonAlerts);
        btnAlerta.setOnClickListener(this);
        switchBtn=(Switch)  view.findViewById(R.id.switchOption);
        textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
        return view;
    }


    public void onClick(View view){
        builder = new AlertDialog.Builder(getContext());
        builder.setTitle("ALERTA");
        builder.setMessage("\n"+"Desea activar o desactivar las alertas");

        //layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_fragment_dialog, null);

        switchBtn = (Switch) dialogView.findViewById(R.id.switchDialog);
        builder.setView(dialogView);

        builder.setPositiveButton("ACEPTAR", this);
        builder.setNegativeButton("CANCELAR", this);
        builder.show();

    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

        if(i == DialogInterface.BUTTON_POSITIVE){
            if(switchBtn.isChecked()){
                textViewTitle.setText("Alertas activadas");
            }else{
                textViewTitle.setText("Alertas Desactivadas");
            }
        }else if(i == DialogInterface.BUTTON_NEGATIVE){
            dialogInterface.cancel();
        }
    }
}