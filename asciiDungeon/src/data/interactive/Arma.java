package data.interactive;

import data.GameMainData;
import data.noInteractive.Formak;
import data.GameObject;
import data.Item;
import data.Vector2;

/**
 * Objetu hau jokalariak erabiltzen duen arma da eta lurrean botata edo jokalariak eskueta eduki alko du,
 * honekin montruei eraso egin ahal izango du.
 */
public class Arma extends Item {

    private  int atakea;

    public Arma(Formak forma, String izena, int erabilerak, int atakea) {
        super(forma, izena, erabilerak);
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
        return GameMainData.getInteractables().getMatrix();
    }

    public void atakatu() {
        GameObject[][] matrizea = GameMainData.getInteractables().getMatrix();
        Jokalaria jokalaria = Jokalaria.getJokalaria();

        Vector2 pos = jokalaria.getPosizioa();

        // Jokalariaren azken mugiamenduaren arabera nora begiratzen dagoen kalkulatu
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
     * Atakatzean azkeneko mogimenduaren informazioa erabilita, 2x3 matrizean atakea egingo du
     * @param posX posizioa x
     * @param posY posizioa y
     * @param dirX posizioa x norabidea
     * @param dirY posizioa y norabidea
     */
    public void atakeaEgin( int posX, int posY, int dirX, int dirY) {
        GameObject[][] matriz = GameMainData.getInteractables().getMatrix();
        int iStart = 0;
        int iEnd = 0;
        int jStart = 0;
        int jEnd = 0;

        // direzioaren arabera atakearen rangoa kalkulatu
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

        // Matrizean atakea egin
        for (int i = iStart; i <= iEnd; i++) {
            for (int j = jStart; j <= jEnd; j++) {
                if (matriz[i][j] instanceof Monstroa) {
                    Monstroa monstroa = (Monstroa) matriz[i][j];
                    monstroa.setBizia(monstroa.getBizia() - atakea);
                    GameMainData.getKonsola().setMezua("Monstroa atakatu duzu, bizi kendu diozu -" + atakea);
                    return;
                }
            }
            GameMainData.getKonsola().setMezua("Ez duzu inor jo atakearekin");
        }
    }
}
