package data.interactive;

import data.noInteractive.Formak;
import data.GameObject;
import data.Vector2;

public class ArmaDistantzia extends Arma {

    private int munizioa;
    public ArmaDistantzia(Formak forma, Vector2 posizioa, String izena, int erabilerak, int atakea, int munizioa) {
        super(forma, posizioa, izena, erabilerak, atakea);
        this.munizioa = munizioa;
    }

    public int getMunizioa() {
        return munizioa;
    }

    public void setMunizioa(int munizioa) {
        this.munizioa = munizioa;
    }

    /**
     * Ez dakit nola antolatu oraindik
     * @return
     */
    @Override
    public GameObject[][] update() {
        return null;
        //TODO: metodo honek armak munizioa badu bala bat disparatu du n direzioan
    }
}
