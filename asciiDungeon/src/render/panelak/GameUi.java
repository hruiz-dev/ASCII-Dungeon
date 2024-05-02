package render.panelak;

import data.GameKeyListener;
import data.GameMainData;
import kalkuloak.MapLoader;
import render.GraficsConfig;

import javax.swing.*;
import java.awt.*;

/**
 * komponete ha gure jokuko frame-a da, honetan beste panel guztiak daude
 */
public class GameUi {

    private static JFrame frame;

    /**
     * Klasearen konstruktorea, objetu guztiak rekolokatzen ditu pere posizioan
     */
    public GameUi() {
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.add(GameMainData.getMapa().getPanel(), JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(GameMainData.getInteractables().getPanel(), JLayeredPane.PALETTE_LAYER);

        frame = new JFrame();
        frame.setLayout(new GridBagLayout());

        frame.add(layeredPane, createConstrains(0, 0, 6.6, 4.8));

        frame.add(GameMainData.getUi(), createConstrains(1, 0, 1, 4.8));

        frame.add(GameMainData.getKonsola(), createConstrains(0, 1, 6.6, 1));

        frame.addKeyListener(new GameKeyListener());
        frame.setSize(GraficsConfig.GAME_X_FRAME_SIZE, GraficsConfig.GAME_Y_FRAME_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        GameMainData.getMapa().updateMatrix(MapLoader.kargatuBackground("mapa1Atzekaldea.txt"));
        GameMainData.getInteractables().updateMatrix(MapLoader.kargatuBackground("mapa1Interaktiboa.txt"));
    }

    public static JFrame getFrame() {
        return frame;
    }

    /**
     * Funtzio honek gure framean panel bakoitzak zenbat okupatzen duen defintzn du
     * @param gridx gure panelaren x posizioa
     * @param gridy gure panelaren y posizioa
     * @param gridwidth gure panelaren zabalera
     * @param gridheight gure panelaren altuera
     * @return panelaren konfigurazioa
     */
    private GridBagConstraints createConstrains(int gridx, int gridy, double gridwidth, double gridheight){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;
        c.weightx = gridwidth;
        c.weighty = gridheight;
        c.fill = GridBagConstraints.BOTH;
        return c;
    }
}
