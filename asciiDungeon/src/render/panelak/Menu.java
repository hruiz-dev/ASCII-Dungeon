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
        panel.add(new JLabel("H Dungeon"), BorderLayout.NORTH);

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

        this.createMap = new JButton("Mapa Sortzailea(Experimental)");
        this.createMap.addActionListener(e -> {
            this.dispose();

            new Thread((Hasiera::startMapBuilder)).start();
        });

        bottomPanel.add(this.createMap);


        //panelean jokuari buruzko informazioa gehitu.
        JPanel informazioaPanel = new JPanel();
        informazioaPanel.setLayout(new GridLayout(10, 0));
        informazioaPanel.add(new JLabel("Informazioa:"));
        informazioaPanel.add(new JLabel("Jokoa martxan jartzeko start botoia sakatu."));
        informazioaPanel.add(new JLabel("Jokoa amaitzeko exit botoia sakatu"));
        informazioaPanel.add(new JLabel("Mapa sortzailea martxan jartzeko Mapa Sortzailea botoia sakatu."));
        informazioaPanel.add(new JLabel("jokalraia mugitzeko w,a, s, d botoiak erabiliko dira."));
        informazioaPanel.add(new JLabel("w-ek joklaraia goraka mugitzen du."));
        informazioaPanel.add(new JLabel("a-ek jokalria ezkerrera mugitzen du."));
        informazioaPanel.add(new JLabel("s-ek jokalria behera mugitzen du."));
        informazioaPanel.add(new JLabel("d-ek jokalria eskubira mugitzen du."));
        informazioaPanel.add(new JLabel("Espazioa sakatzean jokalria atakatu egingo du azkena mugitu zaren direzioan 2x3 kasilako alkanzea du."));


        JPanel subpanel = new JPanel();
        subpanel.setLayout(new GridLayout(2, 1));

        subpanel.add(informazioaPanel);
        subpanel.add(bottomPanel);

        panel.add(subpanel, BorderLayout.CENTER);

        this.add(panel);
        this.setVisible(true);
        this.repaint();
    }

}
