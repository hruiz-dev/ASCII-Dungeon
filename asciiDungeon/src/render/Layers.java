package render;

import data.*;
import data.exceptions.GameLogicException;
import data.interactive.Jokalaria;

import javax.swing.*;
import java.awt.*;

/**
 * Klase honek gure jokoaren layerrak sortzen ditu.
 */
public class Layers {

    private static Layers graficos;

//TODO: Metodo honek koleren renderizazioa kontrolatzea falta zait, segun layer mota fonfoa beltza edo transparente izatea

    private static GameObject[][] matrix = new GameObject[GraficsConfig.X_GRID_SIZE][GraficsConfig.Y_GRID_SIZE];

    private JPanel panel;

    public static Layers getGraficos() throws GameLogicException {
        if (graficos == null) {
            graficos = new Layers();
        }
        return graficos;
    }

    private Layers() throws GameLogicException {
        JFrame frame = new JFrame();
        frame.addKeyListener(new GameKeyListener());
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < GraficsConfig.X_GRID_SIZE; i++) {
                    for (int j = 0; j < GraficsConfig.Y_GRID_SIZE; j++) {
                        int x = i * GraficsConfig.CELL_SIZE;
                        int y = j * GraficsConfig.CELL_SIZE;
                        if (matrix[i][j] != null) {
                            g.drawImage(matrix[i][j].getForma().getIrudia(), x, y, GraficsConfig.CELL_SIZE, GraficsConfig.CELL_SIZE, this);
                        } else {
                            g.setColor(Color.BLACK);
                            g.fillRect(x, y, GraficsConfig.CELL_SIZE, GraficsConfig.CELL_SIZE);
                        }
                    }
                }
            }
        };
        panel.setPreferredSize(new Dimension(GraficsConfig.X_CANVAS_SIZE, GraficsConfig.Y_CANVAS_SIZE));
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        matrix[1][1] = Jokalaria.getJokalaria();
    }

    public static GameObject[][] getMatrix() {
        return matrix;
    }

    public void render() {
        panel.repaint();
    }

    /**
     * Metodo honek matriz berri bat jasotzen du eta panela eguneratzen du.
     * @param newMatrix Matriz berria.
     */
    public void updateMatrix(GameObject[][] newMatrix) {
        this.matrix = newMatrix;
        render();
    }
}
