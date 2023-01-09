package t3java.pojoak.produktuak;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "produktua", "deskribapena", "prezioa", "kantitatea", "saltzekoPrest" })
@XmlRootElement(name = "Produktua")

public class Produktua {
    int id = 0;
    String produktua, deskribapena;
    double prezioa, kantitatea;
    boolean saltzekoPrest;

    public int getId() {
        return id;
    }

    @XmlAttribute(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    public String getProduktua() {
        return produktua;
    }

    @XmlElement(name = "produktua")
    public void setProduktua(String produktua) {
        this.produktua = produktua;
    }

    public String getDeskribapena() {
        return deskribapena;
    }

    @XmlElement(name = "deskribapena")
    public void setDeskribapena(String deskribapena) {
        this.deskribapena = deskribapena;
    }

    public double getPrezioa() {
        return prezioa;
    }

    @XmlElement(name = "prezioa")
    public void setPrezioa(double prezioa) {
        this.prezioa = prezioa;
    }

    public double getKantitatea() {
        return kantitatea;
    }

    @XmlElement(name = "kantitatea")
    public void setKantitatea(double kantitatea) {
        this.kantitatea = kantitatea;
    }

    public boolean getSaltzekoPrest() {
        return saltzekoPrest;
    }
    @XmlElement(name = "saltzekoPrest")
    public void setSaltzekoPrest(boolean saltzekoPrest) {
        this.saltzekoPrest = saltzekoPrest;
    }
    @Override
    public String toString() {
        return "Produktua [" + id + " " + produktua + " " + deskribapena + " " + prezioa + " " + kantitatea + " " + saltzekoPrest + "]";
    }
}
