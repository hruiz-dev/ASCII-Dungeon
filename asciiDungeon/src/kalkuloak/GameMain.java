package kalkuloak;

import data.noInteractive.Estatikoa;
import data.GameObject;
import data.exceptions.GameLogicException;
import render.Layers;
import render.Ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Klase hau gure jokoaren loop prinzipala kontrolatuko du.
 */
public class GameMain {

    private static GameMain gameMain;

    private List<GameObject> objetuak = new ArrayList<>();
    private List<Ui> uiKomponenteak = new ArrayList<>();

    private GameObject[][] mapa;

    private boolean jokoaMartxan = true;

    /**
     * Metodo honek gure jokoaren eragiketa logikoak egingo ditu.
     */
    public void gameLoop() {
        mapa = Layers.getMatrix();
        while (jokoaMartxan) {
            if (objetuak != null) {
                List<GameObject> toUpdate = new ArrayList<>(objetuak);
                for (GameObject go : toUpdate) {
                    if (!go.getClass().equals(Estatikoa.class)) {
                        mapa = go.update();
                    }
                }
                objetuak = toUpdate;
            }
            render();
        }
        gameOver();
    }

    private GameMain(){

    }

    public static GameMain getGameMain(){
        if (gameMain == null){
            gameMain = new GameMain();
        }
        return gameMain;
    }

    /**
     * Metodo hau gure Ui objetu guztiak atualizatuko ditu. eta gero joka renderizatuko du.
     */
    public void render() {
        if (uiKomponenteak != null) {
            Iterator<Ui> iterator = uiKomponenteak.iterator();
            while (iterator.hasNext()) {
                Ui ui = iterator.next();
                ui.updateUi();
            }
        }
        try {
            Layers.getGraficos().updateMatrix(mapa);
            Thread.sleep(100);
        } catch (GameLogicException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void gameOver() {

    }

    /**
     * Metodo honek gura jokuaren loop-a hasiko du beste thread batean.
     */
    public void init() {
        gameLoop();
    }

    public List<GameObject> getObjetuak() {
        return objetuak;
    }

    public void setObjetuak(List<GameObject> objetuak) {
        this.objetuak = objetuak;
    }

    public List<Ui> getUiKomponenteak() {
        return uiKomponenteak;
    }

    public void setUiKomponenteak(List<Ui> uiKomponenteak) {
        this.uiKomponenteak = uiKomponenteak;
    }
}
