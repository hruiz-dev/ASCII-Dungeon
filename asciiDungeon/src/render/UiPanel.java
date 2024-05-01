package render;

import javax.swing.*;
import java.awt.*;

public class UiPanel extends JPanel {

    public UiPanel() {
        super();
        this.setSize(GraficsConfig.UI_X_CANVAS_SIZE, GraficsConfig.UI_Y_CANVAS_SIZE);
        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());

        this.add(Bizia.getBizia().getBiziaLayer().getPanel(), createConstrains(0, 0, 1, 1));

        this.add(customLabel("Armadura"), createConstrains(0, 1, 1, 1));
        this.add(customLabel("Placeholder"), createConstrains(0, 2, 1, 1));

        this.add(customLabel("Placeholder"), createConstrains(0, 3, 1, 1));
        this.add(customLabel("Placeholder"), createConstrains(0, 4, 1, 1));

        this.add(customLabel("Placeholder"), createConstrains(0, 5, 1, 1));
        this.add(customLabel("Placeholder"), createConstrains(0, 6, 1, 1));


    }

    private JLabel customLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
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
