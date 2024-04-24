package data.interactive;

import data.GameObject;
import data.Vector2;
import data.exceptions.GameLogicException;
import data.noInteractive.Estatikoa;
import data.noInteractive.Formak;
import kalkuloak.GameMain;
import kalkuloak.MapCreatorMain;
import render.GraficsConfig;

/**
 * Klase hau gure jokoko mapak sortzeko erabiliko dugu.
 */
public class MapCreator extends GameObject {

    private static MapCreator mapCreator;
    private char azkenZapaldutakoTekla;

    private GameObject objetua = new Estatikoa(Formak.FLOOR);
    private Boolean intereactive = false;
    private static MapCreatorMain gameMain = MapCreatorMain.getMapCreatorData();

    private MapCreator(Formak forma, Vector2 posizioa) {
        super(forma, posizioa);
    }

    public Boolean getIntereactive() {
        return intereactive;
    }

    /**
     * Funtzio honek jokalariaren instantzia aktuala bueltatzen du
     * @return Jokalaria instantzia
     * @throws GameLogicException Vector2 klaseak jaurtiko duen exzepzioac
     */
    public static MapCreator getJokalaria() {
        if (mapCreator == null) {
            try {
                mapCreator = new MapCreator(Formak.PLAYER, new Vector2(1, 1));
            } catch (GameLogicException e) {
                throw new RuntimeException(e);
            }
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
            return gameMain.getMap().getMatrix();
        }
        if (intereactive) {
            return updateInteractive(x, y);
        }
        return updateBackground(x, y);
    }

    public GameObject[][] updateBackground(int x, int y){
        GameObject[][] matrizea = gameMain.getMap().getMatrix();
        try {
            matrizea[getX()][getY()] = objetua;
            setPosizioa(new Vector2(getX() + x, getY() + y));
        } catch (GameLogicException e) {
            System.out.println("Matrizearen limetean zaude posizio honeatik ezin gara joan");
        }

        matrizea[this.getX()][this.getY()] = this;
        return matrizea;
    }

    public GameObject[][] updateInteractive(int x, int y){
        GameObject[][] matrizea = gameMain.getMap().getMatrix();

        try {
            matrizea[getX()][getY()] = objetua;
            setPosizioa(new Vector2(getX() + x, getY() + y));
        } catch (GameLogicException e) {
            System.out.println("Matrizearen limetean zaude posizio honeatik ezin gara joan");
        }
        matrizea[this.getX()][this.getY()] = this;
        return matrizea;
    }

    /**
     * Funtzi honek mapCretor objetuaren posizioa aldatzen duen funtzioa da.
     * @return posizioa aldatuta duen objetua
     */
    @Override
    public GameObject[][] update() {
        GameObject[][] matrizea = gameMain.getMap().getMatrix();

        if (azkenZapaldutakoTekla == 'w') {
            matrizea = mugitu(0, -1);
        } else if (azkenZapaldutakoTekla == 'a') {
            matrizea = mugitu(-1, 0);
        } else if (azkenZapaldutakoTekla == 's') {
            matrizea = mugitu(0, 1);
        } else if (azkenZapaldutakoTekla == 'd') {
            matrizea = mugitu(1, 0);
        } else if (azkenZapaldutakoTekla == '1') {
            objetua = new Estatikoa(Formak.WALL);
            intereactive = false;
        } else if (azkenZapaldutakoTekla == '2') {
            objetua = new Estatikoa(Formak.FLOOR);
            intereactive = false;
        } else if (azkenZapaldutakoTekla == '3') {
            objetua = new Estatikoa(Formak.ENEMY);
            intereactive = true;
        } else if (azkenZapaldutakoTekla == '5') {
            objetua = new Estatikoa(Formak.DOOR);
            intereactive = true;
        } else if (azkenZapaldutakoTekla == '6'){
            objetua = new Estatikoa(Formak.KEY);
            intereactive = true;
        } else if (azkenZapaldutakoTekla == '+'){
            objetua = null;
            intereactive = true;
        } else if (azkenZapaldutakoTekla == '-') {
            objetua = null;
            intereactive = false;
        }
        azkenZapaldutakoTekla = ' ';
        return matrizea;
    }

}
