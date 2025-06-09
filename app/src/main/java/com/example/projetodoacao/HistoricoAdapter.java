package com.example.projetodoacao;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoricoAdapter extends RecyclerView.Adapter<HistoricoAdapter.ViewHolder> {

    private final List<HistoricoItem> historicoList;

    public HistoricoAdapter(List<HistoricoItem> historicoList) {
        this.historicoList = historicoList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtDescricao, txtData;

        public ViewHolder(View itemView) {
            super(itemView);
            txtDescricao = itemView.findViewById(R.id.txtDescricao);
            txtData = itemView.findViewById(R.id.txtData);
        }
    }

    @NonNull
    @Override
    public HistoricoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historico, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoricoAdapter.ViewHolder holder, int position) {
        HistoricoItem item = historicoList.get(position);
        holder.txtDescricao.setText(item.getDescricao());
        holder.txtData.setText("Data: " + item.getData());
    }

    @Override
    public int getItemCount() {
        return historicoList.size();
    }
}
