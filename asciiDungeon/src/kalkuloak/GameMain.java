package kalkuloak;

import data.GameMainData;
import data.JokalariaData;
import data.interactive.Jokalaria;
import data.interactive.Monstroa;
import data.noInteractive.Estatikoa;
import data.GameObject;
import render.*;
import render.panelak.GameUi;
import render.panelak.Menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
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
        List<GameObject> borratzeko = new ArrayList<>();
        while (jokoaMartxan) {
            if (objetuak != null) {

                GameObject[][] a = interactables.getMatrix();
                // matrizeko objetu bakoitzeko update metodo exekutatu
                for (GameObject go : objetuak) {
                    if (!go.getClass().equals(Estatikoa.class)) {
                        a = go.update();
                        // Pantaila ez badago objetua borratzeko jarri
                        if (!go.getPatailan()){
                            borratzeko.add(go);
                        }

                    }
                }
                // Monstroak hilda badaude ezabatu
                for (GameObject monstroa : borratzeko) {
                    objetuak.remove(monstroa);
                    a[monstroa.getX()][monstroa.getY()] = null;
                }

                interactables.updateMatrix(a);
            }
            // hemen gure aplikazioaren haria gelditzen dugu gure CPU-a ez gainkargatzeko
            try {
                Thread.sleep(350);
            } catch (InterruptedException e) {
            }
        }
    }

    /**
     * Metod honek gure jokalaria kontrolatuko du.
     */
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
            // Ui komponente guztiak aktualizatu
                for (Ui ui : uiKomponenteak) {
                    ui.updateUi();
                }
                mapa.render();
            }
            // delay bat gehitu gure CPU-a ez gainkargatzeko
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
            }
        }
    }

    /**
     * MEtodo honek jokoa galtzean hau gelditu egiten du eta menua erakusten du.
     */
    public void gameOver() {
        jokoaMartxan = false;
        GameUi.getFrame().dispose();
        //Trhead guztiak gelditu
        threads.forEach(Thread::interrupt);
        // Menua erakutsi
        JFrame frame = new JFrame("Game Over");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(2,1));
        frame.add(new JLabel("Partida amaitu da"));
        frame.add(new JLabel("Lortu duzun Dirua: " + JokalariaData.getDirua()));
        frame.setVisible(true);
    }

    /**
     * Metodo honek gura jokuaren loop-a hasiko du beste thread batean.
     */
    public void init() {
        jokoaMartxan = true;
        Jokalaria.getJokalaria().setBizia(20);

        new GameUi();

        // Gure mapak matrizera gehitu
        int b = GameMainData.getMomentukoMapa();
        GameMainData.getMapa().updateMatrix(MapLoader.kargatuBackground("mapa" + b + "Atzekaldea.txt"));
        GameMainData.getInteractables().updateMatrix(MapLoader.kargatuBackground("mapa" + b +"Interaktiboa.txt"));

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

    /**
     * Metodo honk gure mapa hurrengo mapaengatik aldatzen du.
     */
    public void changeMap(){
        // matrixak garbitu
        objetuak.clear();
        mapa.setMatrixNull();
        interactables.setMatrixNull();
        mapa.render();
        interactables.render();

        // mapa aldatu
        int a = GameMainData.getMomentukoMapa();
        mapa.updateMatrix(MapLoader.kargatuBackground("mapa" + a + "Atzekaldea.txt" ));
        interactables.updateMatrix(MapLoader.kargatuBackground("mapa" + a + "Interaktiboa.txt" ));
    }

    /**
     * Metodo honek jokua irabaztewan agertzen den menua erakusten du.
     */
    public void winGame() {
        // Jokoa gelditu
        jokoaMartxan = false;
        GameUi.getFrame().dispose();
        threads.forEach(Thread::interrupt);

        // Menua erakutsi
        JFrame frame = new JFrame("Irabazi duzu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(2,1));
        frame.add(new JLabel("Partida amaitu da, Mazmorratik atera zara. Zorionak!"));
        frame.add(new JLabel("Lortu duzun Dirua: " + JokalariaData.getDirua()));
        frame.setVisible(true);
    }
}
