package kalkuloak;

import data.GameObject;
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
                        map[j][i] = kargatuObjetua(line.charAt(j));
                }
                i++;
            }
        } catch (IOException e) {
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

    public static GameObject kargatuObjetua(char symbol) {
        if (symbol == Formak.WALL.getSymbol()) {
            return new Estatikoa(Formak.WALL);
        } else if (symbol == Formak.FLOOR.getSymbol()) {
            return new Estatikoa(Formak.FLOOR);
        }
        return null;
    }
}
