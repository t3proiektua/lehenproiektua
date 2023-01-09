package t3java.atzipenekoak.bihurtzaileak;
import t3java.atzipenekoak.csva.Csva_Produktuak;
import t3java.atzipenekoak.jsona.Jsona_Produktuak;
import t3java.atzipenekoak.xmla.Xmla_Produktuak;
import t3java.pojoak.produktuak.Produktuak;

public class ProduktuFitxategiBihurtzailea {
    /**
     * Metodo honetan erabiltzaileari ze fitxategi bihurtu nahi duen eskatuko dio.
     * Datuak jaso eta gero hir if etik batean sartuko da eta fitxategi hori bihurtzeko
     * erabiliko duen metodo egokia aukeratuko du.
     */
    public static void bihurtuFitxategia(String fitxategiIzena, String fitxategiFormatua) {
        Produktuak produktuak = new Produktuak();
        try {
            if (fitxategiIzena.contains(".csv")) {
                csvBihurtu(fitxategiIzena, fitxategiFormatua, produktuak);
            }
            if (fitxategiIzena.contains(".json")) {
                jsonBihurtu(fitxategiIzena, fitxategiFormatua, produktuak);
            }
            if (fitxategiIzena.contains(".xml")) {
                xmlBihurtu(fitxategiIzena, fitxategiFormatua, produktuak);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**
     * Metodo honetan csv fitxategia guk aukeratutako beste fitxategi mota batera bihurtzeko
     * gai izango da.
     * @param {String fitxategiIzena, String fitxategiFormatua Produktuak produktuak}
     * 
     */
    public static void csvBihurtu(String fitxategiIzena, String fitxategiFormatua, Produktuak produktuak) {
        Csva_Produktuak csva_Produktuak = new Csva_Produktuak("data/" + fitxategiIzena);
        if (fitxategiFormatua.equals(".csv")) {
            System.out.println("Fitxategia csv bat da beraz ez da bihurtuko.");
        }
        if (fitxategiFormatua.equals(".xml")) {
            Xmla_Produktuak xmla_Produktuak = new Xmla_Produktuak("", "data/bihurtzailea/Produktuak.xml");
            produktuak = csva_Produktuak.irakurri();
            xmla_Produktuak.idatzi(produktuak);
            System.out.println("Fitxategia egoki bihurtu da.");
        }
        if (fitxategiFormatua.equals(".json")) {
            Jsona_Produktuak jsona_Produktuak = new Jsona_Produktuak("", "data/bihurtzailea/Produktuak.json");
            produktuak = csva_Produktuak.irakurri();
            jsona_Produktuak.idatzi(produktuak);
            System.out.println("Fitxategia egoki bihurtu da.");
        }
    }

    /**
     * Metodo honetan json fitxategia guk aukeratutako beste fitxategi mota batera bihurtzeko
     * gai izango da.
     * @param {String fitxategiIzena, String fitxategiFormatua Produktuak produktuak}
     * 
     */
    public static void jsonBihurtu(String fitxategiIzena, String fitxategiFormatua, Produktuak produktuak) {
        Jsona_Produktuak jsona_Produktuak = new Jsona_Produktuak("data/" + fitxategiIzena);
        if (fitxategiFormatua.equals(".csv")) {
            Csva_Produktuak csva_Produktuak = new Csva_Produktuak("", "data/bihurtzailea/Produktuak.csv");
            produktuak = jsona_Produktuak.irakurri();
            csva_Produktuak.idatzi(produktuak);
            System.out.println("Fitxategia egoki bihurtu da.");
        }
        if (fitxategiFormatua.equals(".xml")) {
            Xmla_Produktuak xmla_Produktuak = new Xmla_Produktuak("", "data/bihurtzailea/Produktuak.xml");
            produktuak = jsona_Produktuak.irakurri();
            xmla_Produktuak.idatzi(produktuak);
            System.out.println("Fitxategia egoki bihurtu da.");
        }
        if (fitxategiFormatua.equals(".json")) {
            System.out.println("Fitxategia json bat da beraz ez da bihurtuko.");
        }
    }
    /**
     * Metodo honetan xml fitxategia guk aukeratutako beste fitxategi mota batera bihurtzeko
     * gai izango da.
     * @param {String fitxategiIzena, String fitxategiFormatua Produktuak produktuak}
     * 
     */
    public static void xmlBihurtu(String fitxategiIzena, String fitxategiFormatua, Produktuak produktuak) {
        Xmla_Produktuak xmla_Produktuak = new Xmla_Produktuak("data/" + fitxategiIzena);
        if (fitxategiFormatua.equals(".csv")) {
            Csva_Produktuak csva_Produktuak = new Csva_Produktuak("", "data/bihurtzailea/Produktuak.csv");
            produktuak = xmla_Produktuak.irakurri();
            csva_Produktuak.idatzi(produktuak);
            System.out.println("Fitxategia egoki bihurtu da.");
        }
        if (fitxategiFormatua.equals(".xml")) {
            System.out.printf("Fitxategia xml bat da beraz ez da bihurtuko.");
        }
        if (fitxategiFormatua.equals(".json")) {
            Jsona_Produktuak jsona_Produktuak = new Jsona_Produktuak("", "data/bihurtzailea/Produktuak.json");
            produktuak = xmla_Produktuak.irakurri();
            jsona_Produktuak.idatzi(produktuak);
            System.out.println("Fitxategia egoki bihurtu da.");
        }
    }
}
