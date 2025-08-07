package com.example.appdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnSaludar, btnFinalizar;
    EditText EdtNombres;

    private void loadUI() {
        btnSaludar = findViewById(R.id.btnSaludar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        EdtNombres = findViewById(R.id.EdtNombres);
    }

    private void Saludar() {
        String nombre = EdtNombres.getText().toString();
        Toast.makeText(getApplicationContext(), "Welcome Dev Android", Toast.LENGTH_LONG).show();
    }

    private void Finalizar() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            // v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loadUI();


        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Saludar();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Finalizar();
            }
        });
    }
}
