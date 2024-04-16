package data;

import java.util.Vector;

public abstract class GameObject {
    private Vector2 posizioa;
    private Formak forma;

    public int getX() {
        return posizioa.x;
    }

    public void setPosizioa(Vector2 posizioa) {

    }

    public int getY() {
        return posizioa.y;
    }

    public Formak getForma() {
        return forma;
    }

    abstract void update();
}
