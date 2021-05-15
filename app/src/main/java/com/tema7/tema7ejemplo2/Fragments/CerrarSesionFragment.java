package com.tema7.tema7ejemplo2.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tema7.tema7ejemplo2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CerrarSesionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CerrarSesionFragment extends Fragment {

    public CerrarSesionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CerrarSesionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CerrarSesionFragment newInstance(String param1, String param2) {
        CerrarSesionFragment fragment = new CerrarSesionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cerrar_sesion, container, false);
    }
}