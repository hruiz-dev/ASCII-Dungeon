package render;

import data.GameObject;
import data.interactive.Armadura;
import data.interactive.Jokalaria;
import data.noInteractive.Estatikoa;
import data.noInteractive.Formak;
import data.Vector2;

/**
 * Klase au armadura badugu hau interfazean agertzeaz arduratzen da.
 */
public class ArmaduraUi extends Ui {

    private static ArmaduraUi armaduraUi;

    private Layers armaduraLayer = new Layers(1, 5, 1, 80, 16);

    public ArmaduraUi(GameObject[][] datuak) {
        super(datuak);
    }

    public static ArmaduraUi getArmaduraUi() {
        if (armaduraUi == null) {
            armaduraUi = new ArmaduraUi(new GameObject[5][1 ]);
        }
        return armaduraUi;
    }

    public Layers getArmaduraLayer() {
        return armaduraLayer;
    }

    @Override
    public void updateUi() {
        Armadura armadura = Jokalaria.getJokalaria().getArmadura();
        if (armadura == null) {
            return;
        }

        for (int j = 0; j < 5; j++) {
            this.getDatuak()[j][0] = new Estatikoa(Formak.SHIELD3);
        }

        float eskudoa = (float) armadura.getDefentsa() /2;
        int i = 0;
        while (eskudoa > 0){
            float num = (eskudoa -1 > 0) ? 1 : eskudoa;
            if (num <= 0.5) {
                this.getDatuak()[i][0] = new Estatikoa(Formak.SHIELD1);
            } else {
                this.getDatuak()[i][0] = new Estatikoa(Formak.SHIELD2);
            }
            eskudoa -= 1;
            i++;
        }

        armaduraLayer.updateMatrix(this.getDatuak());

    }
}
