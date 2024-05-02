package kalkuloak;

import data.MapCreatorKeyListener;
import render.GraficsConfig;
import render.panelak.Menu;

import javax.swing.*;

public class Hasiera {

    public static void main(String[] args) {
        new Menu();
    }

    /**
     * Metodo honek gure jokoaren hasieratzea burutzen du.
     */
    public static void startGame(){
        GameMain.getGameMain().init();
    }

    /**
     * Metodo honek gure maparen editorea hasieratzen du.
     */
    public static void startMapBuilder(){
        JFrame frame = new JFrame();
        MapCreatorMain a = MapCreatorMain.getMapCreatorData();
        frame.add(a.getMapCreatorData().getMap().getPanel());
        frame.setSize(GraficsConfig.GAME_X_CANVAS_SIZE + 16, GraficsConfig.GAME_Y_CANVAS_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(new MapCreatorKeyListener());
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                a.stop();
            }
        });
        frame.setVisible(true);
        new Thread(a::init).start();

    }
}
