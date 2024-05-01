package kalkuloak;

import data.GameKeyListener;
import render.Bizia;
import render.GraficsConfig;

import javax.swing.*;
import java.awt.*;

public class GameUi {

    private static JFrame frame;

    public GameUi() {
        GameMain gameMain = GameMain.getGameMain();
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.add(gameMain.getMapa().getPanel(), JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(gameMain.getInteractables().getPanel(), JLayeredPane.PALETTE_LAYER);

        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(layeredPane, BorderLayout.CENTER);
        gameMain.getUi().add(Bizia.getBizia().getBiziaLayer().getPanel());
        frame.add(gameMain.getUi(), BorderLayout.EAST);
        frame.addKeyListener(new GameKeyListener());
        frame.setSize(GraficsConfig.GAME_X_CANVAS_SIZE + GraficsConfig.UI_X_CANVAS_SIZE +32, GraficsConfig.GAME_Y_CANVAS_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        gameMain.getMapa().updateMatrix(MapLoader.kargatuBackground("mapa1Atzekaldea.txt"));
        gameMain.getInteractables().updateMatrix(MapLoader.kargatuBackground("mapa1Interaktiboa.txt"));
    }

    public static JFrame getFrame() {
        return frame;
    }
}
