package render;
import kalkuloak.Hasiera;

import javax.swing.*;

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
        panel.add(new JLabel("Menu"));

        this.exit = new JButton("Exit");
        this.exit.addActionListener(e -> {
            System.exit(0);
        });
        panel.add(this.exit);

        this.start = new JButton("Start");
        this.start.addActionListener(e -> {
            this.dispose();
            // Kode zati honek hilo berri baten gure jokoa ejekutatzen du
           new Thread(Hasiera::startGame).start();
        });

        panel.add(this.start);

        this.createMap = new JButton("Create Map");
        this.createMap.addActionListener(e -> {
            this.dispose();

            new Thread((Hasiera::startMapBuilder)).start();
        });

        panel.add(this.createMap);
        this.add(panel);
        this.setVisible(true);
        this.repaint();
    }
}
