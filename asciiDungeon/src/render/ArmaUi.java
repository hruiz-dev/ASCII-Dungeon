package render;

import data.Arma;
import data.Estatikoa;
import data.Formak;
import data.Vector2;

public class ArmaUi extends Ui{

    private Arma[] armak = new Arma[2];

    public ArmaUi(Vector2 posizioa, Formak[][] datuak) {
        super(posizioa, datuak);
    }


    @Override
    public void updateUi() {
        //TODO armakaren balorea eguneratu eta pantailan erakutsi
    }

    @Override
    public Estatikoa[][] toGameObject() {
        //TODO arma pantailan erakusteko Estatikoa[][] itzultzen du
        return new Estatikoa[0][];
    }
}
