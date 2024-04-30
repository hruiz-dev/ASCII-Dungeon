package render;

import data.GameObject;
import data.interactive.Armadura;
import data.noInteractive.Estatikoa;
import data.noInteractive.Formak;
import data.Vector2;

/**
 * Klase au armadura badugu hau interfazean agertzeaz arduratzen da.
 */
public class ArmaduraUi extends Ui {

    private Armadura armadura;
    public ArmaduraUi(GameObject[][] datuak, Armadura armadura) {
        super(datuak);
        this.armadura = armadura;
    }

    @Override
    public void updateUi() {
        //TODO metodo honek gure armaduraren irudia eguneratuko du
    }
}
