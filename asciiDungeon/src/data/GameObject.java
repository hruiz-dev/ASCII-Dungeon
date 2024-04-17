package data;

import data.exceptions.GameLogicException;

public abstract class GameObject {
    private Vector2 posizioa;
    private Formak forma;

    protected GameObject(Formak forma, Vector2 posizioa) {
        this.forma = forma;
        this.posizioa = posizioa;
    }

    public int getX() {
        return posizioa.getX();
    }

    public void setPosizioa(int x, int y) throws GameLogicException {
        this.posizioa = new Vector2(x, y);
    }

    public void setPosizioa(Vector2 posizioa) {
        this.posizioa = posizioa;
    }

    public int getY() {
        return posizioa.getY();
    }

    public Formak getForma() {
        return forma;
    }

    /**
     * Metodo honek gure GameObjetaren funtzionalitatea ejekutatuko du.
     */
    abstract void update();
}
