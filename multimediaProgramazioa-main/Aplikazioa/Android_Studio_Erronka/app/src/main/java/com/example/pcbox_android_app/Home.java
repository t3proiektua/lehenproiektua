package com.example.pcbox_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
//Logina egin ondorengo pantailaren klasea izango da
public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView txtErabiltzailea = (TextView)findViewById(R.id.txtUser);
        //String txtErabiltzailea_Bidalia = "yasta";//getIntent().getExtras().getString("txtErabiltzailea");
        txtErabiltzailea.setTextColor(Color.parseColor("#FF1CD868"));
        txtErabiltzailea.setTextSize(24);
        txtErabiltzailea.setText(getIntent().getExtras().getString("txtErabiltzailea"));
        ImageView btnHasiera = (ImageView)findViewById(R.id.btnHasiera);
        ImageView btnErosketa = (ImageView)findViewById(R.id.btnErosketa);
        ImageView btnKatalogoa = (ImageView)findViewById(R.id.btnKatalogoa);
        btnErosketa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(getApplicationContext(), BezeroenZerrenda.class);
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
    }
}