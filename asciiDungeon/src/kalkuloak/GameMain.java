package kalkuloak;

import data.GameKeyListener;
import data.GameMainData;
import data.Vector2;
import data.interactive.Jokalaria;
import data.noInteractive.Estatikoa;
import data.GameObject;
import data.exceptions.GameLogicException;
import data.noInteractive.Formak;
import render.*;
import render.Menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Klase hau gure jokoaren loop prinzipala kontrolatuko du.
 */
public class GameMain {

    private static GameMain gameMain;

    private static List<GameObject> objetuak = GameMainData.getObjetuak();
    private static List<Ui> uiKomponenteak = GameMainData.getUiKomponenteak();

    private static Layers mapa = GameMainData.getMapa();
    private static Layers interactables = GameMainData.getInteractables();

    private static List<Thread> threads = GameMainData.getThreads();

    private boolean jokoaMartxan = true;

    /**
     * Metodo honek gure jokoaren eragiketa logikoak egingo ditu.
     */
    public void gameLoop() {
//        testFunction();

        while (jokoaMartxan) {
            if (objetuak != null) {

                GameObject[][] a = interactables.getMatrix();
                List<GameObject> toUpdate = new ArrayList<>(objetuak);
                for (GameObject go : toUpdate) {
                    if (!go.getClass().equals(Estatikoa.class)) {
                        a = go.update();

                    }
                }
                objetuak = toUpdate;
                interactables.updateMatrix(a);

            }
            // hemen gure aplikazioaren haria gelditzen dugu gure CPU-a ez gainkargatzeko
            try {
                Thread.sleep(350);
            } catch (InterruptedException e) {
            }
        }
    }

    public void playerLoop() {
        while (jokoaMartxan) {
            interactables.updateMatrix(Jokalaria.getJokalaria().update());
        }
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

                for (Ui ui : uiKomponenteak) {
                    ui.updateUi();
                }
                mapa.render();
            }
            // delay bat gehitu gure CPU-a ez gainkargatzeko
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
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

        GameObject[][] b = mapa.getMatrix();
        for (int i = 0; i < GraficsConfig.GAME_X_GRID_SIZE; i++) {
            for (int j = 0; j < GraficsConfig.GAME_Y_GRID_SIZE; j++) {
                b[i][j] = new Estatikoa(Formak.FLOOR);
            }
        }
        mapa.updateMatrix(b);
    }

    public void gameOver() {
        jokoaMartxan = false;
        GameUi.getFrame().dispose();
        threads.forEach(Thread::interrupt);
        Menu panela = new Menu();
        panela.gameOverMezua("Game Over");
    }

    /**
     * Metodo honek gura jokuaren loop-a hasiko du beste thread batean.
     */
    public void init() {
        jokoaMartxan = true;
        Jokalaria.getJokalaria().setBizia(20);

        new GameUi();

        threads.clear();

        // Hari ezberdinak erabiliz gure jukoaren logika eta renderizazio klakuloak separatzen ditugu
        threads.add(new Thread(this::gameLoop));
        threads.add(new Thread(this::render));
        threads.add(new Thread(this::playerLoop));

        threads.forEach(thread -> {
            if (!thread.isAlive()) {
                thread.start();
            }
        });
    }

}
