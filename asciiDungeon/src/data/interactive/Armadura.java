package data.interactive;

import data.noInteractive.Formak;
import data.GameObject;
import data.Item;
import data.Vector2;

/**
 * Objetu honek armadura bat da, defentsa gehiago ematen duena jokalariari
 */
public class Armadura extends Item {

    private int defentsa;

    public Armadura(Formak forma, String izena, int erabilerak, int defentsa) {
        super(forma, izena, erabilerak);
        this.defentsa = defentsa;
    }

    public int getDefentsa() {
        return defentsa;
    }

    public void setDefentsa(int defentsa) {
        this.defentsa = defentsa;
    }

    @Override
    public GameObject[][] update() {
        return null;
    }


}
