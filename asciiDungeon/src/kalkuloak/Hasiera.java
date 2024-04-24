package kalkuloak;

import data.GameKeyListener;
import data.MapCreatorKeyListener;
import render.GraficsConfig;
import render.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Hasiera {
    public static void main(String[] args) {
        new Menu();
    }

    /**
     * Metodo honek gure jokoaren hasieratzea burutzen du.
     */
    public static void startGame(){
        GameMain gameMain = GameMain.getGameMain();
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.add(gameMain.getMapa().getPanel(), JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(gameMain.getInteractables().getPanel(), JLayeredPane.PALETTE_LAYER);

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(layeredPane, BorderLayout.CENTER);
        frame.add(gameMain.getUi().getPanel(), BorderLayout.EAST);
        frame.addKeyListener(new GameKeyListener());
        frame.setSize(GraficsConfig.GAME_X_CANVAS_SIZE + GraficsConfig.UI_X_CANVAS_SIZE +32, GraficsConfig.GAME_Y_CANVAS_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        gameMain.init();
    }

    public static void startMapBuilder(){
        JFrame frame = new JFrame();
        MapCreatorMain a = MapCreatorMain.getMapCreatorData();

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.add(a.getMap().getPanel(), JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(a.getInteractables().getPanel(), JLayeredPane.PALETTE_LAYER);

        frame.add(layeredPane);
        frame.setSize(GraficsConfig.GAME_X_CANVAS_SIZE + 16, GraficsConfig.GAME_Y_CANVAS_SIZE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                a.stop();
            }
        });
        frame.addKeyListener(new MapCreatorKeyListener());
        frame.setVisible(true);
        a.init();
    }
}
