package render.panelak;

import render.*;
import render.komponeteak.ArmaduraUi;
import render.komponeteak.Bizia;
import render.komponeteak.Dirua;
import render.komponeteak.Giltzak;

import javax.swing.*;
import java.awt.*;

/**
 * Komponete honek Ui-ko informazio guztia du
 */
public class UiPanel extends JPanel {

    public UiPanel() {
        super();
        this.setSize(GraficsConfig.UI_X_CANVAS_SIZE, GraficsConfig.UI_Y_CANVAS_SIZE);
        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());

        this.add(Bizia.getBizia().getBiziaLayer().getPanel(), createConstrains(0, 0, 1, 1));
        this.add(ArmaduraUi.getArmaduraUi().getArmaduraLayer().getPanel(), createConstrains(1, 0, 1, 1));

        this.add(Giltzak.getGiltzak().getGiltza().getPanel(), createConstrains(0, 1, 2, 1));

        this.add(Dirua.getDirua().getPanel(), createConstrains(0, 2, 2, 1));

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
