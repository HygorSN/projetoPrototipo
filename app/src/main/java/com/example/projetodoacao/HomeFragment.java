package com.example.projetodoacao;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ImageView imgSuggestion;
    private LinearLayout boxSugestoes;

    public HomeFragment() {
        // Construtor vazio obrigatório
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        imgSuggestion = view.findViewById(R.id.imgSuggestion);
        boxSugestoes = view.findViewById(R.id.boxSugestoes);
        ViewGroup animContainer = view.findViewById(R.id.animContainer);

        // Animação para expandir/ocultar sugestões ao clicar na imagem
        imgSuggestion.setOnClickListener(v -> {
            if (boxSugestoes.getVisibility() == View.GONE) {
                TransitionManager.beginDelayedTransition(animContainer, new AutoTransition());
                boxSugestoes.setVisibility(View.VISIBLE);
            } else {
                TransitionManager.beginDelayedTransition(animContainer, new AutoTransition());
                boxSugestoes.setVisibility(View.GONE);
            }
        });

        // Botão "Adicionar Cesta Básica Sugerida"
        Button btnAdicionarCesta = view.findViewById(R.id.btnAdicionarCesta);
        btnAdicionarCesta.setOnClickListener(v -> {
            ArrayList<Alimento> cestaBasica = new ArrayList<>();
            cestaBasica.add(new Alimento("Arroz", "5kg"));
            cestaBasica.add(new Alimento("Feijão", "3kg"));
            cestaBasica.add(new Alimento("Óleo", "1 litro"));
            cestaBasica.add(new Alimento("Leite em pó", "2 caixas"));
            cestaBasica.add(new Alimento("Açúcar", "2kg"));
            cestaBasica.add(new Alimento("Farinha", "1kg"));
            cestaBasica.add(new Alimento("Macarrão", "3 pacotes"));

            DoacoesFragment doacoesFragment = DoacoesFragment.newInstance(cestaBasica);

            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, doacoesFragment)
                    .addToBackStack(null)
                    .commit();
        });

        // Botão "Adicionar Monte sua Doação"
        Button btnAdicionarMonte = view.findViewById(R.id.btnAdicionarMonte);
        btnAdicionarMonte.setOnClickListener(v -> {
            DoacoesFragment doacoesFragment = new DoacoesFragment();

            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, doacoesFragment)
                    .addToBackStack(null)
                    .commit();
        });

        // Botão "Histórico"
        Button btnHistory = view.findViewById(R.id.btnHistory);
        btnHistory.setOnClickListener(v -> {
            HistoricoDialogFragment dialog = new HistoricoDialogFragment();
            dialog.show(getParentFragmentManager(), "HistoricoDialog");
        });

        return view;
    }
}
