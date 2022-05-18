package com.example.teleappsistencia.ui.api.fragments.dispositivos_aux;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.teleappsistencia.R;
import com.example.teleappsistencia.ui.objects.DispositivoAuxiliar;
import com.example.teleappsistencia.ui.objects.Terminal;
import com.example.teleappsistencia.ui.objects.TipoAlarma;
import com.example.teleappsistencia.ui.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConsultarDispositivosAuxiliaresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsultarDispositivosAuxiliaresFragment extends Fragment {

    private DispositivoAuxiliar dispositivoAuxiliar;

    private TextView textView_id;
    private TextView textView_idTerminal;
    private TextView textView_idTipoAlarma;

    public ConsultarDispositivosAuxiliaresFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param dispositivoAuxiliar
     * @return A new instance of fragment ConsultarDispositivosAuxiliaresFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsultarDispositivosAuxiliaresFragment newInstance(DispositivoAuxiliar dispositivoAuxiliar) {
        ConsultarDispositivosAuxiliaresFragment fragment = new ConsultarDispositivosAuxiliaresFragment();
        Bundle args = new Bundle();
        args.putSerializable(Utils.OBJECT, dispositivoAuxiliar);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dispositivoAuxiliar = (DispositivoAuxiliar) getArguments().getSerializable(Utils.OBJECT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_consultar_dispositivos_auxiliares, container, false);

        this.textView_id = view.findViewById(R.id.textView_consultar_id_dispositivoAuxiliar);
        this.textView_idTerminal = view.findViewById(R.id.textView_consultar_idTerminal_dispositivoAuxiliar);
        this.textView_idTipoAlarma = view.findViewById(R.id.textView_consultar_idTipoAlarma_dispositivoAuxiliar);

        Terminal terminal = (Terminal) Utils.getObjeto(dispositivoAuxiliar.getTerminal(), getString(R.string.terminal_class));
        TipoAlarma tipoAlarma = (TipoAlarma) Utils.getObjeto(dispositivoAuxiliar.getTipoAlarma(), getString(R.string.tipoAlarma_class));

        this.textView_id.setText(Integer.toString(dispositivoAuxiliar.getId()));
        this.textView_idTerminal.setText(terminal.getNumeroTerminal());
        this.textView_idTipoAlarma.setText(Integer.toString(tipoAlarma.getId()));

        return view;
    }
}