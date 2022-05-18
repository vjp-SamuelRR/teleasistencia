package com.example.teleappsistencia.ui.api.fragments.direccion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teleappsistencia.R;
import com.example.teleappsistencia.ui.api.fragments.grupos.GruposAdapter;
import com.example.teleappsistencia.ui.objects.Direccion;
import com.example.teleappsistencia.ui.objects.Grupo;

import java.util.List;

public class DireccionAdapter extends RecyclerView.Adapter<DireccionAdapter.DireccionViewHolder> {

    private List<Direccion> items;
    private DireccionViewHolder direccionViewHolder;

    public static class DireccionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // Campos respectivos de un item.
        public Context context;
        public TextView textView_id;
        public TextView textView_localidad;
        public TextView textView_provincia;
        public TextView textView_direccion;
        private ImageButton imgBtn_modificar;
        private ImageButton imgBtn_ver;
        private ImageButton imgBtn_borrar;

        private Direccion direccion;

        public DireccionViewHolder(View v) {
            super(v);
            this.context = v.getContext();
            this.textView_id = v.findViewById(R.id.textView_id_direccion);
            this.textView_localidad = v.findViewById(R.id.textView_localidad_direccion);
            this.textView_provincia = v.findViewById(R.id.textView_provincia_direccion);
            this.textView_direccion = v.findViewById(R.id.textView_direccion_direccion);

            this.imgBtn_modificar = v.findViewById(R.id.imageButtonModificar);
            this.imgBtn_ver = v.findViewById(R.id.imageButtonVer);
            this.imgBtn_borrar = v.findViewById(R.id.imageButtonBorrar);
        }

        public void setOnClickListeners() {
            this.imgBtn_modificar.setOnClickListener(this);
            this.imgBtn_ver.setOnClickListener(this);
            this.imgBtn_borrar.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            AppCompatActivity activity = (AppCompatActivity) view.getContext();

            switch (view.getId()) {
                case R.id.imageButtonModificar:
                    // Llamar al Fragment ModificarDireccionFragment.
                    ModificarDireccionFragment fragmentModificar = ModificarDireccionFragment.newInstance(this.direccion);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragmentModificar).addToBackStack(null).commit();
                    break;
                case R.id.imageButtonVer:
                    // Llamar al Fragment ConsultarDireccionFragment.
                    ConsultarDireccionFragment fragmentConsultar = ConsultarDireccionFragment.newInstance(this.direccion);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragmentConsultar).addToBackStack(null).commit();
                    break;
                case R.id.imageButtonBorrar:
                    break;
            }
        }

            public void setDireccion(Direccion direccion) {
            this.direccion = direccion;
        }
    }

    public DireccionAdapter(List<Direccion> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public DireccionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_card_direccion, viewGroup, false);
        direccionViewHolder = new DireccionViewHolder(v);
        return direccionViewHolder;
    }

    @Override
    public void onBindViewHolder(DireccionViewHolder viewHolder, int i) {
        viewHolder.setOnClickListeners();
        viewHolder.textView_id.setText(viewHolder.context.getString(R.string.id_con_dos_puntos) + Integer.toString(items.get(i).getId()));
        viewHolder.textView_localidad.setText(items.get(i).getLocalidad());
        viewHolder.textView_provincia.setText(items.get(i).getProvincia());
        viewHolder.textView_direccion.setText(items.get(i).getDireccion());
        direccionViewHolder.setDireccion(items.get(i));
    }
}