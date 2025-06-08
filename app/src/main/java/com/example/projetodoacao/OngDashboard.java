package com.example.projetodoacao;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OngDashboard extends AppCompatActivity {

    private BottomNavigationView bottomNavigationOng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ong_dashboard);

        bottomNavigationOng = findViewById(R.id.bottom_navigation_ong);

        // Fragmento inicial
        loadFragment(new HomeOngFragment());

        bottomNavigationOng.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                int itemId = item.getItemId();
                if (itemId == R.id.nav_painel_ong) {
                    fragment = new HomeOngFragment();
                } else if (itemId == R.id.nav_doacoes_recebidas) {
                    fragment = new DoacoesRecebidasFragment();
                } else if (itemId == R.id.nav_doacoes_notificacao) {
                    fragment = new NotificacaoOngFragment();
                } else if (itemId == R.id.nav_perfil_ong) {
                    fragment = new PerfilOngFragment();
                }

                if (fragment != null) {
                    loadFragment(fragment);
                    return true;
                }
                return false;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_ong, fragment)
                .commit();
    }
}
