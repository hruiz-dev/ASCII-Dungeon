package render;

import javax.swing.*;
import java.awt.*;

public class KonsolaPanel extends JPanel {

    private JLabel konsola = new JLabel();

    public KonsolaPanel() {
        super();
        this.setSize(GraficsConfig.GAME_X_CANVAS_SIZE, 160);
        this.setBackground(Color.BLACK);
        konsola.setForeground(Color.WHITE);
        this.add(konsola);

    }

    public void setMezua(String mezua){
        konsola.setText(mezua);
    }

}
