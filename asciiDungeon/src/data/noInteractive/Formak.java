package data.noInteractive;

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
    FLOOR('-', "assets/lurra.png"),
    PLAYER('@', "assets/jokalaria.png"),
    ENEMY('E', "assets/troll.png"),
    DOOR('D', "assets/atea.png"),
    KEY('K', "assets/giltza.png"),
    TREASURE('T', "assets/altxorra.png"),

    HEART1('H', "assets/ui/bihotza1-4.png"),
    HEART2('H', "assets/ui/bihotza2-4.png"),
    HEART3('H', "assets/ui/bihotza3-4.png"),
    HEART4('H', "assets/ui/bihotzaOsorik.png"),

    SHIELD1('S', "assets/ui/eskudoa1-2.png"),
    SHIELD2('S', "assets/ui/eskudoaOsorik.png");
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
