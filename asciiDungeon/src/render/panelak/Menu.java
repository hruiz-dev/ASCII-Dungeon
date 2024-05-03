package render.panelak;
import kalkuloak.Hasiera;
import render.GraficsConfig;

import javax.swing.*;
import java.awt.*;

/**
 * Klase hau gure hsierako menua kargatzen duen klasea da.
 */
public class Menu extends JFrame {

    private JButton exit;
    private JButton start;
    private JButton createMap;
    private JPanel panel = new JPanel();

    /**
     * Konstruktore honek gure Interfaz printzipaleko menua sortzen du
     */
    public Menu() {
        super();
        this.setSize(GraficsConfig.GAME_X_CANVAS_SIZE, GraficsConfig.GAME_Y_CANVAS_SIZE);
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("Menu"), BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridBagLayout());

        this.exit = new JButton("Exit");
        this.exit.addActionListener(e -> {
            System.exit(0);
        });
        bottomPanel.add(this.exit);

        this.start = new JButton("Start");
        this.start.addActionListener(e -> {
            this.dispose();
            // Kode zati honek hilo berri baten gure jokoa ejekutatzen du
           new Thread(Hasiera::startGame).start();
        });

        bottomPanel.add(this.start);

        this.createMap = new JButton("Mapaka Sortzailea(Experimental)");
        this.createMap.addActionListener(e -> {
            this.dispose();

            new Thread((Hasiera::startMapBuilder)).start();
        });

        bottomPanel.add(this.createMap);
        panel.add(bottomPanel, BorderLayout.CENTER);
        this.add(panel);
        this.setVisible(true);
        this.repaint();
    }

    /**
     * partida galdutakoan erakusten den mezua
     * @param mezua mezua
     */

}
