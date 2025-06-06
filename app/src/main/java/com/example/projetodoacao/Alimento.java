package com.example.projetodoacao;

public class Alimento {
    private String nome;
    private String quantidade;

    public Alimento(String nome, String quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public String getQuantidade() {
        return quantidade;
    }
}
