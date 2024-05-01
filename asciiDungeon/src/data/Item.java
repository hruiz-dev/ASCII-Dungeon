package data;

import data.noInteractive.Formak;

/**
 * Klase honek erabilgarriak diren objetu guztien aita da
 */
public abstract class Item extends GameObject {

    private String izena;
    private int erabilerak;
    public Item(Formak forma, Vector2 posizioa, String izena, int erabilerak) {
        super(forma, posizioa);
        this.izena = izena;
        this.erabilerak = erabilerak;
    }

    public Item(Formak forma, String izena, int erabilerak) {
        super(forma);
        this.izena = izena;
        this.erabilerak = erabilerak;
    }

    public void setErabilerak(int erabilerak) {
        this.erabilerak = erabilerak;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getIzena() {
        return izena;
    }

    public int getErabilerak() {
        return erabilerak;
    }
}
