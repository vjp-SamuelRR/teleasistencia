package com.example.teleappsistencia.ui.fragments.recurso_comunitario;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teleappsistencia.R;
import com.example.teleappsistencia.modelos.RecursoComunitario;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentListarRecursoComunitario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentListarRecursoComunitario extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    public FragmentListarRecursoComunitario() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentListarRecursoComunitario.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentListarRecursoComunitario newInstance(String param1, String param2) {
        FragmentListarRecursoComunitario fragment = new FragmentListarRecursoComunitario();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_listar_recurso_comunitario, container, false);
        // Inicializar Recursos Comunitarios.
        List items = new ArrayList();
        List<String> listaTipoRecursoComunitario = new ArrayList();
        listaTipoRecursoComunitario.add("Policía");

        items.add(new RecursoComunitario("Bomberos", "678656678",
                listaTipoRecursoComunitario, "Plasencia", "Cáceres",
                "Av. Extremadura, 12", "10600"));

        // Obtener el Recycler.
        recycler = (RecyclerView) root.findViewById(R.id.listRecyclerView);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout.
        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador.
        adapter = new RecursoComunitarioAdapter(items, getActivity(), recycler);
        recycler.setAdapter(adapter);

        // Inflate the layout for this fragment
        return root;
    }
}