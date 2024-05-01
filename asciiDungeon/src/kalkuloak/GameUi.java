package kalkuloak;

import data.GameKeyListener;
import data.GameMainData;
import render.Bizia;
import render.GraficsConfig;

import javax.swing.*;
import java.awt.*;

public class GameUi {

    private static JFrame frame;

    public GameUi() {
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.add(GameMainData.getMapa().getPanel(), JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(GameMainData.getInteractables().getPanel(), JLayeredPane.PALETTE_LAYER);

        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(layeredPane, BorderLayout.CENTER);
        frame.add(GameMainData.getUi(), BorderLayout.EAST);
        frame.addKeyListener(new GameKeyListener());
        frame.setSize(GraficsConfig.GAME_X_CANVAS_SIZE + GraficsConfig.UI_X_CANVAS_SIZE +32, GraficsConfig.GAME_Y_CANVAS_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        GameMainData.getMapa().updateMatrix(MapLoader.kargatuBackground("mapa1Atzekaldea.txt"));
        GameMainData.getInteractables().updateMatrix(MapLoader.kargatuBackground("mapa1Interaktiboa.txt"));
    }

    public static JFrame getFrame() {
        return frame;
    }
}
