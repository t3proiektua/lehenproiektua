package t3java.atzipenekoak.csva;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import t3java.pojoak.produktuak.Produktua;
import t3java.pojoak.produktuak.Produktuak;

public class Csva_Produktuak {
    public Produktuak produktuak;
    public String strFileIn;
    public String strFileOut;

    /**
     * Konstruktorea. Parametro bakarra jasotzen badu,
     * sarrera fitxategiaren izena jaso dugula suposatuko da.
     */
    public Csva_Produktuak(String strFile) {
        strFileIn = strFile;
    }

    /**
     * Konstruktorea. Aldiz, bi parametro jasotzen badira, suposatuko da
     * lehenengoa sarrera fitxategiaren izena izango dela eta bigarrena
     * irteerako fitxategiarena.
     */
    public Csva_Produktuak(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }
    public Csva_Produktuak(Produktuak produktuak, String strFileOut){
        this.produktuak = produktuak;
        this.strFileOut = strFileOut;
    }
    /**
     * Funtzioa. Objektuen fitxategia CSV formatuan irakurriko duen funtzioa.
     * Bukaeran
     * irakurritako objektuen zerrenda itzuliko du.
     */
    public Produktuak irakurri() {
        Produktuak produktuak = null;

        try (BufferedReader inputStream = new BufferedReader(new FileReader(strFileIn))) {
            String banatzailea = ";";
            String lerroa;


            produktuak = new Produktuak();
            while ((lerroa = inputStream.readLine()) != null) {
                String[] eremuak = lerroa.split(banatzailea);
                if (!eremuak[0].equals("ID")) {
                    Produktua produktua = new Produktua();
                    produktua.setId(produktuak.getProduktuak() == null ? 0 : produktuak.getProduktuak().size());
                    produktua.setProduktua(eremuak[1]);
                    produktua.setDeskribapena(eremuak[2]);
                    produktua.setPrezioa(Double.parseDouble(eremuak[3]));
                    produktua.setKantitatea(Double.parseDouble(eremuak[4]));
                    produktua.setSaltzekoPrest(Boolean.parseBoolean(eremuak[5]));
                    produktuak.add(produktua);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ez da " + strFileIn + " fitxategia aurkitu. " + e);
        } catch (IOException e) {
            System.out.println("IOsalbuespena gertatu da.");
        }
        return produktuak;
    }
    /**
     * Funtzioa. Objektuen fitxategia CSV formatuan idatziko duen funtzioa. Bukaeran
     * idatzi
     * dituen objektuen kopurua itzuliko du.
     */

     public int idatzi(Produktuak produktuak){
        int produktuKopurua = 0;
        try (PrintWriter outputStream = new PrintWriter(new FileWriter(strFileOut))){
            for(Produktua p : produktuak.getProduktuak()){
                if(produktuKopurua == 0){
                    outputStream.println("ID;PRODUKTUA;DESKRIBAPENA;PREZIOA;KANTITATEA;SALTZEKO_PREST");
                }
                produktuKopurua++;
                outputStream.println(p.getId()+";"+p.getProduktua()+";"+p.getDeskribapena()+";"+p.getPrezioa()+";"+p.getKantitatea()+";"+p.getSaltzekoPrest());
            }
        } catch (Exception e) {
            System.out.println(strFileOut + " fitxategiarekin arazoren bat egon da.");
        }
        return produktuKopurua;
     }
}
