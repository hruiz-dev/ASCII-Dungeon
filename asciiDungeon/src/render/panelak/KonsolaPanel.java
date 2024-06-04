package render.panelak;

import render.GraficsConfig;

import javax.swing.*;
import java.awt.*;

/**
 * Klase hau partidari buruzko mezu txikiak erakusteko erabiltzen da.
 */
public class KonsolaPanel extends JPanel {

    private JLabel konsola = new JLabel();

    /**
     * KonsolaPanel klasearen konstruktorea
     */
    public KonsolaPanel() {
        super();
        this.setSize(GraficsConfig.GAME_X_CANVAS_SIZE, 160);
        this.setBackground(Color.BLACK);
        konsola.setForeground(Color.WHITE);
        this.add(konsola);

    }

    /**
     * Konsolako mezua aldatzen du
     * @param mezua Mezua
     */
    public void setMezua(String mezua){
        konsola.setText(mezua);
    }

}
