package com.example.projetodoacao;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DoacaoAdapter extends RecyclerView.Adapter<DoacaoAdapter.DoacaoViewHolder> {

    private final List<String> listaDoacoes;

    public DoacaoAdapter(List<String> listaDoacoes) {
        this.listaDoacoes = listaDoacoes;
    }

    @NonNull
    @Override
    public DoacaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_doacao, parent, false);
        return new DoacaoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DoacaoViewHolder holder, int position) {
        String doacao = listaDoacoes.get(position);
        holder.txtItemDoacao.setText(doacao);
    }

    @Override
    public int getItemCount() {
        return listaDoacoes.size();
    }

    static class DoacaoViewHolder extends RecyclerView.ViewHolder {
        TextView txtItemDoacao;

        public DoacaoViewHolder(@NonNull View itemView) {
            super(itemView);
            txtItemDoacao = itemView.findViewById(R.id.txtItemDoacao);
        }
    }
}
