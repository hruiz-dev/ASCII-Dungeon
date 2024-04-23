package data.interactive;

import data.GameObject;
import data.Vector2;
import data.noInteractive.Formak;

public class Monstroa extends GameObject {

    private int bizia;
    private int atakea;
    private int mugimenduDirezioa;

    public Monstroa(Formak forma, Vector2 posizioa, int bizia, int atakea, int mugimenduDirezioa) {
        super(forma, posizioa);
        this.bizia = bizia;
        this.atakea = atakea;
        this.mugimenduDirezioa = mugimenduDirezioa;
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

    public int getMugimenduDirezioa() {
        return mugimenduDirezioa;
    }

    public void setMugimenduDirezioa(int mugimenduDirezioa) {
        this.mugimenduDirezioa = mugimenduDirezioa;
    }

    /**
     * Metodo honek mugimenduDirezioa aldagaila erabilita montraa patroi ezberdinekin mugituko da.
     * @return GameObject[][] - Monstroaren posizio berria
     */
    @Override
    public GameObject[][] update() {
        return null;
        //TODO: Monstroa mugitzea edo ez segun mugimenduDirezioa konfigurazioa, monstrok mina egitea, montroak bizi edukitzea
    }
}