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

    public Armadura(Formak forma, Vector2 posizioa, String izena, int erabilerak, int defentsa) {
        super(forma, posizioa, izena, erabilerak);
        this.defentsa = defentsa;
    }

    public int getDefentsa() {
        return defentsa;
    }

    public void setDefentsa(int defentsa) {
        this.defentsa = defentsa;
    }

    /**
     * Lurrean dagoen bitartean jokalariak armadura artu algo du, gero jokalaria jotzen duten bakoitzean mina gutxitzen du
     * @return
     */
    @Override
    public GameObject[][] update() {
        return null;
    }
}
