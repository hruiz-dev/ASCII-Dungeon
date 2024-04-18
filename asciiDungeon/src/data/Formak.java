package data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Klase honeta gure acii karakterak eta iruaduak mapeatzeko erabiliko dugu.
 */
public enum Formak {
    WALL('#', "assets/pareta.png"),
    FLOOR('-', "assets/lurra.png");

    private final char symbol;
    private final Image irudia;

    Formak(char symbol, String irudia) {
        this.symbol = symbol;
        BufferedImage image;
        try {
            image = image = ImageIO.read(new File(irudia));
            this.irudia = image;
        } catch (IOException e) {
            throw  new RuntimeException("Irudia ezin da kargatu: " + irudia);
        }
    }

    public char getSymbol() {
        return symbol;
    }

    public Image getIrudia() {
        return irudia;
    }


}
