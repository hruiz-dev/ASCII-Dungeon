package render;

import data.noInteractive.Estatikoa;
import data.noInteractive.Formak;
import data.Vector2;

/**
 * Klase hau gure bizia interfazean agertzeaz arduratzen da
 */
public class Bizia extends Ui{

    private int bizitza;

    public Bizia(Vector2 posizioa, Formak[][] datuak) {
        super(posizioa, datuak);
    }


    @Override
    public void updateUi() {
        //TODO bizitzaren balorea eguneratu eta pantailan erakutsi
    }

    @Override
    public Estatikoa[][] toGameObject() {
        //TODO bizia pantailan erakusteko Estatikoa[][] itzultzen du
        return new Estatikoa[0][];
    }
}
