package data;

import data.exceptions.GameLogicException;
import render.Graficos;

public class Jokalaria extends GameObject{

    private int bizia = 10;
    private Arma arma;
    private Armadura armadura;

    private int giltzak;

    private char azkenZapaldutakoTekla;

    public Jokalaria(Formak forma, Vector2 posizioa) {
        super(forma, posizioa);
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

    /**
     * Funtzio honek zein direzioatan mugitu den jokalaria jasotzen du eta datu horrekin posizioa aldatzen dio.
     * @param x X ejean zenbat mugitu den
     * @param y Y ejean zenbat mugitu den
     * @return jokalariren posizioa aldatuta duen matrizea
     * @throws GameLogicException Posizioa matrizetik kampo badago jautiko da
     */
    public GameObject[][] mugitu(int x, int y) throws GameLogicException {
        GameObject[][] matrizea = Graficos.getMatrix();
        matrizea[getX()][getY()] = new Estatikoa(Formak.FLOOR, new Vector2(getX(), getY()));
        setPosizioa(getX() + x, getY() + y);
        matrizea[getX()][getY()] = this;
        return matrizea;
    }

    @Override
    public GameObject[][] update() {
        GameObject[][] matrizea = Graficos.getMatrix();
       try {
           if (azkenZapaldutakoTekla == 'w') {
                matrizea = mugitu(0, -1);
           } else if (azkenZapaldutakoTekla == 'a') {
               matrizea = mugitu(-1, 0);
           } else if (azkenZapaldutakoTekla == 's') {
               matrizea = mugitu(0, 1);
           } else if (azkenZapaldutakoTekla == 'd') {
               matrizea = mugitu(1, 0);
           }
       } catch (GameLogicException e) {
           throw new RuntimeException(e);
       }
       return matrizea;

        //TODO: Jokalariaren mogimendua eta kolisioak kudeatu
    }
}
