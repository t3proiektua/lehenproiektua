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

import com.example.pcbox_android_app.Model.Bezeroa;
import com.example.pcbox_android_app.Model.CustomerAdapter;

import java.sql.Connection;
import java.util.ArrayList;
//bezeroen zerrenda egingo duen klasea izango da. Hau activity_bezeroak ikusiko da
public class BezeroenZerrenda extends AppCompatActivity {
    private static Connection conexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezeroak);
        TextView txtErabiltzailea = (TextView)findViewById(R.id.txtUser2);
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
        btnKatalogoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(getApplicationContext(), Katalogoa.class);
                intent.putExtra("txtErabiltzailea",txtErabiltzailea.getText().toString());
                startActivity(intent);
            }
        });
        //bezeroen zerrenda sortzeko ArrayList bat sortuko dugu eta gure bezeroen adapterrari bidaliko diogu guk deklaratutako recycler view-an erakusteko
        ArrayList<Bezeroa> bezeroenZerrenda = Bezeroa.irakurriBezeroak();
        RecyclerView recyclerViewBez = findViewById(R.id.recyclerViewBez);
        recyclerViewBez.setHasFixedSize(true);
        recyclerViewBez.setLayoutManager(new LinearLayoutManager(this));

        CustomerAdapter bezeroaAdapter = new CustomerAdapter(bezeroenZerrenda, this);
        recyclerViewBez.setAdapter(bezeroaAdapter);
    }

}