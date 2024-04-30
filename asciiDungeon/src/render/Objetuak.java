package render;

import data.GameObject;
import data.noInteractive.Estatikoa;
import data.noInteractive.Formak;
import data.Item;
import data.Vector2;

import java.util.List;

/**
 * Klasea honek gure motxila diitugun objetuak erakutsiko ditu.
 */
public class Objetuak extends Ui{

    private List<Item> objetuak;

    public Objetuak( GameObject[][] datuak) {
        super(datuak);
    }

    @Override
    public void updateUi() {
        //TODO: objetuak pantailan erakutsi eta objetu katitatea eguneratu
    }

}
