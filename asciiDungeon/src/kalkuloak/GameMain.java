package kalkuloak;

import data.Vector2;
import data.interactive.Jokalaria;
import data.noInteractive.Estatikoa;
import data.GameObject;
import data.exceptions.GameLogicException;
import data.noInteractive.Formak;
import render.GraficsConfig;
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

    private Layers mapa = new Layers(0, GraficsConfig.GAME_X_GRID_SIZE, GraficsConfig.GAME_Y_GRID_SIZE, GraficsConfig.GAME_X_CANVAS_SIZE, GraficsConfig.GAME_Y_CANVAS_SIZE);
    private Layers interactables = new Layers(1, GraficsConfig.GAME_X_GRID_SIZE, GraficsConfig.GAME_Y_GRID_SIZE, GraficsConfig.GAME_X_CANVAS_SIZE, GraficsConfig.GAME_Y_CANVAS_SIZE);
    private Layers ui = new Layers(0, GraficsConfig.UI_X_GRID_SIZE, GraficsConfig.UI_Y_GRID_SIZE, GraficsConfig.UI_X_CANVAS_SIZE, GraficsConfig.UI_Y_CANVAS_SIZE);

    private boolean jokoaMartxan = true;

    /**
     * Metodo honek gure jokoaren eragiketa logikoak egingo ditu.
     */
    public void gameLoop() {
        testFunction();

        while (jokoaMartxan) {
            if (objetuak != null) {
                List<GameObject> toUpdate = new ArrayList<>(objetuak);
                for (GameObject go : toUpdate) {
                    if (!go.getClass().equals(Estatikoa.class)) {
                        interactables.updateMatrix(go.update());

                    }
                }
                objetuak = toUpdate;
            }
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
        while (jokoaMartxan) {
            if (uiKomponenteak != null) {
                Iterator<Ui> iterator = uiKomponenteak.iterator();
                while (iterator.hasNext()) {
                    Ui ui = iterator.next();
                    ui.updateUi();
                }
                mapa.render();
                this.ui.render();
            }
        }
    }

    public void testFunction(){
        GameObject[][] a = interactables.getMatrix();
        try {
            a[3][4] = Jokalaria.getJokalaria();
            Jokalaria.getJokalaria().setPosizioa(new Vector2(3, 4));
        } catch (GameLogicException e) {
            throw new RuntimeException(e);
        }
        interactables.updateMatrix(a);

        // Testak egiteko funtzioa
//        GameObject[][] b = mapa.getMatrix();
//        for (int i = 0; i < GraficsConfig.GAME_X_GRID_SIZE; i++) {
//            for (int j = 0; j < GraficsConfig.GAME_Y_GRID_SIZE; j++) {
//                b[i][j] = new Estatikoa(Formak.FLOOR);
//            }
//        }
//        mapa.updateMatrix(b);
    }

    public void gameOver() {

    }

    /**
     * Metodo honek gura jokuaren loop-a hasiko du beste thread batean.
     */
    public void init() {
        // Hari ezberdinak erabiliz gure jukoaren logika eta renderizazio klakuloak separatzen ditugu
        new Thread(this::gameLoop).start();
        new Thread(this::render).start();
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

    public Layers getMapa() {
        return mapa;
    }

    public Layers getUi() {
        return ui;
    }

    public Layers getInteractables() {
        return interactables;
    }
}
