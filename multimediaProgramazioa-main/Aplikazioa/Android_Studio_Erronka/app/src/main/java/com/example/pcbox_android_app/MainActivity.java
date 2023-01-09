package com.example.pcbox_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pcbox_android_app.Model.DatuBaseKonekzioa;
import com.example.pcbox_android_app.Model.Desenkriptatzailea;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.SQLException;
//login prozesua egiten duen klasea da, honen diseinua activity_mainean ikus daiteke
public class MainActivity extends AppCompatActivity {

    private static Connection conexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnHasiSaioa = (Button)findViewById(R.id.btnHasiSaioa);
        EditText txtErabiltzailea= (EditText)findViewById(R.id.txtErabiltzailea);
        EditText txtPasahitza = (EditText)findViewById(R.id.txtPasahitza);
        btnHasiSaioa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean logeatuta = false;
                DatuBaseKonekzioa konekzioa= new DatuBaseKonekzioa(); //datu basearekin konektatzeko
                try {
                    logeatuta = DatuBaseKonekzioa.LogIn(txtErabiltzailea.getText().toString(),txtPasahitza.getText().toString()); //pasahitza eta erabiltzailea okerrak diren edo ez jakiteko
                    if(logeatuta){
                        finish();
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        intent.putExtra("txtErabiltzailea",txtErabiltzailea.getText().toString());
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Pasahitz edo Erabiltzaile okerra.", Toast.LENGTH_LONG).show();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (InvalidKeySpecException e) {
                    e.printStackTrace();
                }


            }
        });
    }

}