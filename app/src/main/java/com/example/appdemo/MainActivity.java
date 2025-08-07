package com.example.appdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnSaludar, btnFinalizar, btnPreguntar, btnVerificar;
    EditText EdtNombres;

    SwitchCompat switchTerminos;

    private void loadUI() {
        btnSaludar = findViewById(R.id.btnSaludar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        EdtNombres = findViewById(R.id.EdtNombres);
        btnPreguntar = findViewById(R.id.btnPreguntar);

        btnVerificar = findViewById(R.id.btnVerificar);
        switchTerminos = findViewById(R.id.swtTerminos);
    }

    private void Saludar() {
        String nombre = EdtNombres.getText().toString();
        Toast.makeText(getApplicationContext(), "Welcome " + nombre, Toast.LENGTH_LONG).show();
    }

    private void Finalizar() {
        finish();
    }

    // Cread cuadro de pregunta
    private void mostrarPreguntar() {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);

        dialogo.setTitle("Senati");
        dialogo.setMessage("Es un Ingeniero de Sofware?");
        dialogo.setCancelable(false);
        dialogo.setNegativeButton("No", null);
        dialogo.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Saludar();
            }
        });

        dialogo.show();

    }

    private void validarTerminos() {
        boolean aceptado = switchTerminos.isChecked();
        String message = (aceptado) ? "Correcto puede pasar" : "Debe aceptar los terminos";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
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


        // Metodo y Clic
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

        btnPreguntar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarPreguntar();
            }
        });

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarTerminos();
            }
        });
    }
}
