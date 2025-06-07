package com.example.projetodoacao;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EscolhaOngActivity extends AppCompatActivity {

    private Button btnEscolherOng, btnAppEscolhe, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_ong);

        btnEscolherOng = findViewById(R.id.btnEscolherOng);
        btnAppEscolhe = findViewById(R.id.btnAppEscolhe);
        btnCancelar = findViewById(R.id.btnCancelar); // novo botão

        btnEscolherOng.setOnClickListener(v -> {
            Toast.makeText(this, "Ir para seleção de ONG", Toast.LENGTH_SHORT).show();
            // Exemplo: startActivity(new Intent(this, SelecionarOngActivity.class));
        });

        btnAppEscolhe.setOnClickListener(v -> {
            Toast.makeText(this, "ONG será escolhida automaticamente", Toast.LENGTH_SHORT).show();
        });

        btnCancelar.setOnClickListener(v -> {
            Toast.makeText(this, "Doação cancelada", Toast.LENGTH_SHORT).show();
            finish(); // volta para a activity anterior (com fragment_home)
        });
    }
}

