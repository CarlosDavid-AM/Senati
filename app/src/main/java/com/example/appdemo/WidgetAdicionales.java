package com.example.appdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class WidgetAdicionales extends AppCompatActivity {

    Spinner lstProduct, lstTienda;
    WebView webView;

    private void loadUI() {
        lstProduct = findViewById(R.id.lstProductos);
        lstTienda = findViewById(R.id.lstTienda);
        webView = findViewById(R.id.webView);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_widget_adicionales);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Reff
        loadUI();

        // Cargar Datos
        cargarProductos();
        cargarTienda();
        cargarVideo();

        // Eventos
        // Identificando el valor seleccionado
        lstProduct.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Product productSelect = (Product) lstProduct.getSelectedItem();
                Toast.makeText(getApplicationContext(), String.valueOf(productSelect.getPrice()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nada
            }
        });
    }

    private void cargarProductos() {
        // Procedimientos para poblar un SPINER

        // P1: Create a collection of type products.
        ArrayList<Product> listProduct = new ArrayList<>();

        // P2: Add instance the class Product
        listProduct.add(new Product(1, "LG", "Lavadora", 1500));
        listProduct.add(new Product(2, "Samsung", "Televisot", 2500));
        listProduct.add(new Product(3, "Sony", "PS5", 2300));
        listProduct.add(new Product(4, "Lenovo", "Laptop", 1500));
        listProduct.add(new Product(5, "JBL", "Parlantes", 1500));

        // P3: ¡El ArrayList ya tiene datos! > Adactador > Spiner
        ArrayAdapter<Product> adapterProduct = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listProduct);
        lstProduct.setAdapter(adapterProduct);
    }

    private void cargarTienda() {
        ArrayList<Tienda> listTienda = new ArrayList<>();

        listTienda.add(new Tienda(1, "Totus" , "123456"));
        listTienda.add(new Tienda(2, "MegaPlaza" , "456874"));
        listTienda.add(new Tienda(3, "PlazaVea" , "456287"));
        listTienda.add(new Tienda(4, "Falavela" , "212357"));
        listTienda.add(new Tienda(5, "Metro" , "7951235"));

        ArrayAdapter<Tienda> adapterTienda = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listTienda);
        lstTienda.setAdapter(adapterTienda);
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void cargarVideo() {
        String frameVideo = "<iframe width=\"100%\" height=\"315\" src=\"https://www.youtube.com/embed/DlphYPc_HKk?si=1WfenwC6VzHub73r\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";

        // Habilitar JS
        webView.getSettings().setJavaScriptEnabled(true);

        // Manejador del reproductor de video
        webView.setWebChromeClient(new WebChromeClient());

        // Visor para nuestro navegador / bloquear el navegador
        webView.setWebViewClient(new WebViewClient());
        webView.loadData(frameVideo, "text/html", "utf-8");
    }
}