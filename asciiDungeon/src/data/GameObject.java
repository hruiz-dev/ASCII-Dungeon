package data;

import data.exceptions.GameLogicException;
import data.noInteractive.Formak;
import kalkuloak.GameMain;

/**
 * Klase hau gure jokoko objetu guztien aita da.
 */
public abstract class GameObject {
    private Vector2 posizioa;
    private Formak forma;
    private Boolean patailan = true;

    public GameObject(Formak forma, Vector2 posizioa) {
        this.forma = forma;
        this.posizioa = posizioa;
    }

    /**
     * Kontruktera hau Estatikoak diren
     * @param forma
     */
    public GameObject(Formak forma) {
        this.forma = forma;
    }


    public int getX() {
        return posizioa.getX();
    }

    public Boolean getPatailan() {
        return patailan;
    }

    public void setPatailan(Boolean patailan) {
        this.patailan = patailan;
    }

    /**
     * Metodo honek gure GameObjetaren posizioa aldatuko du.
     * @param posizioa Posizio berria Vector2 klasea erabilita.
     */
    public void setPosizioa(Vector2 posizioa) {
        this.posizioa = posizioa;
    }

    public int getY() {
        return posizioa.getY();
    }

    public Formak getForma() {
        return forma;
    }

    public Vector2 getPosizioa() {
        return posizioa;
    }

    /**
     * Metodo honek gure GameObjetaren funtzionalitatea ejekutatuko du.
     */
    public abstract GameObject[][] update();

    @Override
    public String toString() {
        return Character.toString(forma.getSymbol());
    }
}
