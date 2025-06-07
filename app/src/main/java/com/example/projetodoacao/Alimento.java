package com.example.projetodoacao;

import android.os.Parcel;
import android.os.Parcelable;

public class Alimento implements Parcelable {
    private String nome;
    private String quantidade;

    public Alimento(String nome, String quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    protected Alimento(Parcel in) {
        nome = in.readString();
        quantidade = in.readString();
    }

    public static final Creator<Alimento> CREATOR = new Creator<Alimento>() {
        @Override
        public Alimento createFromParcel(Parcel in) {
            return new Alimento(in);
        }

        @Override
        public Alimento[] newArray(int size) {
            return new Alimento[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(nome);
        parcel.writeString(quantidade);
    }
}
