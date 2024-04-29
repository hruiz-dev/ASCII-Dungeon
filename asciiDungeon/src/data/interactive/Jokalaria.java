package data.interactive;

import data.GameObject;
import data.Vector2;
import data.exceptions.GameLogicException;
import data.noInteractive.Estatikoa;
import data.noInteractive.Formak;
import kalkuloak.GameMain;
import render.GraficsConfig;

public class Jokalaria extends GameObject {

    private static Jokalaria jokalaria;
    private int bizia = 10;
    private Arma arma;
    private Armadura armadura;
    private int giltzak;
    private char azkenZapaldutakoTekla;

    private static GameMain gameMain = GameMain.getGameMain();

    private Jokalaria(Formak forma, Vector2 posizioa) {
        super(forma, posizioa);
    }

    /**
     * Funtzio honek jokalariaren instantzia aktuala bueltatzen du
     * @return Jokalaria instantzia
     * @throws GameLogicException Vector2 klaseak jaurtiko duen exzepzioac
     */
    public static Jokalaria getJokalaria() {
        if (jokalaria == null) {
            try {
                jokalaria = new Jokalaria(Formak.PLAYER, new Vector2(0, 0));
            } catch (GameLogicException e) {
                throw new RuntimeException(e);
            }
        }
        return jokalaria;
    }

    public int getBizia() {
        return bizia;
    }

    public void setBizia(int bizia) {
        this.bizia = bizia;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Armadura getArmadura() {
        return armadura;
    }

    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    public int getGiltzak() {
        return giltzak;
    }

    public void setGiltzak(int giltzak) {
        this.giltzak = giltzak;
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

        ateaIreki(x, y);

        giltzaArtu(x, y);

        minaArtu(x, y);
        if (kolisioa(x, y)) {
            return matrizea;
        }

        try {
            matrizea[getX()][getY()] = null;
            setPosizioa(new Vector2(getX() + x, getY() + y));
        } catch (GameLogicException e) {
            System.out.println("Matrizearen limetean zaude posizio honeatik ezin gara joan");
        }

        matrizea[this.getX()][this.getY()] = this;
        return matrizea;
    }

    /**
     * Funtzi honek hurrengo mapako kasila pareta den kombrobatzen du eta hau pareta bada true itzuiltzen du
     * @param x X ejean zenbat mugitu den
     * @param y Y ejean zenbat mugitu den
     * @return kasila pareta bada true itzultzen du
     */
    public Boolean kolisioa(int x, int y) {
        GameObject[][] matrizea = gameMain.getMapa().getMatrix();
        return matrizea[getX() + x][getY() + y].getForma().getSymbol() == Formak.WALL.getSymbol();
    }

    /**
     * Metodo honek jokalariak giltza bat artu duen detektatzen du
     * @param x x-ejean zenbat mugitu den
     * @param y y-ejean zenbat mugitu den
     */
    public void giltzaArtu(int x, int y) {
        GameObject objetua = gameMain.getInteractables().getMatrix()[getX()+ x][getY()+ y];
        if (objetua != null) {
            if (objetua.getForma().getSymbol() == Formak.KEY.getSymbol()) {
                setGiltzak(getGiltzak() + 1);
            }
        }
    }

    public void minaArtu(int x, int y) {
        GameObject objetua = gameMain.getInteractables().getMatrix()[getX() + x][getY() + y];
        if (objetua != null) {
            if (objetua instanceof Monstroa) {
                setBizia(getBizia() - ((Monstroa) objetua).getAtakea());
            }
        }}

    public void ateaIreki(int x, int y) {
        GameObject[][] matrizea = gameMain.getInteractables().getMatrix();
        GameObject[][] mapa = gameMain.getMapa().getMatrix();
        if (matrizea[getX() + x][getY() + y] != null) {
            if (matrizea[getX() + x][getY() + y].getForma().getSymbol() == Formak.DOOR.getSymbol()) {
                if (getGiltzak() > 0) {
                    setGiltzak(getGiltzak() - 1);
                    mapa[getX() + x][getY() + y] = new Estatikoa(Formak.FLOOR);
                }
            }
        }
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
