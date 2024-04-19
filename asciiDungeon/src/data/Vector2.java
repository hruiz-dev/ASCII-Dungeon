package data;

import data.exceptions.GameLogicException;
import render.GraficsConfig;
import render.Layers;

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
        if (x < GraficsConfig.X_GRID_SIZE){
            if (x >= 0) {
                this.x = x;
            } else {
                this.x = 0;
                throw new GameLogicException("Posizioa ezin da tablerotik atera. x="+ x + -1);
            }
        } else {
            this.x = GraficsConfig.X_GRID_SIZE - 1;
            throw new GameLogicException("Posizioa ezin da tablerotik atera. x=" + x + 1);
        }
    }

    /**
     * Metodo honek y posizioa aldatuko du.
     * @param y Posizio berria.
     * @throws GameLogicException Posizioa matrizetik kampo badago jautiko da
     */
    public void setY(int y) throws GameLogicException {
        if (y < GraficsConfig.Y_GRID_SIZE){
            if (y >= 0) {
                this.y = y;
            } else {
                this.y = 0;
                throw new GameLogicException("Posizioa ezin da tablerotik atera. y="+ y + -1);
            }
        } else {
            this.y = GraficsConfig.Y_GRID_SIZE - 1;
            throw new GameLogicException("Posizioa ezin da tablerotik atera. x=" + y + 1);
        }
    }
}
