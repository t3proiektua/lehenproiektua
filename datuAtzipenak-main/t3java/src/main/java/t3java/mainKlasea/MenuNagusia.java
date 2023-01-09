package t3java.mainKlasea;

import java.io.IOException;
import java.util.Scanner;

import t3java.atzipenekoak.bihurtzaileak.ProduktuFitxategiBihurtzailea;
import t3java.atzipenekoak.postgreSQL.crud.ProduktuakManipulatu;
import t3java.atzipenekoak.postgreSQL.esportazioak.ProduktuakEsportatu;
import t3java.atzipenekoak.postgreSQL.inportazioak.ProduktuakInportatu;
import t3java.pojoak.datuBasea.Konekzioa;

public class MenuNagusia {
    private static String host, port, database, user, password;
    private static Scanner sc = new Scanner(System.in);
    public static String aukera;

    public static void main(String[] args) throws IOException {
        do {
            garbitu();
            System.out.println("---------------------------------------------------------");
            System.out.println("-------------  ONGI ETORRI GURE APLIKAZIORA  ------------");
            System.out.println("---------------------------------------------------------");
            System.out.println("1.Produktuak fitxategira esportatu");
            System.out.println("2.Datuak fitxategira inportatu");
            System.out.println("3.Produktu fitxategien bihurtzailea");
            System.out.println("4.Produktu Datu basea manipulatu");
            System.out.println("0.Irten");
            System.out.println("---------------------------------------------------------");
            System.out.printf("Zer egin nahi duzu? ");
            aukera = sc.next();
            switch (aukera) {
                case "1":
                    produktuakEsportatu();
                    break;
                case "2":
                    produktuakInportatu();
                    break;
                case "3":
                    produktuFitxeroBihurtzailea();
                    break;
                case "4":
                    produktuakManipulatu();
                    break;
            }
        } while (!aukera.equals("0"));
        garbitu();
        System.out.println(
                "########  ######  ##    ## ######## ########  ########  #### ##    ##       ###     ######  ##    ##  ####### ");
        System.out.println(
                "##       ##    ## ##   ##  ##       ##     ## ##     ##  ##  ##   ##       ## ##   ##    ## ##   ##  ##     ##");
        System.out.println(
                "##       ##       ##  ##   ##       ##     ## ##     ##  ##  ##  ##       ##   ##  ##       ##  ##   ##     ##");
        System.out.println(
                "######    ######  #####    ######   ########  ########   ##  #####       ##     ##  ######  #####    ##     ##");
        System.out.println(
                "##             ## ##  ##   ##       ##   ##   ##   ##    ##  ##  ##      #########       ## ##  ##   ##     ##");
        System.out.println(
                "##       ##    ## ##   ##  ##       ##    ##  ##    ##   ##  ##   ##     ##     ## ##    ## ##   ##  ##     ##");
        System.out.println(
                "########  ######  ##    ## ######## ##     ## ##     ## #### ##    ##    ##     ##  ######  ##    ##  #######");
        sc.close();
    }

