package com.example.projetodoacao;

public class HistoricoItem {
    private final String descricao;
    private final String data;

    public HistoricoItem(String descricao, String data) {
        this.descricao = descricao;
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }
}
