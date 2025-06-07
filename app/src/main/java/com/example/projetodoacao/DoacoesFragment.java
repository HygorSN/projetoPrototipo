package com.example.projetodoacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DoacoesFragment extends Fragment {

    private EditText etNomeAlimento, etQuantidade;
    private Button btnAdicionarItem, btnFinalizarDoacao;
    private RecyclerView recyclerCarrinho;
    private CarrinhoAdapter carrinhoAdapter;
    private ArrayList<Alimento> listaCarrinho;

    public static final String ARG_CESTA_BASICA = "arg_cesta_basica";

    public static DoacoesFragment newInstance(ArrayList<Alimento> cestaBasica) {
        DoacoesFragment fragment = new DoacoesFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_CESTA_BASICA, cestaBasica);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_doacoes, container, false);

        etNomeAlimento = view.findViewById(R.id.etNomeAlimento);
        etQuantidade = view.findViewById(R.id.etQuantidade);
        btnAdicionarItem = view.findViewById(R.id.btnAdicionarItem);
        btnFinalizarDoacao = view.findViewById(R.id.btnFinalizarDoacao);
        recyclerCarrinho = view.findViewById(R.id.recyclerCarrinho);

        listaCarrinho = new ArrayList<>();

        // Recupera lista da cesta básica enviada no argumento (se existir)
        if (getArguments() != null) {
            ArrayList<Alimento> cestaBasica = getArguments().getParcelableArrayList(ARG_CESTA_BASICA);
            if (cestaBasica != null) {
                listaCarrinho.addAll(cestaBasica);
            }
        }

        carrinhoAdapter = new CarrinhoAdapter(requireContext(), listaCarrinho);
        recyclerCarrinho.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerCarrinho.setAdapter(carrinhoAdapter);

        btnAdicionarItem.setOnClickListener(v -> {
            String nome = etNomeAlimento.getText().toString();
            String qtd = etQuantidade.getText().toString();
            if (!nome.isEmpty() && !qtd.isEmpty()) {
                listaCarrinho.add(new Alimento(nome, qtd));
                carrinhoAdapter.notifyDataSetChanged();
                etNomeAlimento.setText("");
                etQuantidade.setText("");
            } else {
                Toast.makeText(getContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            }
        });

        btnFinalizarDoacao.setOnClickListener(v -> {
            if (listaCarrinho.isEmpty()) {
                Toast.makeText(getContext(), "O carrinho está vazio", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(getContext(), EscolhaOngActivity.class);
            startActivity(intent);
        });

        return view;
    }
}
