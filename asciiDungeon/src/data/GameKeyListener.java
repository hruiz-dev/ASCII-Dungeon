package data;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Klase honetan gure jokuko kontrolak edukiko ditugu.
 */
public class GameKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("W sakatuta");

        }

        if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("A sakatuta");
        }

        if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("S sakatuta");
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("D sakatuta");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
