package render;

import data.noInteractive.Estatikoa;
import data.noInteractive.Formak;
import data.Vector2;

/**
 * Klase hau gure interfazeako komponeteak sortzeko aita klasea da.
 */
public abstract class Ui {
    private Vector2 posizioa;
    private Formak[][] datuak;

    public Ui(Vector2 posizioa, Formak[][] datuak) {
        this.posizioa = posizioa;
        this.datuak = datuak;
    }

    public Vector2 getPosizioa() {
        return posizioa;
    }

    public void setPosizioa(Vector2 posizioa) {
        this.posizioa = posizioa;
    }

    public Formak[][] getForma() {
        return datuak;
    }

    public void setForma(Formak[][] datuak) {
        this.datuak = datuak;
    }

    /**
     * Metodo hau pantailako Ui-a berriz kargatzeko erabiliko eta renderizatzeko erabiliko da.
     */
    public abstract void updateUi();

    /**
     * Funtzi honek gure Ui objetua gameobjet Objtu Estakoikoa kalsera pasatuko du gero renderizazio matrizean sartzeko
     * @return Ui diseinua GameObject matrizea bezela
     */
    public abstract Estatikoa[][] toGameObject();
}
