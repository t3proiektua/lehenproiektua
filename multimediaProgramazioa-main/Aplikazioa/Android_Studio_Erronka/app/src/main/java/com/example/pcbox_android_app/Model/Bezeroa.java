package com.example.pcbox_android_app.Model;
//Bezeroen kudeaketa egiteko klasea
import static com.example.pcbox_android_app.Model.DatuBaseKonekzioa.connect;

import android.util.Log;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Bezeroa {
    private int id;
    private String bezeroa;
    private Date fetxa;
    public Bezeroa() {
    }

    public Bezeroa(int id, String bezeroa, Date fetxa) {
        this.id = id;
        this.bezeroa = bezeroa;
        this.fetxa = fetxa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBezeroa() {
        return bezeroa;
    }

    public void setBezeroa(String bezeroa) {
        this.bezeroa = bezeroa;
    }

    public Date getFetxa() {
        return fetxa;
    }

    public void setFetxa(Date fetxa) {
        this.fetxa = fetxa;
    }

    public static ArrayList<Bezeroa> irakurriBezeroak(){
        ArrayList<Bezeroa> bezeroak = new ArrayList<Bezeroa>();
        //The customer table is named res_partner with field customer=True
        String sql = "SELECT res_partner.id, res_partner.name,res_partner.create_date FROM public.res_partner WHERE res_partner.active = True and res_partner.is_company ORDER BY res_partner.id";
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try (Connection conn = connect();
                     PreparedStatement stmt = conn.prepareStatement(sql);
                     ResultSet rs = stmt.executeQuery())  {
                    while (rs.next()) {
                        bezeroak.add(new Bezeroa(rs.getInt("id"), rs.getString("name"), rs.getDate("create_date")));
                    }
                } catch (SQLException e) {
                    Log.e("BezeroakActivity", e.getMessage());
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bezeroak;
    }
}
