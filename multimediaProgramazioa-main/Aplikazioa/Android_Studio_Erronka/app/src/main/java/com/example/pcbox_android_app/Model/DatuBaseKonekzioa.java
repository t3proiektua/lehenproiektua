package com.example.pcbox_android_app.Model;

import android.util.Log;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatuBaseKonekzioa {
    //-------------------------------------------------------------------------------------------
    //Si estás utilizando el emulador de Android y tienes el PostgreSQL en tu misma PC no debes utilizar 127.0.0.1 o localhost como IP, debes utilizar 10.0.2.2
    //Para configurar por ip: cambiar el archivo pg_hba.conf
    //# IPv4 local connections:
    //host    all             all             0.0.0.0/0            scram-sha-256
    //# IPv6 local connections:
    //host    all             all             ::0/0                 scram-sha-256
    //# Allow replication connections from localhost, by a user with the
    //# replication privilege.
    //local   replication     all                                     scram-sha-256
    //host    replication     all             0.0.0.0/0            scram-sha-256
    //host    replication     all             ::0/0                 scram-sha-256
    //------------------------------------------------------------------------------------------
    //Datu basera konektatzeko beharrezko datuak
    private static final String db = "pcBox";
    private static final String url = "jdbc:postgresql://192.168.65.7/" + db;
    private static final String user = "admin";
    private static final String password = "admin004";

    private static boolean status;
    private static boolean estado = false;
    private static int emaitza = 0;
    static Connection conn = null;

    public DatuBaseKonekzioa() {
        connect();
        System.out.println("connection status:" + status);
    }
    //Datu basera konektatzeko metodoa
    public Connection getKonexioa() {
        return conn;
    }
    public static Connection connect() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    conn = DriverManager.getConnection(url, user, password);
                    status = true;
                    Log.i("konexioa", "DB connected:" + true);
                } catch (Exception e) {
                    status = false;
                    Log.w("konexioa", e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            status = false;
        }
        return conn;
    }
    //Datu basera konektatzeko eta bertan datuen bilaketa bat egiteko metodoa. Metodo honek logina ondo joan al den edo ez jakiteko erabiltzen da.
    public static boolean LogIn(String user, String password) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
        String sql = "SELECT users.name, users.password FROM public.users WHERE users.name ='" + user + "' AND users.password = '" + password + "'";
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try (Connection conn = connect();
                     PreparedStatement stmt = conn.prepareStatement(sql);
                     ResultSet rs = stmt.executeQuery())  {
                    while (rs.next()) {
                        String strUser = rs.getString("name").trim();
                        String strPass = rs.getString("password").trim();

                        if (strUser.equals(user) && (strPass.equals(password))) {
                            estado = true;
                            break;
                        } else {
                            estado = false;
                        }
                    }
                } catch (SQLException e) {
                    Log.e("Datu basea", e.getMessage());
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            estado = false;
        }
        return estado;
    }
}

