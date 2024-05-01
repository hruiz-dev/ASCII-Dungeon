package render;

import data.GameMainData;
import data.GameObject;
import data.noInteractive.Estatikoa;
import data.noInteractive.Formak;
import data.Vector2;

/**
 * Klase hau gure interfazeako komponeteak sortzeko aita klasea da.
 */
public abstract class Ui {
    private GameObject[][] datuak;

    public Ui( GameObject[][] datuak) {
        this.datuak = datuak;
        GameMainData.getUiKomponenteak().add(this);
    }

    public GameObject[][] getForma() {
        return datuak;
    }

    public GameObject[][] getDatuak() {
        return datuak;
    }

    public void setDatuak(GameObject[][] datuak) {
        this.datuak = datuak;
    }

    public void setForma(GameObject[][] datuak) {
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
}
