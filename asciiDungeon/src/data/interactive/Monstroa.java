package data.interactive;

import data.GameMainData;
import data.GameObject;
import data.JokalariaData;
import data.Vector2;
import data.exceptions.GameLogicException;
import data.noInteractive.Formak;
import kalkuloak.GameMain;
import render.GraficsConfig;

import java.util.List;
import java.util.Random;

/**
 * Klase hau mogitzen diren mostruoak sortzeko erabiltzen da.
 */
public class Monstroa extends GameObject {

    private int bizia = 10;
    private int atakea = 3;

    public Monstroa(Formak forma, Vector2 posizioa) {
        super(forma, posizioa);
        GameMainData.getObjetuak().add(this);
    }

    public int getBizia() {
        return bizia;
    }

    public void setBizia(int bizia) {
        this.bizia = bizia;
    }

    public int getAtakea() {
        return atakea;
    }

    public void setAtakea(int atakea) {
        this.atakea = atakea;
    }

    /**
     * Metodo honek monstroa mugitzen du eta kasila pareta bada ez da mugituko, jokalaria badago mina egingo dio.
     * @param x X posizioa
     * @param y Y posizioa
     * @return GameObject[][] - Monstroaren posizio berria
     */
    public GameObject[][] mugitu(int x, int y) {

        if (x > GraficsConfig.GAME_X_GRID_SIZE || y > GraficsConfig.GAME_Y_GRID_SIZE) {
            return GameMainData.getInteractables().getMatrix();
        }
        GameObject[][] matrizea = GameMainData.getInteractables().getMatrix();
        // jokalariarekin edo paretarekin kolisioa detektatu

        if (kolisioa(x, y) || jokalariaJo(x, y)) {
            return matrizea;
        }
        try {
            // monstroa mugitu
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
        GameObject[][] matrizea = GameMainData.getMapa().getMatrix();
        return matrizea[getX() + x][getY() + y].getForma().getSymbol() == Formak.WALL.getSymbol();
    }

    /**
     * Funtzi honek objetu batekin talka egin dugun detektatzen du eta egin badugu jokalaria den detektatzen du hau bada mina egingo dio.
     * @param x x-ejean zenbat mugitu den
     * @param y y-ejean zenbat mugitu den
     * @return mina artu badu true itzultzen du
     */
    public Boolean jokalariaJo(int x, int y) {
        GameObject objetua = GameMainData.getInteractables().getMatrix()[getX() + x][getY() + y];
        if (objetua != null) {
            // Jotako objetua jokalaria den kombrobatu
            if (objetua instanceof Jokalaria) {
                Jokalaria a = (Jokalaria) objetua;
                // Joklariak defe badu bat kendu, bestela bizia kendu
                if (((Jokalaria) objetua).getArmadura().getDefentsa() > 0){
                    a.getArmadura().setDefentsa(a.getArmadura().getDefentsa() - 1);
                    return true;
                }
                a.setBizia(a.getBizia() - this.atakea);

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
            GameMainData.getKonsola().setMezua("Monstroa hil da");
            setPatailan(false);
            return GameMainData.getInteractables().getMatrix();
        }
       return mugitu(rand.nextInt(3) -1, rand.nextInt(3) -1);
    }
}
