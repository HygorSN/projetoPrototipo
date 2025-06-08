package com.example.projetodoacao;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EstoqueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Janela sem título
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        // Layout de sobreposição com fundo semi-transparente
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        getWindow().setDimAmount(0.6f);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        setContentView(R.layout.activity_estoque);

        // Arredondando o contêiner principal programaticamente
        LinearLayout container = findViewById(R.id.containerEstoque);
        GradientDrawable background = new GradientDrawable();
        background.setColor(Color.WHITE);
        background.setCornerRadius(48f); // Bordas arredondadas
        container.setBackground(background);

        // Inicializando RecyclerView (exemplo)
        RecyclerView recyclerView = findViewById(R.id.recyclerEstoque);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // recyclerView.setAdapter(new SeuAdapter()); // Adicione o adapter real aqui
    }
}
