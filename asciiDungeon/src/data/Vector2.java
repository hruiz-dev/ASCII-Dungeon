package data;

import data.exceptions.GameLogicException;
import render.Graficos;

/**
 * Klase simple bat x eta y posizioak gordetzeko.
 */
public class Vector2 {
    private int x;
    private int y;

    public Vector2(int x, int y) throws GameLogicException {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Metodo honek x posizioa aldatuko du.
     * @param x Posizio berria.
     * @throws GameLogicException Posizioa matrizetik kampo badago jautiko da
     */
    public void setX(int x) throws GameLogicException {
        if (x < Graficos.X_GRID_SIZE) {
            this.x = x;
        } else {
            throw new GameLogicException("Posizioa ezin da tablerotik atera. x=" + x );
        }
    }

    /**
     * Metodo honek y posizioa aldatuko du.
     * @param y Posizio berria.
     * @throws GameLogicException Posizioa matrizetik kampo badago jautiko da
     */
    public void setY(int y) throws GameLogicException {
        if (y < Graficos.Y_GRID_SIZE) {
            this.y = y;
        } else {
            throw new GameLogicException("Posizioa ezin da tablerotik atera. y=" + y );
        }
    }
}
