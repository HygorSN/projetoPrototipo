package com.example.projetodoacao;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class PerfilFamiliaDialogFragment extends DialogFragment {

    public PerfilFamiliaDialogFragment() {
        // Construtor vazio obrigatório
    }

    public static PerfilFamiliaDialogFragment newInstance() {
        return new PerfilFamiliaDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_perfil_familia, container, false);

        TextView txtNomeFamilia = view.findViewById(R.id.txtNomeFamilia);
        TextView txtNomeResponsavel = view.findViewById(R.id.txtNomeResponsavel);
        TextView txtCpfResponsavel = view.findViewById(R.id.txtCpfResponsavel);
        TextView txtQuantidadePessoas = view.findViewById(R.id.txtQuantidadePessoas);
        TextView txtRendaMedia = view.findViewById(R.id.txtRendaMedia);
        TextView txtEndereco = view.findViewById(R.id.txtEndereco);
        TextView txtSemLarFixo = view.findViewById(R.id.txtSemLarFixo);
        Button btnFechar = view.findViewById(R.id.btnFechar);

        // Preenchendo com dados fictícios
        txtNomeFamilia.setText("Família Silva");
        txtNomeResponsavel.setText("José Silva");
        txtCpfResponsavel.setText("123.456.789-00");
        txtQuantidadePessoas.setText("5 pessoas");
        txtRendaMedia.setText("R$ 2.500,00");
        txtEndereco.setText("Rua das Flores, Bairro Jardim, Cidade Exemplo - SP");
        txtSemLarFixo.setText("Possui lar fixo");

        btnFechar.setOnClickListener(v -> dismiss());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        // Opcional: Definir largura da dialog para 90% da tela
        if (getDialog() != null && getDialog().getWindow() != null) {
            int width = (int)(getResources().getDisplayMetrics().widthPixels * 0.9);
            getDialog().getWindow().setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}
