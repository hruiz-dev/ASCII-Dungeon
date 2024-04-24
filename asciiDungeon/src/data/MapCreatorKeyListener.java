package data;

import data.exceptions.GameLogicException;
import data.interactive.Jokalaria;
import data.interactive.MapCreator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Klase honetan gure mapa sortzailearen tekelen kudeaketa egingo dugu.
 */
public class MapCreatorKeyListener implements KeyListener {
    MapCreator a;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

            a = MapCreator.getJokalaria();

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
        if (e.getKeyCode() == KeyEvent.VK_1) {
            a.setAzkenZapaldutakoTekla('1');
        }
        if (e.getKeyCode() == KeyEvent.VK_2) {
            a.setAzkenZapaldutakoTekla('2');
        }
        if (e.getKeyCode() == KeyEvent.VK_3) {
            a.setAzkenZapaldutakoTekla('3');
        }
        if (e.getKeyCode() == KeyEvent.VK_4) {
            a.setAzkenZapaldutakoTekla('4');
        }
        if (e.getKeyCode() == KeyEvent.VK_5) {
            a.setAzkenZapaldutakoTekla('5');
        }
        if (e.getKeyCode() == KeyEvent.VK_6) {
            a.setAzkenZapaldutakoTekla('6');
        }
        if (e.getKeyCode() == KeyEvent.VK_P) {
            a.setAzkenZapaldutakoTekla('+');
        }
        if (e.getKeyCode() == KeyEvent.VK_L) {
            a.setAzkenZapaldutakoTekla('-');
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
