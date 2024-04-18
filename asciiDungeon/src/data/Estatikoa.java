package data;

import render.Graficos;

public class Estatikoa extends GameObject{

    public Estatikoa(Formak forma, Vector2 posizioa) {
        super(forma, posizioa);
    }

    @Override
    public GameObject[][] update() {
        // Do nothing
        return Graficos.getMatrix();
    }
}
