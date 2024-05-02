package data.interactive;

import data.*;
import data.noInteractive.Formak;

import java.util.Random;

/**
 * Objetua honetan gure partdan zear eduki al ditugun altxorrak dira, hauek guk nahi dugu Item mota gorde alko dute.
 */
public class Altxorra extends GameObject {

    private Item objetua;

    public Altxorra(Formak forma, Vector2 posizioa, Item objetua) {
        super(forma, posizioa);
        this.objetua = objetua;
    }

    public Altxorra(Formak forma, Vector2 posizioa) {
        super(forma, posizioa);
    }

    public Item getObjetua() {
        return objetua;
    }

    public void setObjetua(Item objetua) {
        this.objetua = objetua;
    }

    public void sortuObjetua(){

    }

    /**
     * Funtzi honek gure altxorra irrekitzean eta irakitakoan Item a jokalariari emateaz arduratuko da.
     * @return Matriza aktualizatuta.
     */
    @Override
    public GameObject[][] update() {
        if (objetua == null) {
            Random rand = new Random();
            int a = rand.nextInt(100);
            JokalariaData.addDirua(a);
            GameMainData.getKonsola().setMezua("Altxorrean " + a + " txanpon aurkitu dituzu!");
        }
        return null;
        //TODO: Maybe implementatu metodoa arma edo armadura ekipatzeko aukerarekin

    }
}
