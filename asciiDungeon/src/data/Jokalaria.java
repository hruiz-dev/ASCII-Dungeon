package data;

public class Jokalaria extends GameObject{

    private int bizia = 10;
    private Arma arma;
    private Armadura armadura;

    private int giltzak;

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

    @Override
    void update() {
        //TODO: Jokalariaren mogimendua eta kolisioak kudeatu
    }
}
