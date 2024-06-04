package render.komponeteak;

import data.GameObject;
import data.interactive.Jokalaria;
import data.noInteractive.Estatikoa;
import data.noInteractive.Formak;
import render.Layers;
import render.Ui;

/**
 * Klase hau gure bizia interfazean agertzeaz arduratzen da
 */
public class Bizia extends Ui {

    private static Bizia bizia;
    private Layers biziaLayer = new Layers(1, 5, 1, 80, 16);

    public Bizia( GameObject[][] datuak) {
        super(datuak);
        if (datuak == null) {
            this.setDatuak(new GameObject[5][1]);
        }

    }

    public Layers getBiziaLayer() {
        return biziaLayer;
    }

    /**
     * Sortutako Bizia objetu bat bueltatzen dizu
     * @return Bizia objetua
     */
    public static Bizia getBizia() {
        if (bizia == null) {
            bizia = new Bizia( null);
        }
        return bizia;
    }

    /**
     * Metodo honek joklariaren bizia artzen du eta hau bihotzen irudietara psatzen du layers klase batean
     */
    @Override
    public void updateUi() {
        float x = (float) Jokalaria.getJokalaria().getBizia() /4;
        int i = 0;
        // Bizi hutsaren irudiak pintatu
        for (int j = 0; j < 5; j++) {
            this.getDatuak()[j][0] = null;
        }
        // biziaren arabera bihotzak pintatu
        while (x > 0){

            float num = (x -1 > 0) ? 1 : x;

            if (num <= 0.25) {
                this.getDatuak()[i][0] = new Estatikoa(Formak.HEART1);
            } else if (num <= 0.5) {
                this.getDatuak()[i][0] = new Estatikoa(Formak.HEART2);
            } else if (num <= 0.75) {
                this.getDatuak()[i][0] = new Estatikoa(Formak.HEART3);
            } else {
                this.getDatuak()[i][0] = new Estatikoa(Formak.HEART4);
            }
            i++;
            x--;
        }
        biziaLayer.updateMatrix(this.getDatuak());
    }
}
