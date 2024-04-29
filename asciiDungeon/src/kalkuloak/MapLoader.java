package kalkuloak;

import data.GameObject;
import data.Vector2;
import data.exceptions.GameLogicException;
import data.interactive.Jokalaria;
import data.interactive.Monstroa;
import data.noInteractive.Estatikoa;
import data.noInteractive.Formak;
import render.GraficsConfig;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MapLoader {

    public static GameObject[][] kargatuBackground(String fileName) {
        String path = "assets/mapak/" + fileName;
        GameObject[][] map = new GameObject[GraficsConfig.GAME_X_GRID_SIZE][GraficsConfig.GAME_Y_GRID_SIZE];

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            int i = 0;
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
        // testak egiteko
        for (int i = 0; i < map[0].length -1; i++) {
            for (int j = 0; j < map.length -1; j++) {
                if (map[j][i] != null) {
                    System.out.print(map[j][i].getForma().getSymbol());
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();

        }

        return map;
    }

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
            return new Estatikoa(Formak.TREASURE);
        }
        return null;
    }
}
