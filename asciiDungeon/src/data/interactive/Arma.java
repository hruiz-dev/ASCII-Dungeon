package data.interactive;

import data.exceptions.GameLogicException;
import data.noInteractive.Formak;
import data.GameObject;
import data.Item;
import data.Vector2;
import kalkuloak.GameMain;

import java.util.ArrayList;
import java.util.List;

/**
 * Objetu hau jokalariak erabiltzen duen arma da eta lurrean botata edo jokalariak eskueta eduki alko du,
 * honekin montruei eraso egin ahal izango du.
 */
public class Arma extends Item {

    private  int atakea;

    public Arma(Formak forma, Vector2 posizioa, String izena, int erabilerak, int atakea) {
        super(forma, posizioa, izena, erabilerak);
        this.atakea = atakea;
    }

    public int getAtakea() {
        return atakea;
    }

    public void setAtakea(int atakea) {
        this.atakea = atakea;
    }

    /**
     * Lurrean baldin badago detektatuko du jokalaria bere gainetik pasatu den eta pasatu bada jokalariak jaso egingo du
     * @return
     */
    @Override
    public GameObject[][] update() {
        return GameMain.getGameMain().getInteractables().getMatrix();
    }

    public void atakatu() {
        GameObject[][] matrizea = GameMain.getGameMain().getInteractables().getMatrix();
        Jokalaria jokalaria = Jokalaria.getJokalaria();

        Vector2 pos = jokalaria.getPosizioa();

        switch (jokalaria.getAzkenMugimendua()) {
            case 'w':
                recorrerPosiciones(pos.getX(), pos.getY(), 0, 1);
                break;
            case 'a':
                recorrerPosiciones(pos.getX(), pos.getY(), -1, 0);
                break;
            case 's':
                recorrerPosiciones(pos.getX(), pos.getY(), 0, -1);
                break;
            case 'd':
                recorrerPosiciones(pos.getX(), pos.getY(), 1, 0);
                break;
        }
    }

    public void recorrerPosiciones( int posX, int posY, int dirX, int dirY) {
        GameObject[][] matriz = GameMain.getGameMain().getInteractables().getMatrix();
        for (int i = -1; i <= 1; i++) {

            if (dirX == 1 || dirX == -1) {
                if (matriz[posX + dirX][posY + i] instanceof Monstroa) {
                    Monstroa monstroa = (Monstroa) matriz[posX + dirX][posY + i];
                    monstroa.setBizia(monstroa.getBizia() - atakea);
                }
            } else if (dirY == 1 || dirY == -1) {
                if (matriz[posX + i][posY + dirY] instanceof Monstroa) {
                    Monstroa monstroa = (Monstroa) matriz[posX + i][posY + dirY];
                    monstroa.setBizia(monstroa.getBizia() - atakea);
                }
            }
        }
    }
}
