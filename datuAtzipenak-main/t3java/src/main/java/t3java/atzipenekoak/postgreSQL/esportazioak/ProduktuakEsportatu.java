package t3java.atzipenekoak.postgreSQL.esportazioak;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;

import t3java.atzipenekoak.csva.Csva_Produktuak;
import t3java.atzipenekoak.jsona.Jsona_Produktuak;
import t3java.atzipenekoak.xmla.Xmla_Produktuak;
import t3java.pojoak.datuBasea.Konekzioa;
import t3java.pojoak.produktuak.Produktua;
import t3java.pojoak.produktuak.Produktuak;

public class ProduktuakEsportatu {
    /**
     * Metodo honetan datubaseko datuak irakurriko ditu eta Java Produkto motako
     * objetuan gordeko ditu. Hori egin eta gero objetua erabiliz sql sententzia bat sortuko du.
     * Amaitzeko CSV fitxategi bat sortuko da datubaseko datuekin.
     * @param {Konekzioa konekzioa}
     * 
     */
    public static Produktuak produktuakEsportatuCSV(Konekzioa konekzioa) throws IOException {
        Produktuak produktuak = new Produktuak();
        File f = new File("data/dataproduktuak.csv");
        if (!f.exists()) {
            f.createNewFile();
        }
        Csva_Produktuak csvProduktuak = new Csva_Produktuak("", "data/dataproduktuak.csv");

        String sql = "SELECT pr.id, pr.name, pr.description_sale, pr.list_price, st.quantity, pr.sale_ok FROM public.product_template pr JOIN public.stock_valuation_layer st ON st.id = pr.id";
        java.sql.Statement st;
        try {
            st = konekzioa.connectDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Produktua produktua = new Produktua();
                produktua.setId(Integer.parseInt(rs.getString(1)));
                produktua.setProduktua(rs.getString(2));
                produktua.setDeskribapena(rs.getString(3));
                produktua.setPrezioa(rs.getDouble(4));
                produktua.setKantitatea(rs.getDouble(5));
                produktua.setSaltzekoPrest(rs.getBoolean(6));
                produktuak.add(produktua);
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
        System.out.println(csvProduktuak.idatzi(produktuak) + " produktu idatzi dira CSV fitxategian.");
        return produktuak;
    }
    /**
     * Metodo honetan datubaseko datuak irakurriko ditu eta Java Produkto motako
     * objetuan gordeko ditu. Hori egin eta gero objetua erabiliz sql sententzia bat sortuko du.
     * Amaitzeko XML fitxategi bat sortuko da datubaseko datuekin.
     * @param {Konekzioa konekzioa}
     * 
     */
    public static Produktuak produktuakEsportatuXML(Konekzioa konekzioa) throws IOException {
        Produktuak produktuak = new Produktuak();
        File f = new File("data/dataproduktuak.xml");
        if (!f.exists()) {
            f.createNewFile();
        }
        Xmla_Produktuak xmlProduktuak = new Xmla_Produktuak("", "data/dataproduktuak.xml");
        String sql = "SELECT pr.id, pr.name, pr.description_sale, pr.list_price, st.quantity, pr.sale_ok FROM public.product_template pr JOIN public.stock_valuation_layer st ON st.id = pr.id";
        java.sql.Statement st;
        try {
            st = konekzioa.connectDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Produktua produktua = new Produktua();
                produktua.setId(Integer.parseInt(rs.getString(1)));
                produktua.setProduktua(rs.getString(2));
                produktua.setDeskribapena(rs.getString(3));
                produktua.setPrezioa(rs.getDouble(4));
                produktua.setKantitatea(rs.getDouble(5));
                produktua.setSaltzekoPrest(rs.getBoolean(6));
                produktuak.add(produktua);
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
        System.out.println(xmlProduktuak.idatzi(produktuak) + " produktu idatzi dira XML fitxategian.");
        return produktuak;
    }
    /**
     * Metodo honetan datubaseko datuak irakurriko ditu eta Java Produkto motako
     * objetuan gordeko ditu. Hori egin eta gero objetua erabiliz sql sententzia bat sortuko du.
     * Amaitzeko Json fitxategi bat sortuko da datubaseko datuekin.
     * @param {Konekzioa konekzioa}
     * 
     */
    public static Produktuak produktuakEsportatuJSON(Konekzioa konekzioa) throws IOException {
        Produktuak produktuak = new Produktuak();
        File f = new File("data/dataproduktuak.json");
        if (!f.exists()) {
            f.createNewFile();
        }
        Jsona_Produktuak jsonProduktuak = new Jsona_Produktuak("", "data/dataproduktuak.json");
        String sql = "SELECT pr.id, pr.name, pr.description_sale, pr.list_price, st.quantity, pr.sale_ok FROM public.product_template pr JOIN public.stock_valuation_layer st ON st.id = pr.id";
        java.sql.Statement st;
        try {
            st = konekzioa.connectDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Produktua produktua = new Produktua();
                produktua.setId(Integer.parseInt(rs.getString(1)));
                produktua.setProduktua(rs.getString(2));
                String deskribapena = rs.getString(3);
                if (deskribapena == null) {
                    produktua.setDeskribapena("Utzik dago");
                } else {
                    produktua.setDeskribapena(rs.getString(3));
                }
                produktua.setPrezioa(rs.getDouble(4));
                produktua.setKantitatea(rs.getDouble(5));
                produktua.setSaltzekoPrest(rs.getBoolean(6));
                produktuak.add(produktua);
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
        System.out.println(jsonProduktuak.idatzi(produktuak) + " produktu idatzi dira JSON fitxategian.");
        return produktuak;
    }
    /**
     * Metodo honetan datubaseko datuak irakurriko ditu eta Java Produkto motako
     * objetuan gordeko ditu. Hori egin eta gero objetua erabiliz sql sententzia bat sortuko du.
     * Amaitzeko datuak hiru formatuetara exportatuko ditu.
     * @param {String Konekzioa konekzioa}
     * 
     */
    public static void produktuakEsportatuDenetara(Konekzioa konekzioa) throws IOException {
        produktuakEsportatuCSV(konekzioa);
        produktuakEsportatuXML(konekzioa);
        produktuakEsportatuJSON(konekzioa);
    }
}