package data;

public class Armadura extends Item{

    private int defentsa;

    public Armadura(Formak forma, Vector2 posizioa, String izena, int erabilerak, int defentsa) {
        super(forma, posizioa, izena, erabilerak);
        this.defentsa = defentsa;
    }

    public int getDefentsa() {
        return defentsa;
    }

    public void setDefentsa(int defentsa) {
        this.defentsa = defentsa;
    }

    @Override
    void update() {

    }
}
