package data.interactive;

import data.exceptions.GameLogicException;
import data.noInteractive.Estatikoa;
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
                atakeaEgin(pos.getX(), pos.getY(), 0, 1);
                break;
            case 'a':
                atakeaEgin(pos.getX(), pos.getY(), -1, 0);
                break;
            case 's':
                atakeaEgin(pos.getX(), pos.getY(), 0, -1);
                break;
            case 'd':
                atakeaEgin(pos.getX(), pos.getY(), 1, 0);
                break;
        }
    }

    /**
     * TODO : metodoak ondo funtzionatu beharra du
     * @param posX
     * @param posY
     * @param dirX
     * @param dirY
     */
    public void atakeaEgin( int posX, int posY, int dirX, int dirY) {
        GameObject[][] matriz = GameMain.getGameMain().getInteractables().getMatrix();
        int iStart = 0;
        int iEnd = 0;
        int jStart = 0;
        int jEnd = 0;

        if (dirX == 1) {
            iStart = posX + 1;
            iEnd = posX + 2;
            jStart = posY - 1;
            jEnd = posY + 1;
        } else if (dirX == -1) {
            iStart = posX - 2;
            iEnd = posX - 1;
            jStart = posY - 1;
            jEnd = posY + 1;
        } else if (dirY == -1) {
            iStart = posX - 1;
            iEnd = posX + 1;
            jStart = posY + 1;
            jEnd = posY + 2;
        } else if (dirY == 1){
            iStart = posX - 1;
            iEnd = posX + 1;
            jStart = posY - 2;
            jEnd = posY - 1;
        }

        // si el eje x=1 x = 1,2 ; se es x -1 x = -1,-2
        // eje j -1,1
        //si el eje j = 1 j = 1,2 ; se es j -1 j = -1,-2
        // eje i -1,1
        for (int i = iStart; i <= iEnd; i++) {
            for (int j = jStart; j <= jEnd; j++) {
                if (matriz[i][j] instanceof Monstroa) {
                    Monstroa monstroa = (Monstroa) matriz[i][j];
                    monstroa.setBizia(monstroa.getBizia() - atakea);
                }
            }
        }
    }
}
