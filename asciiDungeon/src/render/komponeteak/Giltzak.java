package render.komponeteak;

import data.GameMainData;
import data.GameObject;
import data.JokalariaData;
import data.noInteractive.Estatikoa;
import data.noInteractive.Formak;
import render.Layers;
import render.Ui;

/**
 * Klase hau gure giltza katitatea ui-an erakusteaz arduratzen da.
 */
public class Giltzak extends Ui {

    private static Giltzak giltzak;

    private Layers giltza = new Layers(1, 5, 1, 80,16);

    public Giltzak(GameObject[][] datuak) {
        super(datuak);
        this.setDatuak(new GameObject[5][1]);
        GameMainData.getUiKomponenteak().add(this);
    }

    public Layers getGiltza() {
        return giltza;
    }

    /**
     * Sortutako giltza objetua itzultzen du.
     * @return Giltza objetua.
     */
    public static Giltzak getGiltzak() {
        if (giltzak == null) {
            giltzak = new Giltzak(null);
        }
        return giltzak;
    }

    /**
     * Metodo honek jokalariak duen giltza bakoitzeko giltza bat erakuste ndu interfazean (5 giltza maximo)
     */
    @Override
    public void updateUi() {
        int giltzak = JokalariaData.getGiltzak();

        for (int j = 0; j < 5; j++) {
            this.getDatuak()[j][0] = null;
        }

        int iMax = (giltzak > 5) ? 5 : giltzak;

        for (int i = 0; i < iMax; i++) {
            this.getDatuak()[i][0] = new Estatikoa(Formak.KEY);
        }

        giltza.updateMatrix(this.getDatuak());

    }

}
