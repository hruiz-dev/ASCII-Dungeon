package data.interactive;

import data.GameObject;
import data.Vector2;
import data.exceptions.GameLogicException;
import data.noInteractive.Formak;
import kalkuloak.GameMain;
import render.GraficsConfig;

import java.util.List;
import java.util.Random;

public class Monstroa extends GameObject {

    private int bizia = 10;
    private int atakea = 3;

    public Monstroa(Formak forma, Vector2 posizioa) {
        super(forma, posizioa);
        GameMain.getGameMain().getObjetuak().add(this);
    }

    public int getBizia() {
        return bizia;
    }

    public void setBizia(int bizia) {
        this.bizia = bizia;
        System.out.println("Monstroaren bizia: " + bizia);
    }

    public int getAtakea() {
        return atakea;
    }

    public void setAtakea(int atakea) {
        this.atakea = atakea;
    }

    public GameObject[][] mugitu(int x, int y) {
        if (x > GraficsConfig.GAME_X_GRID_SIZE || y > GraficsConfig.GAME_Y_GRID_SIZE) {
            return GameMain.getGameMain().getInteractables().getMatrix();
        }
        GameObject[][] matrizea = GameMain.getGameMain().getInteractables().getMatrix();

        if (kolisioa(x, y) || jokalariaJo(x, y)) {
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
     * Funtzio honek hurrengo mapako kasila pareta den kombrobatzen du eta hau pareta bada true itzuiltzen du
     * @param x X ejean zenbat mugitu den
     * @param y Y ejean zenbat mugitu den
     * @return kasila pareta bada true itzultzen du
     */
    public Boolean kolisioa(int x, int y) {
        GameObject[][] matrizea = GameMain.getGameMain().getMapa().getMatrix();
        return matrizea[getX() + x][getY() + y].getForma().getSymbol() == Formak.WALL.getSymbol();
    }

    /**
     * Funtzi honek objetu batekin talka egin dugun detektatzen du eta egin badugu jokalaria den detektatzen du hau bada mina egingo dio.
     * @param x x-ejean zenbat mugitu den
     * @param y y-ejean zenbat mugitu den
     * @return mina artu badu true itzultzen du
     */
    public Boolean jokalariaJo(int x, int y) {
        GameObject objetua = GameMain.getGameMain().getInteractables().getMatrix()[getX() + x][getY() + y];
        if (objetua != null) {
            if (objetua instanceof Jokalaria) {
                ((Jokalaria) objetua).setBizia(((Jokalaria) objetua).getBizia() - this.atakea);

            }
            return true;
        }
        return false;
    }

    /**
     * Metodo honek mugimenduDirezioa aldagaila erabilita montraa patroi ezberdinekin mugituko da.
     * @return GameObject[][] - Monstroaren posizio berria
     */
    @Override
    public GameObject[][] update() {
        Random rand = new Random();
        if (bizia < 0) {
            GameMain.getGameMain().getInteractables().getMatrix()[getX()][getY()] = null;
            return GameMain.getGameMain().getInteractables().getMatrix();
        }
       return mugitu(rand.nextInt(3) -1, rand.nextInt(3) -1);
    }
}
