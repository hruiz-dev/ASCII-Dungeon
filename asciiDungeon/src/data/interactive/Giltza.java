package data.interactive;

import data.GameMainData;
import data.GameObject;
import data.Vector2;
import data.noInteractive.Formak;
import kalkuloak.GameMain;

public class Giltza extends GameObject {

    public Giltza(Formak forma, Vector2 posizioa) {
        super(forma, posizioa);
    }

    /**
     * Funtzio honekin giltzaaren logika egunertzen du , jokalariak artu duen komprobatu eta orrela bada atea irekitzen du.
     * @return
     */
    @Override
    public GameObject[][] update() {
        return GameMainData.getInteractables().getMatrix();
    }
}
