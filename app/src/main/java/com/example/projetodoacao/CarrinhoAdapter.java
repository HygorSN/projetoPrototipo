package com.example.projetodoacao;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoAdapter.ViewHolder> {

    private ArrayList<Alimento> lista;

    public CarrinhoAdapter(ArrayList<Alimento> lista) {
        this.lista = lista;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nome, quantidade;

        public ViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.txtNomeAlimento);
            quantidade = itemView.findViewById(R.id.txtQuantidade);
        }
    }

    @NonNull
    @Override
    public CarrinhoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_alimento, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Alimento alimento = lista.get(position);
        holder.nome.setText(alimento.getNome());
        holder.quantidade.setText("Quantidade: " + alimento.getQuantidade());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
