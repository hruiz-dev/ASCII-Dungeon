package data.interactive;

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
        return null;
        // TODO: Cuando ataque que haga daño
    }
}
