package com.example.projetodoacao;

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
        carrinhoAdapter = new CarrinhoAdapter(listaCarrinho);
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
            Toast.makeText(getContext(), "Doação finalizada com " + listaCarrinho.size() + " item(s)", Toast.LENGTH_SHORT).show();
            listaCarrinho.clear();
            carrinhoAdapter.notifyDataSetChanged();
        });

        return view;
    }
}
