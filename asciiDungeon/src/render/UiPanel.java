package render;

import javax.swing.*;
import java.awt.*;

public class UiPanel extends JPanel {

    public UiPanel() {
        super();
        this.setSize(GraficsConfig.UI_X_CANVAS_SIZE, GraficsConfig.UI_Y_CANVAS_SIZE);
        this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(6,2));
        this.add(customLabel("Bizia:"));
        this.add(Bizia.getBizia().getBiziaLayer().getPanel());
    }

    private JLabel customLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        return label;
    }
}
