package com.example.pcbox_android_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pcbox_android_app.Model.ProductAdapter;
import com.example.pcbox_android_app.Model.Produktua;

import java.sql.Connection;
import java.util.ArrayList;
//Produktuen katalogoa erakutsiko duen klasea izango da, honen diseinua activity_katalogoan ikus daiteke
public class Katalogoa extends AppCompatActivity {
    private static Connection conexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katalogoa);
        TextView txtErabiltzailea = (TextView)findViewById(R.id.txtUser3);
        txtErabiltzailea.setTextColor(Color.parseColor("#FF1CD868"));
        txtErabiltzailea.setTextSize(24);
        txtErabiltzailea.setText(getIntent().getExtras().getString("txtErabiltzailea"));
        ImageView btnHasiera = (ImageView)findViewById(R.id.btnHasiera);
        ImageView btnErosketa = (ImageView)findViewById(R.id.btnErosketa);
        ImageView btnKatalogoa = (ImageView)findViewById(R.id.btnKatalogoa);
        btnHasiera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(getApplicationContext(), Home.class);
                intent.putExtra("txtErabiltzailea",txtErabiltzailea.getText().toString());
                startActivity(intent);
            }
        });
        btnErosketa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(getApplicationContext(), BezeroenZerrenda.class);
                intent.putExtra("txtErabiltzailea",txtErabiltzailea.getText().toString());
                startActivity(intent);
            }
        });
        //produktuen zerrenda sortzeko ArrayList bat sortuko dugu eta gure produktuen adapterrari bidaliko diogu guk deklaratutako recycler view-an erakusteko
        ArrayList<Produktua> produktuenZerrenda = Produktua.irakurriProduktuak();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ProductAdapter produkAdapter = new ProductAdapter(produktuenZerrenda, this);
        recyclerView.setAdapter(produkAdapter);
    }
}
