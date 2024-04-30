package render;

import data.GameObject;
import data.interactive.Arma;
import data.noInteractive.Estatikoa;
import data.noInteractive.Formak;
import data.Vector2;

/**
 * Klase hau arma badugu hau interfazean agertzeaz arduratzen da
 */
public class ArmaUi extends Ui{

    private Arma[] armak = new Arma[2];

    public ArmaUi(GameObject[][] datuak) {
        super( datuak);
    }


    @Override
    public void updateUi() {
        //TODO armakaren balorea eguneratu eta pantailan erakutsi
    }

}
