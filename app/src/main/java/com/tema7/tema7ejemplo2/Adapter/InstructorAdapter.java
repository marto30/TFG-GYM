package com.tema7.tema7ejemplo2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tema7.tema7ejemplo2.Model.Instructor;
import com.tema7.tema7ejemplo2.R;

import java.util.List;

public class InstructorAdapter {
/*
public class InstructorAdapter extends RecyclerView.Adapter<InstructorAdapter.ViewHolder>{
    private Context context;
    private List<Instructor> instructores;
    private int layout;
    private OnItemClickListener itemClickListener;
    private OnButtonClickListener btnClickListener;


    public InstructorAdapter(List<Instructor> instructores, int layout, OnItemClickListener itemListener, OnButtonClickListener btnListener) {
        this.instructores = instructores;
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
        holder.bind(instructores.get(position), itemClickListener, btnClickListener);
    }

    @Override
    public int getItemCount() {

        return instructores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //Atributos de usuario
        public ImageView foto;
        public TextView nombre;
        public TextView apellidos;
        public TextView telefono;
        public TextView sexo;
        public TextView email;
        public TextView ciudad;
        public TextView ubicacion;

        //Atributos de el Instructor
        public TextView horarioDispo;
        public TextView descProfesional;
        public TextView disciplinas;
        public TextView precio;
        public TextView valoraciones;
        public TextView descValoraciones;
        //public Button btnDelete;


        public ViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.textViewNombreInstructor);
            description = (TextView) itemView.findViewById(R.id.textViewCityDescription);
            stars = (TextView) itemView.findViewById(R.id.textViewStars);
            image = (ImageView) itemView.findViewById(R.id.imageViewCity);
            btnDelete = (Button) itemView.findViewById(R.id.buttonDeleteCity);
        }

        public void bind(final Instructor instructor, final OnItemClickListener itemListener, final OnButtonClickListener btnListener) {
            description.setText(city.getDescription());
            name.setText(city.getName());
            stars.setText(city.getStars() + "");
            Picasso.get().load(city.getImage()).fit().into(image);

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    btnListener.onButtonClick(instructor, getAdapterPosition());
                }
            });


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemListener.onItemClick(instructor, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Instructor instructor, int position);
    }

    public interface OnButtonClickListener {
        void onButtonClick(Instructor instructor, int position);
    }
*/
}