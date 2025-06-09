package com.example.projetodoacao;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HistoricoDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = new Dialog(requireContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_historico, null);
        dialog.setContentView(view);

        // Aumentar largura do diálogo
        dialog.getWindow().setLayout(
                (int) (getResources().getDisplayMetrics().widthPixels * 0.92),
                WindowManager.LayoutParams.WRAP_CONTENT
        );

        RecyclerView recyclerView = view.findViewById(R.id.recyclerHistorico);
        TextView txtNenhum = view.findViewById(R.id.txtNenhumHistorico);

        // Simular lista de doações (vazia ou com itens)
        List<HistoricoItem> listaHistorico = new ArrayList<>();

        // Exemplo: descomente esta parte para testar com doações simuladas
        /*
        listaHistorico.add(new HistoricoItem("Cesta Básica Completa", "01/06/2025"));
        listaHistorico.add(new HistoricoItem("Monte sua Doação: Arroz + Feijão", "04/06/2025"));
        */

        if (listaHistorico.isEmpty()) {
            txtNenhum.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            txtNenhum.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(new HistoricoAdapter(listaHistorico));
        }

        return dialog;
    }
}
