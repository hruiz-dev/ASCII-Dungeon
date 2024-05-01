package render;

import data.GameObject;
import data.interactive.Arma;
import data.interactive.Jokalaria;
import data.noInteractive.Estatikoa;
import data.noInteractive.Formak;
import data.Vector2;

/**
 * Klase hau arma badugu hau interfazean agertzeaz arduratzen da
 */
public class ArmaUi extends Ui{

    private Layers armaLayer = new Layers(1, 1, 1, 16, 16);

    public ArmaUi(GameObject[][] datuak) {
        super( datuak);
    }


    @Override
    public void updateUi() {
        Arma arma = Jokalaria.getJokalaria().getArma();
        GameObject[][] armak = new GameObject[1][1];
        armak[0][0] = arma;
        armaLayer.updateMatrix(armak);

    }

}
