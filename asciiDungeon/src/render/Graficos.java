package render;

import data.Formak;

import javax.swing.*;
import java.awt.*;

public class Graficos {

    private static final int X_CANVAS_SIZE = 1056;
    private static final int Y_CANVAS_SIZE = 720;
    private static final int X_GRID_SIZE = 66;
    private static final int Y_GRID_SIZE = 45;
    private static final int CELL_SIZE = 16;

    private Formak[][] matrix = new Formak[X_GRID_SIZE][Y_GRID_SIZE];

    private JPanel panel;

    public Graficos() {
        JFrame frame = new JFrame();
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < X_GRID_SIZE; i++) {
                    for (int j = 0; j < Y_GRID_SIZE; j++) {
                        int x = i * CELL_SIZE;
                        int y = j * CELL_SIZE;
                        if (matrix[i][j] != null) {
                            g.drawImage(matrix[i][j].getIrudia(), x, y, CELL_SIZE, CELL_SIZE, this);
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
            for (int j = 0; j < 35; j++) {
                matrix[i][j] = Formak.WALL;
            }
        }
    }

    public void render() {
        panel.repaint();
    }

    public void updateMatrix(Formak[][] newMatrix) {
        this.matrix = newMatrix;
        render();
    }
}
