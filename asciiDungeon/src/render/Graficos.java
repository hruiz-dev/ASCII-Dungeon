package render;

import data.*;
import data.exceptions.GameLogicException;

import javax.swing.*;
import java.awt.*;

public class Graficos {

    private static final int X_CANVAS_SIZE = 1056;
    private static final int Y_CANVAS_SIZE = 720;
    public static final int X_GRID_SIZE = 66;
    public static final int Y_GRID_SIZE = 45;
    private static final int CELL_SIZE = 16;

    private static GameObject[][] matrix = new GameObject[X_GRID_SIZE][Y_GRID_SIZE];

    private JPanel panel;

    public Graficos() throws GameLogicException {
        JFrame frame = new JFrame();
        frame.addKeyListener(new GameKeyListener());
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < X_GRID_SIZE; i++) {
                    for (int j = 0; j < Y_GRID_SIZE; j++) {
                        int x = i * CELL_SIZE;
                        int y = j * CELL_SIZE;
                        if (matrix[i][j] != null) {
                            g.drawImage(matrix[i][j].getForma().getIrudia(), x, y, CELL_SIZE, CELL_SIZE, this);
                        } else {
                            g.setColor(Color.BLACK);
                            g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                        }
                    }
                }
            }
        };
        panel.setPreferredSize(new Dimension(X_CANVAS_SIZE, Y_CANVAS_SIZE));
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        for (int i = 0; i < X_GRID_SIZE; i++) {
            for (int j = 0; j < 25; j++) {
               if ((j + i) % 2 == 0) {
                   matrix[i][j] = new Estatikoa(Formak.FLOOR, new Vector2(i, j));
               }
            }
        }
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
