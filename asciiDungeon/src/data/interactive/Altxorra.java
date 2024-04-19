package data.interactive;

import data.noInteractive.Formak;
import data.GameObject;
import data.Item;
import data.Vector2;

/**
 * Objetua honetan gure partdan zear eduki al ditugun altxorrak dira, hauek guk nahi dugu Item mota gorde alko dute.
 */
public class Altxorra extends GameObject {

    private Item objetua;

    public Altxorra(Formak forma, Vector2 posizioa, Item objetua) {
        super(forma, posizioa);
        this.objetua = objetua;
    }

    public Item getObjetua() {
        return objetua;
    }

    public void setObjetua(Item objetua) {
        this.objetua = objetua;
    }

    /**
     * Funtzi honek gure altxorra irrekitzean eta irakitakoan Item a jokalariari emateaz arduratuko da.
     * @return Matriza aktualizatuta.
     */
    @Override
    public GameObject[][] update() {
        return null;
        // TODO: altxorra irekitzea, degarsatzea eta objetua emateko funtzionalitatea implementatu
    }
}
