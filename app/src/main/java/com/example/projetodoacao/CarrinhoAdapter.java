package com.example.projetodoacao;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoAdapter.ViewHolder> {

    private ArrayList<Alimento> lista;
    private Context context;

    public CarrinhoAdapter(Context context, ArrayList<Alimento> lista) {
        this.context = context;
        this.lista = lista;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nome, quantidade;
        ImageButton btnExcluir;

        public ViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.txtNomeAlimento);
            quantidade = itemView.findViewById(R.id.txtQuantidade);
            btnExcluir = itemView.findViewById(R.id.btnExcluir);
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

        holder.btnExcluir.setOnClickListener(v -> {
            lista.remove(holder.getAdapterPosition());
            notifyItemRemoved(holder.getAdapterPosition());
        });

        holder.itemView.setOnClickListener(v -> {
            mostrarDialogEdicao(holder.getAdapterPosition());
        });
    }

    private void mostrarDialogEdicao(int posicao) {
        Alimento alimento = lista.get(posicao);

        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_editar_alimento, null);
        EditText editNome = dialogView.findViewById(R.id.editNome);
        EditText editQuantidade = dialogView.findViewById(R.id.editQuantidade);

        editNome.setText(alimento.getNome());
        editQuantidade.setText(alimento.getQuantidade());

        new AlertDialog.Builder(context)
                .setTitle("Editar Alimento")
                .setView(dialogView)
                .setPositiveButton("Salvar", (dialog, which) -> {
                    String novoNome = editNome.getText().toString().trim();
                    String novaQtd = editQuantidade.getText().toString().trim();

                    if (!novoNome.isEmpty() && !novaQtd.isEmpty()) {
                        lista.set(posicao, new Alimento(novoNome, novaQtd));
                        notifyItemChanged(posicao);
                    } else {
                        Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancelar", null)
                .show();
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
