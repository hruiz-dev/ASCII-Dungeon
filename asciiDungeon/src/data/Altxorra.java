package data;

public class Altxorra extends GameObject{

    private Item objetua;

    public Altxorra(Formak forma, Vector2 posizioa, Item objetua) {
        super(forma, posizioa);
        this.objetua = objetua;
    }

    public Item getObjetua() {
        return objetua;
    }

    public void setObjetua(Item objetua) {
        this.objetua = objetua;
    }

    @Override
    void update() {
        // TODO: altxorra irekitzea, degarsatzea eta objetua emateko funtzionalitatea implementatu
    }
}
