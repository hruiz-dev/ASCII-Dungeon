package render.komponeteak;

import data.GameObject;
import data.JokalariaData;
import render.Ui;

import javax.swing.*;
import java.awt.*;

/**
 * Klase hau dirua ui-an implementatzen du
 */
public class Dirua extends Ui {

    private static Dirua dirua;

    private JPanel panel = new JPanel();

    public Dirua(GameObject[][] datuak) {
        super(datuak);
        panel.setLayout(new GridLayout(1,2));
        panel.setOpaque(false);
    }

    /**
     *Sortutako Dirua objetu bat bueltatzen dizu
     * @return Dirua objetua
     */
    public static Dirua getDirua() {
        if (dirua == null) {
            dirua = new Dirua(null);
        }
        return dirua;
    }

    /**
     * Jpanelean Diruaren datu aktualizatzen ditu
     */
    @Override
    public void updateUi() {
        panel.removeAll();

        JLabel a = new JLabel("Dirua:");
        a.setForeground(Color.WHITE);
        panel.add(a);

        JLabel b = new JLabel(Integer.toString(JokalariaData.getDirua()));
        b.setForeground(Color.WHITE);
        panel.add(b);

        panel.revalidate();
        panel.repaint();

    }

    public JPanel getPanel() {
        return panel;
    }
}