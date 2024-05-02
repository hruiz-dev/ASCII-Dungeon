package data;

import render.*;
import render.panelak.KonsolaPanel;
import render.panelak.UiPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GameMainData {

    private static List<GameObject> objetuak = new ArrayList<>();
    private static List<Ui> uiKomponenteak = new ArrayList<>();

    private static Layers mapa = new Layers(0, GraficsConfig.GAME_X_GRID_SIZE, GraficsConfig.GAME_Y_GRID_SIZE, GraficsConfig.GAME_X_CANVAS_SIZE, GraficsConfig.GAME_Y_CANVAS_SIZE);
    private static Layers interactables = new Layers(1, GraficsConfig.GAME_X_GRID_SIZE, GraficsConfig.GAME_Y_GRID_SIZE, GraficsConfig.GAME_X_CANVAS_SIZE, GraficsConfig.GAME_Y_CANVAS_SIZE);

    private static JPanel ui = new UiPanel();
    private static KonsolaPanel konsola = new KonsolaPanel();

    private static List<Thread> threads = new ArrayList<>();

    public static List<GameObject> getObjetuak() {
        return objetuak;
    }

    public static void setObjetuak(List<GameObject> objetuak) {
        GameMainData.objetuak = objetuak;
    }

    public static List<Ui> getUiKomponenteak() {
        return uiKomponenteak;
    }

    public static void setUiKomponenteak(List<Ui> uiKomponenteak) {
        GameMainData.uiKomponenteak = uiKomponenteak;
    }

    public static Layers getMapa() {
        return mapa;
    }

    public static void setMapa(Layers mapa) {
        GameMainData.mapa = mapa;
    }

    public static Layers getInteractables() {
        return interactables;
    }

    public static void setInteractables(Layers interactables) {
        GameMainData.interactables = interactables;
    }

    public static JPanel getUi() {
        return ui;
    }

    public static void setUi(JPanel ui) {
        GameMainData.ui = ui;
    }

    public static List<Thread> getThreads() {
        return threads;
    }

    public static void setThreads(List<Thread> threads) {
        GameMainData.threads = threads;
    }

    public static KonsolaPanel getKonsola() {
        return konsola;
    }

    public static void setKonsola(KonsolaPanel konsola) {
        GameMainData.konsola = konsola;
    }
}
