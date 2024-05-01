package render;

import data.GameMainData;
import data.GameObject;
import data.interactive.Jokalaria;
import data.noInteractive.Estatikoa;
import data.noInteractive.Formak;
import data.Vector2;
import kalkuloak.GameMain;

/**
 * Klase hau gure bizia interfazean agertzeaz arduratzen da
 */
public class Bizia extends Ui{

    private static Bizia bizia;
    private Layers biziaLayer = new Layers(1, 10, 1, 160, 16);

    public Bizia( GameObject[][] datuak) {
        super(datuak);
        if (datuak == null) {
            this.setDatuak(new GameObject[10][1]);
        }
        GameMainData.getUiKomponenteak().add(this);
    }

    public Layers getBiziaLayer() {
        return biziaLayer;
    }

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
        for (int j = 0; j < 10; j++) {
            this.getDatuak()[j][0] = null;
        }
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
