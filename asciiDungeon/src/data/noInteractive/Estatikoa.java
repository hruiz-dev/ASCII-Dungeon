package data.noInteractive;

import data.GameObject;
import data.Vector2;
import render.Layers;

/**
 * Klasea hau GameObjetc estatikoak sortzeko erabiliko dugu
 */
public class Estatikoa extends GameObject {

    public Estatikoa(Formak forma, Vector2 posizioa) {
        super(forma, posizioa);
    }

    /**
     * Funtzio honek ez du ezer egiten, baina nola GameObject klastik eratorria den deklaratu egin beharra dago
     * @return GameObject[][] - Matrizea
     */
    @Override
    public GameObject[][] update() {
        // Do nothing
        return Layers.getMatrix();
    }
}
