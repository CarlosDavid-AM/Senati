package com.example.appdemo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class WidgetAdicionales extends AppCompatActivity {

    Spinner lstProduct, lstTienda;

    private void loadUI() {
        lstProduct = findViewById(R.id.lstProductos);
        lstTienda = findViewById(R.id.lstTienda);
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

        loadUI();

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



        ArrayList<Tienda> listTienda = new ArrayList<>();

        listTienda.add(new Tienda(1, "Totus" , "123456"));
        listTienda.add(new Tienda(2, "MegaPlaza" , "456874"));
        listTienda.add(new Tienda(3, "PlazaVea" , "456287"));
        listTienda.add(new Tienda(4, "Falavela" , "212357"));
        listTienda.add(new Tienda(5, "Metro" , "7951235"));

        ArrayAdapter<Tienda> adapterTienda = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listTienda);
        lstTienda.setAdapter(adapterTienda);
    }
}