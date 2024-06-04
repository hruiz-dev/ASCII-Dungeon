package render;

import data.*;

import javax.swing.*;
import java.awt.*;

/**
 * Klase honek gure jokoaren layerrak sortzen ditu.
 */
public class Layers {

    private GameObject[][] matrix;

    private JPanel panel;

    public Layers(int layerType, int xGridSize, int yGridSize, int xCanvasSize, int yCanvasSize) {
        matrix = new GameObject[xGridSize][yGridSize];
        // Panelaren repaint metodo modifikatu
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                // matrix matrizeko elementu guztiak pintatzen ditu
                for (int i = 0; i < xGridSize; i++) {
                    for (int j = 0; j < yGridSize; j++) {
                        int x = i * GraficsConfig.CELL_SIZE;
                        int y = j * GraficsConfig.CELL_SIZE;
                        // posizioa ez bada nuloa eta ez bada null, irudia kargatzen da
                        if (matrix[i][j] != null) {
                            g2d.setComposite(AlphaComposite.SrcOver);
                            g2d.drawImage(matrix[i][j].getForma().getIrudia(), x, y, GraficsConfig.CELL_SIZE, GraficsConfig.CELL_SIZE, this);
                        } else {
                            // 1 motako layer bat bada fondoa transparentea uzten du
                            if (layerType == 1) {
                                g2d.setColor(new Color(0, 0, 0, 0));
                                g2d.fillRect(x, y, GraficsConfig.CELL_SIZE, GraficsConfig.CELL_SIZE);
                            } else {
                                // bestela, kolorea beltza
                                g2d.setColor(Color.BLACK);
                                g2d.fillRect(x, y, GraficsConfig.CELL_SIZE, GraficsConfig.CELL_SIZE);
                            }
                        }
                    }
                }
                g2d.dispose();
            }
        };
        // panelaren tamaina ezarri
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

    /**
     * jokuko panela renderizatzen du.
     */
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

    /**
     * Metodo honek matrizeko elementu guztiak null egiten ditu.
     */
    public void setMatrixNull() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = null;
            }
        }
    }
}