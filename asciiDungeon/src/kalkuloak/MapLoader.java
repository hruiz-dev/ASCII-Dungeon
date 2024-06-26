package kalkuloak;

import data.GameObject;
import data.Vector2;
import data.exceptions.GameLogicException;
import data.interactive.Altxorra;
import data.interactive.Jokalaria;
import data.interactive.Monstroa;
import data.interactive.Portal;
import data.noInteractive.Estatikoa;
import data.noInteractive.Formak;
import render.GraficsConfig;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;


/**
 * Klase hau gure mapak kargatzeko erabiliko dugu.

 */
public class MapLoader {

    /**
     * Funtzio honek gure mapa kargatzen du fitxategi batetik
     * @param fileName Fitxategiaren izena
     * @return Mapa matrizean gordeta
     */
    public static GameObject[][] kargatuBackground(String fileName) {
        String path = "assets/mapak/" + fileName;
        GameObject[][] map = new GameObject[GraficsConfig.GAME_X_GRID_SIZE][GraficsConfig.GAME_Y_GRID_SIZE];

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            int i = 0;
            // Fitxategiaren lerro bakoitza irakurri
            while ((line = br.readLine()) != null) {
                for (int j = 0; j < line.length(); j++) {
                        map[j][i] = kargatuObjetua(line.charAt(j), new Vector2(j, i));
                        if (map[j][i] instanceof Jokalaria) {
                            Jokalaria.getJokalaria().setPosizioa(new Vector2(j, i));
                        }
                }
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (GameLogicException e) {
            throw new RuntimeException(e);
        }
        // Mapa kargatua itzuli
        return map;
    }

    /**
     * Funtzio honek karakterea eta poszioa hemanda game object bat kargatzen du.
     * @param symbol Karakterea
     * @param posizioa Posizioa
     * @return GameObject bat
     */
    public static GameObject kargatuObjetua(char symbol, Vector2 posizioa) {
        if (symbol == Formak.WALL.getSymbol()) {
            return new Estatikoa(Formak.WALL);
        } else if (symbol == Formak.FLOOR.getSymbol()) {
            return new Estatikoa(Formak.FLOOR);
        } else if (symbol == Formak.PLAYER.getSymbol()) {
            return Jokalaria.getJokalaria();
        } else if (symbol == Formak.ENEMY.getSymbol()) {
            return new Monstroa(Formak.ENEMY, posizioa);
        } else if (symbol == Formak.KEY.getSymbol()) {
            return new Estatikoa(Formak.KEY);
        } else if (symbol == Formak.DOOR.getSymbol()) {
            return new Estatikoa(Formak.DOOR);
        } else if (symbol == Formak.TREASURE.getSymbol()) {
            return new Altxorra(Formak.TREASURE, posizioa);
        } else if (symbol == Formak.PORTAL.getSymbol()) {
            return new Portal(Formak.PORTAL);
        }
        return null;
    }
}
