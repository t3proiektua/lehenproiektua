package t3java.atzipenekoak.postgreSQL.inportazioak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Scanner;

import org.postgresql.util.PSQLException;

import t3java.atzipenekoak.csva.Csva_Produktuak;
import t3java.atzipenekoak.jsona.Jsona_Produktuak;
import t3java.atzipenekoak.xmla.Xmla_Produktuak;
import t3java.mainKlasea.MenuNagusia;
import t3java.pojoak.datuBasea.Konekzioa;
import t3java.pojoak.produktuak.Produktua;
import t3java.pojoak.produktuak.Produktuak;

public class ProduktuakInportatu {
    private static Scanner sc = new Scanner(System.in);
    public static Konekzioa konekzioa = new Konekzioa("localhost", "5432", "pcBox", "admin", "admin004");
    public static java.sql.Statement st;
    /**
     * Metodo honetan fitxategiak Odoo kargatzeko balio du.
     * Bertan ze fitxategi kargatu nahi den aukeratu behar da eta gero sql sententzia sortuko du
     * datu basean exekutatzeko.
     */
    public static void datuakInportatu(String fitxategiIzena) throws IOException, PSQLException {
        Produktuak produktuak = new Produktuak();
        produktuak = produktuObjetua(fitxategiIzena);
        String sql = "INSERT INTO public.product_template VALUES";
        int idPT = atzenegoIdPt();
        String produktuIzena, produktuDeskribapena, lerroak;
        double prezioa, kantitatea;
        boolean saltzekoPrest;
        int posizioa = 0;

        if (produktuak != null) {
            // Fitxategiaren lerroak irakurriko ditu.
            BufferedReader inputStream = new BufferedReader(new FileReader("data/inportatzeko/" + fitxategiIzena));
            while ((lerroak = inputStream.readLine()) != null) {
                try {
                    Produktua produktua = produktuak.getProduktuak().get(posizioa);
                    idPT = idPT + 1;
                    produktuIzena = produktua.getProduktua();
                    produktuDeskribapena = produktua.getDeskribapena();
                    prezioa = produktua.getPrezioa();
                    saltzekoPrest = produktua.getSaltzekoPrest();
                    posizioa = posizioa + 1;
                    sql = sql + "(" + idPT + ",NULL,'" + produktuIzena
                            + "',1,'<p><br></p>',NULL,'" + produktuDeskribapena
                            + "','product','product',1," + prezioa
                            + ",10,10," + saltzekoPrest + ",true,1,1,NULL,true,NULL,NULL,false,false,0,6,'2022-10-26 08:32:55.509688',6,'2022-10-26 08:32:55.509688','receive','no-message',NULL,'manual','no-message',NULL,'no','order',false,0,'none',NULL,NULL,NULL),";
                } catch (Exception e) {
                    sql = sql.substring(0, sql.length() - 1);
                    sql = sql + ";";
                    sqlExekutatu(sql);
                } 
            }
        } else {
            System.out.println("Fitxategia utzik dago");
        }
    }
    /**
     * Metodo honetan fitxategian dauden datuak Produktu motako objetu batean pasatuko dira.
     * @param {String fitxategia}
     * 
     */
    public static Produktuak produktuObjetua(String fitxategia) {
        Produktuak produktuak = new Produktuak();

        if (fitxategia.contains(".csv")) {
            Csva_Produktuak csva_Produktuak = new Csva_Produktuak("data/inportatzeko/" + fitxategia);
            return produktuak = csva_Produktuak.irakurri();
        }
        if (fitxategia.contains(".xml")) {
            Xmla_Produktuak xmla_Produktuak = new Xmla_Produktuak("data/inportatzeko/" + fitxategia);
            return produktuak = xmla_Produktuak.irakurri();
        }
        if (fitxategia.contains(".json")) {
            Jsona_Produktuak jsona_Produktuak = new Jsona_Produktuak("data/inportatzeko/" + fitxategia);
            return produktuak = jsona_Produktuak.irakurri();
        } else {
            System.out.println("");
        }
        return produktuak = null;
    }
    /**
     * Metodo honetan produktu atzenengo IDa lortuko du.
     */
    public static int atzenegoIdPt() {
        int id = 0;
        String sql;
        java.sql.Statement st;
        MenuNagusia.datuBaseDatuak();
        // Id autoincremental
        sql = "SELECT MAX(id) FROM product_template";
        try {
            st = konekzioa.connectDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (id < Integer.parseInt(rs.getString(1))) {
                    id = Integer.parseInt(rs.getString(1));
                }
            }
            id = id + 1;
            return id;
        } catch (Exception e) {
            System.out.println(e);
            return id = 0;
        }
    }
    /**
     * Metodo honetan aurreko metodoetan sortutako sql sententzia ejekutatuko du.
     * @param {String sql}
     * 
     */
    public static void sqlExekutatu(String sql) {
        try {
            st = konekzioa.connectDatabase().createStatement();
            st.executeQuery(sql);
        } catch (Exception e) {
        }
    }
}
