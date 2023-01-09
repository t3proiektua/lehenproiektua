package t3java.atzipenekoak.postgreSQL.crud;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import t3java.pojoak.datuBasea.Konekzioa;

public class ProduktuakManipulatu {
    /**
     * Produktu berri bat sortzeko balio duen metodoa da
     * 
     * @param {Konekzioa konekzioa}
     */
    public static void insertProduktuak(Konekzioa konekzioa) {
        int id = 0;
        String produktuIzena, deskribapena, sql, data, saltzekoPrestString;
        float kantitatea;
        boolean saltzekoPrest;
        java.sql.Statement st;
        Double prezioa;
        data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date());
        Scanner sc = new Scanner(System.in);

        System.out.printf("Zein da produktuaren izena? ");
        produktuIzena = sc.next();
        System.out.printf("Zein da produktuaren deskribapena? ");
        deskribapena = sc.next();
        System.out.printf("Zein da produktuaren prezioa? ");
        prezioa = sc.nextDouble();
        System.out.printf("Produktua saltzeko prest dago?(Bai ez)");
        saltzekoPrestString = sc.next().toLowerCase();

        if (saltzekoPrestString.equals("bai")) {
            saltzekoPrest = true;
        } else {
            saltzekoPrest = false;
        }

        // Id autoincremental
        sql = "SELECT MAX(id) FROM product_template";
        try {
            st = konekzioa.connectDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println(id);
            while (rs.next()) {
                if (id < Integer.parseInt(rs.getString(1))) {
                    id = Integer.parseInt(rs.getString(1));
                    System.out.println(id);
                }
            }
            id = id + 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        // Insert produktuak
        sql = "INSERT INTO public.product_template VALUES(" + id + ",NULL,'" + produktuIzena
                + "',1,'<p><br></p>',NULL,'" + deskribapena
                + "','product','product',1," + prezioa
                + ",10,10," + saltzekoPrest + ",true,1,1,NULL,true,NULL,NULL,false,false,0,6,'" + data + "',6,'" + data
                + "','receive','no-message',NULL,'manual','no-message',NULL,'no','order',false,0,'none',NULL,NULL,NULL)";
        try {
            st = konekzioa.connectDatabase().createStatement();
            st.executeUpdate(sql);
            System.out.println("Produktua sortu egin da.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Insert edo Inport batekin sortutako produktu bat ezabatzeko balio duen
     * metodoa da.
     * 
     * @param {Konekzioa konekzioa}
     */
    public static void deleteProduktuak(Konekzioa konekzioa) {
        Scanner sc = new Scanner(System.in);
        String sql;
        java.sql.Statement st;
        int id;

        selectProduktuak(konekzioa);
        System.out.println("---------------------------------------------------------");
        System.out.println("-------------------  EZABATU PRODUKTUA  -----------------");
        System.out.println("---------------------------------------------------------");
        System.out.println("Ze produktu kenduko duzu(id):");
        id = sc.nextInt();

        sql = "DELETE FROM public.product_template WHERE id=" + id;
        try {
            st = konekzioa.connectDatabase().createStatement();
            st.executeUpdate(sql);
            System.out.println("Produktua ezabatu egin da.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Insert edo Inport batekin sortutako produktu bat aldatzeko balio duen
     * metodoa da.
     * 
     * @param {Konekzioa konekzioa}
     */
    public static void updateProduktuak(Konekzioa konekzioa) {
        Scanner sc = new Scanner(System.in);
        String sql, produktuIzena, deskribapena, saltzekoPrestString;
        java.sql.Statement st;
        Double prezioa;
        boolean saltzekoPrest;
        int id;

        selectProduktuak(konekzioa);
        System.out.println("---------------------------------------------------------");
        System.out.println("--------------------  UPDATE PRODUKTUA  -----------------");
        System.out.println("---------------------------------------------------------");
        System.out.printf("Ze produktu eguneratuko duzu(id):");
        id = sc.nextInt();
        System.out.printf("Zein da produktuaren izena? ");
        produktuIzena = sc.next();
        System.out.printf("Zein da produktuaren deskribapena? ");
        deskribapena = sc.next();
        System.out.printf("Zein da produktuaren prezioa? ");
        prezioa = sc.nextDouble();
        System.out.printf("Produktua saltzeko prest dago?(Bai ez)");
        saltzekoPrestString = sc.next().toLowerCase();

        if (saltzekoPrestString.equals("bai")) {
            saltzekoPrest = true;
        } else {
            saltzekoPrest = false;
        }

        sql = "UPDATE public.product_template SET name='" + produktuIzena + "', description_sale='" + deskribapena
                + "', list_price='" + prezioa + "',sale_ok='"+ saltzekoPrest + "' WHERE id=" + id;

        try {
            st = konekzioa.connectDatabase().createStatement();
            st.executeUpdate(sql);
            System.out.println("Produktua bat aldatu egin da.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Select metodotik jasotako datuak bistaratzeko balio du.
     * 
     * @param {Konekzioa konekzioa}
     */
    public static ArrayList<String> selectProduktuak(Konekzioa konekzioa) {
        System.out.println("Hurrengoko datuak produktuak dira:");
        String sql = "SELECT pr.id, pr.name, pr.description_sale, pr.list_price, st.quantity, pr.sale_ok FROM public.product_template pr JOIN public.stock_valuation_layer st ON st.id = pr.id ORDER BY id";
        ArrayList<String> produktuLista = new ArrayList<String>();
        java.sql.Statement st;
        try {
            st = konekzioa.connectDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                produktuLista
                        .add(rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getString(3) + ";" + rs.getString(4)
                                + ";" + rs.getString(5) + ";" + rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
        zerrendaBistaratu(produktuLista);
        return produktuLista;
    }

    /**
     * Select metodotik jasotako datuak bistaratzeko balio du.
     * 
     * @param {ArrayList<String> zerrenda}
     */
    public static void zerrendaBistaratu(ArrayList<String> zerrenda) {
        for (int j = 0; j < zerrenda.size(); j++) {
            System.out.println(zerrenda.get(j));
        }
    }
}
