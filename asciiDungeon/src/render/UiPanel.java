package render;

import javax.swing.*;
import java.awt.*;

public class UiPanel extends JPanel {

    public UiPanel() {
        super();
        this.setSize(GraficsConfig.UI_X_CANVAS_SIZE, GraficsConfig.UI_Y_CANVAS_SIZE);
        this.setBackground(Color.BLACK);
    }
}
