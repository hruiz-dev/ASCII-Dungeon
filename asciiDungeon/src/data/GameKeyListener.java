package data;

import data.interactive.Jokalaria;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Klase honetan gure jokoko kontrolak edukiko ditugu.
 */
public class GameKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Jokalaria a = Jokalaria.getJokalaria();


        if (e.getKeyCode() == KeyEvent.VK_W) {
            a.setAzkenZapaldutakoTekla('w');

        }

        if (e.getKeyCode() == KeyEvent.VK_A) {
            a.setAzkenZapaldutakoTekla('a');
        }

        if (e.getKeyCode() == KeyEvent.VK_S) {
            a.setAzkenZapaldutakoTekla('s');
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            a.setAzkenZapaldutakoTekla('d');
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            a.getArma().atakatu();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
