package data;

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

    @Override
    public GameObject[][] update() {
        return null;
        // TODO: Cuando ataque que haga daño
    }
}
