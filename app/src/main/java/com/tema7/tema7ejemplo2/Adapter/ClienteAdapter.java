package com.tema7.tema7ejemplo2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tema7.tema7ejemplo2.Model.Cliente;
import com.tema7.tema7ejemplo2.R;

import java.util.List;

public class ClienteAdapter {

/*public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ViewHolder> {
    private Context context;
    private List<Cliente> clientes;
    private int layout;
    private OnItemClickListener itemClickListener;
    private OnButtonClickListener btnClickListener;


    public ClienteAdapter(List<Cliente> clientes, int layout, OnItemClickListener itemListener, OnButtonClickListener btnListener) {
        this.clientes = clientes;
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
        holder.bind(clientes.get(position), itemClickListener, btnClickListener);
    }

    @Override
    public int getItemCount() {

        return clientes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nombre;
        public TextView apellidos;
        public TextView telefono;
        public TextView sexo;
        public TextView email;
        public TextView ciudad;
        public TextView ubicacion;
        public ImageView foto;
        public TextView descPersonal;
        public TextView resultBuscados;
        public TextView Objetivos;
       // public Button btnDelete;


        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textViewCityName);
            description = (TextView) itemView.findViewById(R.id.textViewCityDescription);
            stars = (TextView) itemView.findViewById(R.id.textViewStars);
            image = (ImageView) itemView.findViewById(R.id.imageViewCity);
            btnDelete = (Button) itemView.findViewById(R.id.buttonDeleteCity);
        }

        public void bind(final Cliente cliente, final OnItemClickListener itemListener, final OnButtonClickListener btnListener) {
            description.setText(city.getDescription());
            name.setText(city.getName());
            stars.setText(city.getStars() + "");
            Picasso.get().load(city.getImage()).fit().into(image);

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    btnListener.onButtonClick(city, getAdapterPosition());
                }
            });


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemListener.onItemClick(cliente, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Cliente cliente, int position);
    }

    public interface OnButtonClickListener {
        void onButtonClick(Cliente cliente, int position);
    }
*/
}