    // ---------------------------------------------------------
    // --------------------- PRODUKTUAK ------------------------
    // ---------------------------------------------------------
    public static void produktuakEsportatu() {
        garbitu();
        datuBaseDatuak();
        Konekzioa konekzioa = new Konekzioa(host, port, database, user, password);
        do {
            System.out.println("---------------------------------------------------------");
            System.out.println("-------------  PRODUKTUAK EXPORTATZEKO MENUA  -----------");
            System.out.println("---------------------------------------------------------");
            System.out.println("1.Datuak CSV fitxategira pasatu");
            System.out.println("2.Datuak XML fitxategira pasatu");
            System.out.println("3.Datuak Json fitxategira pasatu");
            System.out.println("4.Datuak fitxategi denetara pasatu");
            System.out.println("5.Atzera");
            System.out.println("---------------------------------------------------------");
            System.out.printf("Zer egin nahi duzu? ");
            aukera = sc.next();
            try {
                switch (aukera) {
                    // Datuak csvra pasatu
                    case "1":
                        ProduktuakEsportatu.produktuakEsportatuCSV(konekzioa);
                        break;
                    // Datuak XML pasatu
                    case "2":
                        ProduktuakEsportatu.produktuakEsportatuXML(konekzioa);
                        break;
                    // Datuak Jsonera pasatu
                    case "3":
                        ProduktuakEsportatu.produktuakEsportatuJSON(konekzioa);
                        break;
                    // Fitxategi denak sortu
                    case "4":
                        ProduktuakEsportatu.produktuakEsportatuDenetara(konekzioa);
                        break;
                    case "5":
                        garbitu();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!aukera.equals("5"));
    }

    public static void produktuakManipulatu() {
        datuBaseDatuak();
        Konekzioa konekzioa = new Konekzioa(host, port, database, user, password);
        garbitu();
        do {
            System.out.println("---------------------------------------------------------");
            System.out.println("-----------------  PRODUKTUAK MANIPULATU  ---------------");
            System.out.println("---------------------------------------------------------");
            System.out.println("1.Produktu bat insertatu");
            System.out.println("2.Produktu bat ezabatu");
            System.out.println("3.Produktu bat eguneratu");
            System.out.println("4.Produktu lista ikusi");
            System.out.println("5.Atzera");
            System.out.println("---------------------------------------------------------");
            System.out.printf("Zer egin nahi duzu? ");
            aukera = sc.next();
            try {
                garbitu();
                switch (aukera) {
                    // Produktu bat insertatu
                    case "1":
                        ProduktuakManipulatu.insertProduktuak(konekzioa);
                        garbitu();
                        break;
                    // Produktu bat ezabatu
                    case "2":
                        ProduktuakManipulatu.deleteProduktuak(konekzioa);
                        garbitu();
                        break;
                    // Produktu bat eguneratu
                    case "3":
                        ProduktuakManipulatu.updateProduktuak(konekzioa);
                        garbitu();
                        break;
                    // Produktu lista ikusi
                    case "4":
                        ProduktuakManipulatu.selectProduktuak(konekzioa);
                        break;
                    case "5":
                        garbitu();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!aukera.equals("5"));
    }

    public static void produktuFitxeroBihurtzailea() {
        String fitxategiIzena;
        do {
            garbitu();
            System.out.println("---------------------------------------------------------");
            System.out.println("-----------------  FITXERO BIHURTZAILEA  ----------------");
            System.out.println("---------------------------------------------------------");
            System.out.printf("Zer fitxategi bihurtu nahi duzu? ");
            fitxategiIzena = sc.next();
            System.out.println();
            System.out.println("1.XML fitxategira bihurtu nahi dut.");
            System.out.println("2.Json fitxategira bihurtu nahi dut.");
            System.out.println("3.CSV fitxategira bihurtu nahi dut.");
            System.out.println("4.Atzera.");
            System.out.println("---------------------------------------------------------");
            System.out.printf("Zer egin nahi duzu? ");
            aukera = sc.next();
            try {
                switch (aukera) {
                    case "1":
                        ProduktuFitxategiBihurtzailea.bihurtuFitxategia(fitxategiIzena, ".xml");
                        break;
                    case "2":
                        ProduktuFitxategiBihurtzailea.bihurtuFitxategia(fitxategiIzena, ".json");
                        break;
                    case "3":
                        ProduktuFitxategiBihurtzailea.bihurtuFitxategia(fitxategiIzena, ".csv");
                        break;
                    case "4":
                        garbitu();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!aukera.equals("4"));
    }

    public static void produktuakInportatu() {
        String fitxategiIzena;
        garbitu();
        do {
            System.out.println("---------------------------------------------------------");
            System.out.println("-------------------  DATUAK INPORTATU  ------------------");
            System.out.println("---------------------------------------------------------");
            System.out.println("1.Fitxategia aukeratu.");
            System.out.println("2.Atzera.");
            System.out.println("---------------------------------------------------------");
            System.out.printf("Zer egin nahi duzu? ");
            aukera = sc.next();
            if (aukera.equals("1")) {
                garbitu();
                System.out.printf("Ze fitxategi inportatuko duzu? ");
                fitxategiIzena = sc.next();
            } else {
                fitxategiIzena = null;
            }
            try {
                switch (aukera) {
                    case "1":
                        ProduktuakInportatu.datuakInportatu(fitxategiIzena);
                        break;
                    case "2":
                        garbitu();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!aukera.equals("2"));
    }

    public static void garbitu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // ---------------------------------------------------------
    // ----------------------- KONEXIOA ------------------------
    // ---------------------------------------------------------
    public static void datuBaseDatuak() {
        host = "localhost";
        port = "5432";
        database = "pcBox";
        user = "admin";
        password = "admin004";
    }
}
