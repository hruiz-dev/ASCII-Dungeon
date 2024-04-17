package render;

import data.Estatikoa;
import data.Formak;
import data.Vector2;

public class Giltzak extends Ui{

    private int giltzak;

    public Giltzak(Vector2 posizioa, Formak[][] datuak) {
        super(posizioa, datuak);
    }

    @Override
    public void updateUi() {
        //TODO giltzaren balorea eguneratu eta pantailan erakutsi
    }

    @Override
    public Estatikoa[][] toGameObject() {
        //TODO giltza pantailan erakusteko Estatikoa[][] itzultzen du
        return new Estatikoa[0][];
    }
}
