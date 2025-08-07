package com.example.appdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnSaludar, btnFinalizar, btnPreguntar, btnVerificar, btnTurno, btnAbrirActivity;
    EditText EdtNombres;

    SwitchCompat switchTerminos;

    RadioButton optMa, optTa, optNo;

    private void loadUI() {
        btnSaludar = findViewById(R.id.btnSaludar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        EdtNombres = findViewById(R.id.EdtNombres);
        btnPreguntar = findViewById(R.id.btnPreguntar);

        btnVerificar = findViewById(R.id.btnVerificar);
        switchTerminos = findViewById(R.id.swtTerminos);

        btnTurno = findViewById(R.id.Turno);

        optMa = findViewById(R.id.optMa);
        optTa = findViewById(R.id.optTa);
        optNo = findViewById(R.id.optNo);

        btnAbrirActivity = findViewById(R.id.btnAbrirActivity);
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

    public void turnoIdentificado() {
        boolean aceptadoMa = optMa.isChecked();
        boolean aceptadoTa = optTa.isChecked();
        boolean aceptadoNo = optNo.isChecked();

        if (aceptadoMa) {
            Toast.makeText(getApplicationContext(), "Su turno es de mañana", Toast.LENGTH_LONG).show();
        }

        if (aceptadoTa) {
            Toast.makeText(getApplicationContext(), "Su turno es de la tarde", Toast.LENGTH_LONG).show();
        }

        if (aceptadoNo) {
            Toast.makeText(getApplicationContext(), "Su turno es de noche", Toast.LENGTH_LONG).show();
        }
    }

    private void validarTerminos() {
        boolean aceptado = switchTerminos.isChecked();
        String message = (aceptado) ? "Correcto puede pasar" : "Debe aceptar los terminos";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    private void abrirActivity() {
        Intent intent = new Intent(getApplicationContext(), WidgetAdicionales.class);
        startActivity(intent);
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

        btnTurno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnoIdentificado();
            }
        });

        btnAbrirActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActivity();
            }
        });
    }
}
