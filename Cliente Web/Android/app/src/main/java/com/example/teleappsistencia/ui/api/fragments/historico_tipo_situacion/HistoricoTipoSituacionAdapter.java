package com.example.teleappsistencia.ui.api.fragments.historico_tipo_situacion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teleappsistencia.R;
import com.example.teleappsistencia.ui.objects.HistoricoTipoSituacion;

import java.util.List;

public class HistoricoTipoSituacionAdapter extends RecyclerView.Adapter<HistoricoTipoSituacionAdapter.HistoricoTipoSituacionViewHolder> {

    private List<HistoricoTipoSituacion> items;
    private HistoricoTipoSituacionViewHolder historicoTipoSituacionViewHolder;

    public static class HistoricoTipoSituacionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // Campos respectivos de un item.
        public Context context;
        public TextView textView_id;
        private ImageButton imgBtn_modificar;
        private ImageButton imgBtn_ver;
        private ImageButton imgBtn_borrar;

        private HistoricoTipoSituacion historicoTipoSituacion;

        public HistoricoTipoSituacionViewHolder(View v) {
            super(v);
            this.context = v.getContext();
            this.textView_id = v.findViewById(R.id.textView_id_historicoTipoSituacion);
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
                    // Llamar al Fragment ModificarHistoricoTipoSituacionFragment.
                    ModificarHistoricoTipoSituacionFragment fragmentModificar = ModificarHistoricoTipoSituacionFragment.newInstance(this.historicoTipoSituacion);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragmentModificar).addToBackStack(null).commit();
                    break;
                case R.id.imageButtonVer:
                    // Llamar al Fragment ConsultarHistoricoTipoSituacionFragment.
                    ConsultarHistoricoTipoSituacionFragment fragmentConsultar = ConsultarHistoricoTipoSituacionFragment.newInstance(this.historicoTipoSituacion);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragmentConsultar).addToBackStack(null).commit();
                    break;
                case R.id.imageButtonBorrar:
                    break;
            }
        }

        public void setHistoricoTipoSituacion(HistoricoTipoSituacion historicoTipoSituacion) {
            this.historicoTipoSituacion = historicoTipoSituacion;
        }
    }

    public HistoricoTipoSituacionAdapter(List<HistoricoTipoSituacion> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public HistoricoTipoSituacionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_card_historico_tipo_situacion, viewGroup, false);
        historicoTipoSituacionViewHolder = new HistoricoTipoSituacionViewHolder(v);
        return historicoTipoSituacionViewHolder;
    }

    @Override
    public void onBindViewHolder(HistoricoTipoSituacionViewHolder viewHolder, int i) {
        viewHolder.setOnClickListeners();
        viewHolder.textView_id.setText(viewHolder.context.getString(R.string.id_con_dos_puntos) + items.get(i).getId());
        historicoTipoSituacionViewHolder.setHistoricoTipoSituacion(items.get(i));
    }
}