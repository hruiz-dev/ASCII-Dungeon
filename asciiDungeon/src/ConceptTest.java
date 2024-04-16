import javax.swing.*;
import java.awt.*;

public class ConceptTest {
    private static final int X_CANVAS_SIZE = 1056;
    private static final int Y_CANVAS_SIZE = 720;
    private static final int X_GRID_SIZE = 66;
    private static final int Y_GRID_SIZE = 45;
    private static final int CELL_SIZE = 16;

    private int[][] matrix = new int[X_GRID_SIZE][Y_GRID_SIZE];
    private JPanel panel;

    private JFrame frame;

    public ConceptTest() {
        frame = new JFrame();
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < X_GRID_SIZE; i++) {
                    for (int j = 0; j < Y_GRID_SIZE; j++) {
                        int x = i * CELL_SIZE;
                        int y = j * CELL_SIZE;
                        if (matrix[i][j] == 1) {
                            g.setColor(Color.BLACK);
                            g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                        } else {
                            g.setColor(Color.WHITE);
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
            for (int j = 0; j < 45; j++) {
                matrix[i][j] = 1;
            }
        }
    }

    public void render() {
        panel.repaint();
    }

    public void updateMatrix(int[][] newMatrix) {
        this.matrix = newMatrix;
        render();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConceptTest a = new ConceptTest();
            a.render();
        });
    }
}