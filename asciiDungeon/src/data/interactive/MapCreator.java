package data.interactive;

import data.GameObject;
import data.Vector2;
import data.exceptions.GameLogicException;
import data.noInteractive.Estatikoa;
import data.noInteractive.Formak;
import kalkuloak.GameMain;
import render.GraficsConfig;

/**
 * Klase hau gure jokoko mapak sortzeko erabiliko dugu.
 */
public class MapCreator extends GameObject {

    private static MapCreator mapCreator;
    private char azkenZapaldutakoTekla;

    private GameMain gameMain = GameMain.getGameMain();

    private MapCreator(Formak forma, Vector2 posizioa) {
        super(forma, posizioa);
    }

    /**
     * Funtzio honek jokalariaren instantzia aktuala bueltatzen du
     * @return Jokalaria instantzia
     * @throws GameLogicException Vector2 klaseak jaurtiko duen exzepzioac
     */
    public static MapCreator getJokalaria() throws GameLogicException {
        if (mapCreator == null) {
            mapCreator = new MapCreator(Formak.PLAYER, new Vector2(1, 1));
        }
        return mapCreator;
    }


    public char getAzkenZapaldutakoTekla() {
        return azkenZapaldutakoTekla;
    }

    public void setAzkenZapaldutakoTekla(char azkenZapaldutakoTekla) {
        this.azkenZapaldutakoTekla = azkenZapaldutakoTekla;
    }

    /**
     * Funtzio honek zein direzioatan mugitu den jokalaria jasotzen du eta datu horrekin posizioa aldatzen dio.
     * @param x X ejean zenbat mugitu den
     * @param y Y ejean zenbat mugitu den
     * @return jokalariren posizioa aldatuta duen matrizea
     * @throws GameLogicException Posizioa matrizetik kampo badago jautiko da
     */
    public GameObject[][] mugitu(int x, int y) {
        if (x > GraficsConfig.GAME_X_GRID_SIZE || y > GraficsConfig.GAME_Y_GRID_SIZE) {
            return gameMain.getInteractables().getMatrix();
        }
        GameObject[][] matrizea = gameMain.getInteractables().getMatrix();

        try {
            matrizea[getX()][getY()] = new Estatikoa(Formak.FLOOR);
            setPosizioa(new Vector2(getX() + x, getY() + y));
        } catch (GameLogicException e) {
            System.out.println("Matrizearen limetean zaude posizio honeatik ezin gara juan");
        }

        matrizea[this.getX()][this.getY()] = this;
        return matrizea;
    }

    @Override
    public GameObject[][] update() {
        GameObject[][] matrizea = gameMain.getInteractables().getMatrix();

        if (azkenZapaldutakoTekla == 'w') {
            matrizea = mugitu(0, -1);
        } else if (azkenZapaldutakoTekla == 'a') {
            matrizea = mugitu(-1, 0);
        } else if (azkenZapaldutakoTekla == 's') {
            matrizea = mugitu(0, 1);
        } else if (azkenZapaldutakoTekla == 'd') {
            matrizea = mugitu(1, 0);
        }
        azkenZapaldutakoTekla = ' ';
        return matrizea;
        //TODO: Jokalariaren mogimendua eta kolisioak kudeatu
    }
}
