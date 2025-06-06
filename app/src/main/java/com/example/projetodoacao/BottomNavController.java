package com.example.projetodoacao;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavController extends BottomNavigationView {

    private OnNavigationItemSelectedListener listener;

    public BottomNavController(Context context) {
        super(context);
        init();
    }

    public BottomNavController(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BottomNavController(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // Configura o listener para seleção de itens
        setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (listener != null) {
                    return listener.onNavigationItemSelected(item);
                }
                return false;
            }
        });
    }

    public void setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener listener) {
        this.listener = listener;
    }
}
