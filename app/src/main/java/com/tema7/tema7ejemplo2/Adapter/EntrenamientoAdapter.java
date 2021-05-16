package com.tema7.tema7ejemplo2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tema7.tema7ejemplo2.Model.Entrenamiento;
import com.tema7.tema7ejemplo2.R;

import java.util.List;

public class EntrenamientoAdapter extends RecyclerView.Adapter<EntrenamientoAdapter.ViewHolder> {

    private Context context;
    private List<Entrenamiento> entrenamientos;
    private int layout;
    private OnItemClickListener itemClickListener;
    private OnButtonClickListener btnClickListener;


        public EntrenamientoAdapter(List<Entrenamiento> entrenamientos, int layout, OnItemClickListener itemListener, OnButtonClickListener btnListener) {
            this.entrenamientos = entrenamientos;
            this.layout = layout;
            this.itemClickListener = itemListener;
            this.btnClickListener = btnListener;
        }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        context = parent.getContext();
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(entrenamientos.get(position), itemClickListener, btnClickListener);
    }

    @Override
    public int getItemCount() {
        return entrenamientos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nombre_entrenador;
        public TextView nombre_cliente;
        public TextView fecha;
        public TextView lugar;
        public TextView precio;
        public Button btnDelete;


        public ViewHolder(View itemView) {
            super(itemView);
            nombre_entrenador = (TextView) itemView.findViewById(R.id.textViewEntrenadorNombre);
            nombre_cliente = (TextView) itemView.findViewById(R.id.textViewNombreCliente);
            fecha = (TextView) itemView.findViewById(R.id.textViewFecha);
            lugar = (TextView) itemView.findViewById(R.id.textViewLugar);

            btnDelete = (Button) itemView.findViewById(R.id.buttonCancelar);
        }

        public void bind(final Entrenamiento entrenamiento, final OnItemClickListener itemListener, final OnButtonClickListener btnListener) {

            nombre_entrenador.setText(entrenamiento.getNombre_entrenador());
            nombre_cliente.setText(entrenamiento.getNombre_cliente());
            fecha.setText(entrenamiento.getFecha());
            lugar.setText(entrenamiento.getLugar());


            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    btnListener.onButtonClick(entrenamiento, getAdapterPosition());
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemListener.onItemClick(entrenamiento, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Entrenamiento entrenamiento, int position);
    }

    public interface OnButtonClickListener {
        void onButtonClick(Entrenamiento entrenamiento, int position);
    }

}
