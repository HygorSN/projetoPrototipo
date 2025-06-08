package com.example.projetodoacao;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class DoacoesRecebidasFragment extends Fragment {

    private RecyclerView recyclerDoacoes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doacoes_recebidas, container, false);

        recyclerDoacoes = view.findViewById(R.id.recyclerDoacoes);
        recyclerDoacoes.setLayoutManager(new LinearLayoutManager(getContext()));

        List<String> doacoes = Arrays.asList(
                "Arroz - 5kg",
                "Feijão - 2kg",
                "Leite - 3L",
                "Macarrão - 4 pacotes",
                "Cesta Básica - 1 un."
        );

        DoacaoAdapter adapter = new DoacaoAdapter(doacoes);
        recyclerDoacoes.setAdapter(adapter);

        return view;
    }
}
