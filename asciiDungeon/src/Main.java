import data.GameKeyListener;
import kalkuloak.GameMain;
import render.GraficsConfig;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
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
}
