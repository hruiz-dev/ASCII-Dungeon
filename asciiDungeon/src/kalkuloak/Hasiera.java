package kalkuloak;

import data.GameKeyListener;
import data.MapCreatorData;
import render.GraficsConfig;
import render.Layers;
import render.Menu;

import javax.swing.*;
import java.awt.*;

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

        frame.add(MapCreatorData.getMapCreatorData().getMap().getPanel());
        frame.setSize(GraficsConfig.GAME_X_CANVAS_SIZE + 16, GraficsConfig.GAME_Y_CANVAS_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
