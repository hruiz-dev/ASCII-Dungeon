package data.interactive;

import data.GameMainData;
import data.GameObject;
import data.noInteractive.Formak;
import kalkuloak.GameMain;

public class Portal extends GameObject {
    public Portal(Formak forma) {
        super(forma);
    }

    /**
     * Poratalaren update metodo ejekutatzean, mapaz aldatuko dugu
     * @return null
     */
    @Override
    public GameObject[][] update() {
        GameMainData.setMomentukoMapa(GameMainData.getMomentukoMapa()+1);
        if (GameMainData.getMomentukoMapa() < GameMainData.getMapaTotalak()) {
            GameMain.getGameMain().changeMap();
        } else {
            GameMain.getGameMain().winGame();
        }

        return null;
    }
}
