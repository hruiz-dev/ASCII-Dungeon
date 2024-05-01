package render;

import javax.swing.*;
import java.awt.*;

public class UiPanel extends JPanel {

    public UiPanel() {
        super();
        this.setSize(GraficsConfig.UI_X_CANVAS_SIZE, GraficsConfig.UI_Y_CANVAS_SIZE);
        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());
        this.setAlignmentY(TOP_ALIGNMENT);
        this.add(customLabel("Bizia:"), createConstrains(0, 0, 1, 1));
        this.add(Bizia.getBizia().getBiziaLayer().getPanel(), createConstrains(1, 0, 1, 1));
        this.add(customLabel("Armadura"));

    }

    private JLabel customLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setAlignmentY(TOP_ALIGNMENT);
        return label;
    }

    /**
     * Funtzio honek gure framean panel bakoitzak zenbat okupatzen duen defintzn du
     * @param gridx gure panelaren x posizioa
     * @param gridy gure panelaren y posizioa
     * @param gridwidth gure panelaren zabalera
     * @param gridheight gure panelaren altuera
     * @return panelaren konfigurazioa
     */
    private GridBagConstraints createConstrains(int gridx, int gridy, double gridwidth, double gridheight){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;
        c.weightx = gridwidth;
        c.weighty = gridheight;
        c.fill = GridBagConstraints.BOTH;
        return c;
    }
}
