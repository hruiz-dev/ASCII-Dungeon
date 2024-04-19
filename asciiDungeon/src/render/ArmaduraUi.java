package render;

import data.interactive.Armadura;
import data.noInteractive.Estatikoa;
import data.noInteractive.Formak;
import data.Vector2;

/**
 * Klase au armadura badugu hau interfazean agertzeaz arduratzen da.
 */
public class ArmaduraUi extends Ui {

    private Armadura armadura;
    public ArmaduraUi(Vector2 posizioa, Formak[][] datuak, Armadura armadura) {
        super(posizioa, datuak);
        this.armadura = armadura;
    }

    @Override
    public void updateUi() {
        //TODO metodo honek gure armaduraren irudia eguneratuko du
    }

    @Override
    public Estatikoa[][] toGameObject() {
        //TODO metodo honek gure armaduraren datuak itzuliko ditu
        return new Estatikoa[0][];
    }
}
