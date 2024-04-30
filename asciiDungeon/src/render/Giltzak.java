package render;

import data.GameObject;
import data.noInteractive.Estatikoa;
import data.noInteractive.Formak;
import data.Vector2;

/**
 * Klase hau gure giltza katitatea erakusteaz arduratzen da.
 */
public class Giltzak extends Ui{

    private int giltzak;

    public Giltzak(GameObject[][] datuak) {
        super(datuak);
    }

    @Override
    public void updateUi() {
        //TODO giltzaren balorea eguneratu eta pantailan erakutsi
    }

}
