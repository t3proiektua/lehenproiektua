package t3java.atzipenekoak.jsona;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import t3java.pojoak.produktuak.Produktua;
import t3java.pojoak.produktuak.Produktuak;

public class Jsona_Produktuak {
    public String strFileIn;
    public String strFileOut;
    public Produktuak produktuak;

    /**
     * Konstruktorea. Parametro bakarra jasotzen badu,
     * sarrera fitxategiaren izena jaso dugula suposatuko da.
     */
    public Jsona_Produktuak(String strFile) {
        strFileIn = strFile;
    }

    /**
     * Konstruktorea. Aldiz, bi parametro jasotzen badira, suposatuko da
     * lehenengoa sarrera fitxategiaren izena izango dela eta bigarrena
     * irteerako fitxategiarena.
     */
    public Jsona_Produktuak(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }    
    public Jsona_Produktuak(Produktuak produktuak, String strFileOut) {
        this.produktuak = produktuak;
        this.strFileOut = strFileOut;
    }

    /**
     * Funtzioa. Objektuen fitxategia JSON formatuan irakurriko duen funtzioa.
     * Bukaeran
     * irakurritako objektuen zerrenda itzuliko du.
     */

    public Produktuak irakurri() {
        Produktuak produktuak = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();
            produktuak = new Produktuak();

            for (int i = 0; i < jsonarray.size(); i++) {
                JsonObject jsonobj = jsonarray.getJsonObject(i);
                Produktua produktua = new Produktua();
                produktua.setId(jsonobj.getInt("id"));
                produktua.setProduktua(jsonobj.getString("produktua"));
                produktua.setDeskribapena(jsonobj.getString("deskribapena"));
                produktua.setPrezioa(jsonobj.getInt("prezioa"));
                produktua.setKantitatea(jsonobj.getInt("kantitatea"));
                produktua.setSaltzekoPrest(jsonobj.getBoolean("saltzekoPrest"));
                produktuak.add(produktua);
            }
        } catch (Exception e) {
            System.out.println("Arazoak " + strFileIn + " fitxategia irakurtzerakoan." + e);
        }
        return produktuak;
    }
    /**
     * Funtzioa. Objektuen fitxategia JSON formatuan idatziko duen funtzioa.
     * Bukaeran idatzi
     * dituen objektuen kopurua itzuliko du.
     */
    public int idatzi(Produktuak produktuak){
        int produktuKopurua = 0;
        JsonArray model = null;
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for(Produktua p : produktuak.getProduktuak()){
            if(p.getDeskribapena() == null || p.getDeskribapena() == ""){
                jab.add(Json.createObjectBuilder()
                .add("id", p.getId())
                .add("produktua", p.getProduktua())
                .add("deskribapena", "Utzik dago")
                .add("prezioa", p.getPrezioa())
                .add("kantitatea", p.getKantitatea())
                .add("saltzekoPrest", p.getSaltzekoPrest())
                .build());
            }else{
                jab.add(Json.createObjectBuilder()
                .add("id", p.getId())
                .add("produktua", p.getProduktua())
                .add("deskribapena", p.getDeskribapena())
                .add("prezioa", p.getPrezioa())
                .add("kantitatea", p.getKantitatea())
                .add("saltzekoPrest", p.getSaltzekoPrest())
                .build());
            }
            produktuKopurua++;
        }
        model = jab.build();
        try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream(strFileOut))) {
            jsonWriter.writeArray(model);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Fitxategia sortzerakoan arazoak.");
        }
        return produktuKopurua;

    }
}