package com.example.projetodoacao;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HomeOngFragment extends Fragment {

    private Button btnCadastrarFamilias, btnVerificarDoacoes, btnEstoque, btnVerTodos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_ong, container, false);

        btnCadastrarFamilias = view.findViewById(R.id.btnCadastrarFamilias);
        btnVerificarDoacoes = view.findViewById(R.id.btnVerificarDoacoes);
        btnEstoque = view.findViewById(R.id.btnEstoque);
        btnVerTodos = view.findViewById(R.id.btnVerTodos);

        btnCadastrarFamilias.setOnClickListener(v ->
                startActivity(new android.content.Intent(getActivity(), CadastroFamiliasActivity.class)));

        btnVerificarDoacoes.setOnClickListener(v -> {
            Fragment doacoesFragment = new DoacoesRecebidasFragment();
            FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container_ong, doacoesFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });

        btnEstoque.setOnClickListener(v ->
                startActivity(new android.content.Intent(getActivity(), EstoqueActivity.class)));

        // Botão Ver Todos abre o DialogFragment de famílias assistidas
        btnVerTodos.setOnClickListener(v -> {
            ListaFamiliasDialogFragment dialog = new ListaFamiliasDialogFragment();
            dialog.show(getParentFragmentManager(), "listaFamiliasDialog");
        });

        return view;
    }
}
