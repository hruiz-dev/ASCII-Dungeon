package render;

import data.*;

import javax.swing.*;
import java.awt.*;

/**
 * Klase honek gure jokoaren layerrak sortzen ditu.
 */
public class Layers {


//TODO: Metodo honek koleren renderizazioa kontrolatzea falta zait, segun layer mota fonfoa beltza edo transparente izatea

    private GameObject[][] matrix;

    private JPanel panel;

    public Layers(int layerType, int xGridSize, int yGridSize, int xCanvasSize, int yCanvasSize) {
        matrix = new GameObject[xGridSize][yGridSize];
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                for (int i = 0; i < xGridSize; i++) {
                    for (int j = 0; j < yGridSize; j++) {
                        int x = i * GraficsConfig.CELL_SIZE;
                        int y = j * GraficsConfig.CELL_SIZE;
                        if (matrix[i][j] != null) {
                            g2d.setComposite(AlphaComposite.SrcOver);
                            g2d.drawImage(matrix[i][j].getForma().getIrudia(), x, y, GraficsConfig.CELL_SIZE, GraficsConfig.CELL_SIZE, this);
                        } else {
                            if (layerType == 1) {
                                g2d.setColor(new Color(0, 0, 0, 0));
                                g2d.fillRect(x, y, GraficsConfig.CELL_SIZE, GraficsConfig.CELL_SIZE);
                            } else {
                                g2d.setColor(Color.BLACK);
                                g2d.fillRect(x, y, GraficsConfig.CELL_SIZE, GraficsConfig.CELL_SIZE);
                            }
                        }
                    }
                }
                g2d.dispose();
            }
        };
        panel.setPreferredSize(new Dimension(xCanvasSize, yCanvasSize));
        panel.setBounds(0, 0, xCanvasSize, yCanvasSize);
        if (layerType == 1) {
            panel.setOpaque(false);
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public GameObject[][] getMatrix() {
        return matrix;
    }

    public void render() {
        SwingUtilities.invokeLater(() -> panel.repaint());
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