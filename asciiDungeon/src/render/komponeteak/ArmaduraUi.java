package render.komponeteak;

import data.GameObject;
import data.interactive.Armadura;
import data.interactive.Jokalaria;
import data.noInteractive.Estatikoa;
import data.noInteractive.Formak;
import render.Layers;
import render.Ui;

/**
 * Klase hau armadura dugunena hau interfazean agertzeaz arduratzen da.
 */
public class ArmaduraUi extends Ui {

    private static ArmaduraUi armaduraUi;

    private Layers armaduraLayer = new Layers(1, 5, 1, 80, 16);

    public ArmaduraUi(GameObject[][] datuak) {
        super(datuak);
    }

    /**
     * sortutako ArmaduraUi objetu bat bueltatzen dizu
     * @return ArmaduraUi objetua
     */
    public static ArmaduraUi getArmaduraUi() {
        if (armaduraUi == null) {
            armaduraUi = new ArmaduraUi(new GameObject[5][1 ]);
        }
        return armaduraUi;
    }


    public Layers getArmaduraLayer() {
        return armaduraLayer;
    }

    /**
     * Interfazean zenbait armadura agertu behar diren klakulatzen du eta hori interfazera pasatu.
     */
    @Override
    public void updateUi() {
        Armadura armadura = Jokalaria.getJokalaria().getArmadura();
        if (armadura == null) {
            return;
        }

        // Eskudo hutsaren irudiak pintatu
        for (int j = 0; j < 5; j++) {
            this.getDatuak()[j][0] = new Estatikoa(Formak.SHIELD3);
        }

        float eskudoa = (float) armadura.getDefentsa() /2;
        int i = 0;
        // Eskudo osorik eta hutsaren irudiak pintatu
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
        // Eskudo hutsaren irudiak aktualizatu interfazean
        armaduraLayer.updateMatrix(this.getDatuak());

    }
}
