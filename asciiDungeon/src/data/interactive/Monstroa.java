package data.interactive;

import data.GameObject;
import data.Vector2;
import data.noInteractive.Formak;
import kalkuloak.GameMain;

import java.util.List;

public class Monstroa extends GameObject {

    private int bizia = 10;
    private int atakea = 3;

    public Monstroa(Formak forma, Vector2 posizioa) {
        super(forma, posizioa);
    }

    public int getBizia() {
        return bizia;
    }

    public void setBizia(int bizia) {
        this.bizia = bizia;
    }

    public int getAtakea() {
        return atakea;
    }

    public void setAtakea(int atakea) {
        this.atakea = atakea;
    }

    /**
     * Metodo honek mugimenduDirezioa aldagaila erabilita montraa patroi ezberdinekin mugituko da.
     * @return GameObject[][] - Monstroaren posizio berria
     */
    @Override
    public GameObject[][] update() {
        return GameMain.getGameMain().getInteractables().getMatrix();
        //TODO: Monstroa mugitzea edo ez segun mugimenduDirezioa konfigurazioa, monstrok mina egitea, montroak bizi edukitzea
    }
}
