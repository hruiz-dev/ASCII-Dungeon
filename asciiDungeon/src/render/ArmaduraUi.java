package render;

import data.Armadura;
import data.Estatikoa;
import data.Formak;
import data.Vector2;

public class ArmaduraUi extends Ui {

    private Armadura armadura;
    public ArmaduraUi(Vector2 posizioa, Formak[][] datuak, Armadura armadura) {
        super(posizioa, datuak);
        this.armadura = armadura;
    }

    @Override
    public void updateUi() {
        //TODO metodo honek gure armaduraren irudia eguneratuko du
    }

    @Override
    public Estatikoa[][] toGameObject() {
        //TODO metodo honek gure armaduraren datuak itzuliko ditu
        return new Estatikoa[0][];
    }
}
