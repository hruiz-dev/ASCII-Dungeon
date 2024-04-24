package kalkuloak;

import data.interactive.MapCreator;
import render.GraficsConfig;
import render.Layers;

import java.io.FileWriter;
import java.io.IOException;

public class MapCreatorMain { ;
    private static MapCreatorMain mapCreatorMain;
    private Layers background = new Layers(0, GraficsConfig.GAME_X_GRID_SIZE, GraficsConfig.GAME_Y_GRID_SIZE, GraficsConfig.GAME_X_CANVAS_SIZE, GraficsConfig.GAME_Y_CANVAS_SIZE);
    private Layers interactables = new Layers(1, GraficsConfig.GAME_X_GRID_SIZE, GraficsConfig.GAME_Y_GRID_SIZE, GraficsConfig.GAME_X_CANVAS_SIZE, GraficsConfig.GAME_Y_CANVAS_SIZE);
    public Layers getMap() {
        return background;
    }

    public void setMap(Layers map) {
        this.background = map;
    }

    public Layers getInteractables() {
        return interactables;
    }

    public void setInteractables(Layers interactables) {
        this.interactables = interactables;
    }

    public static MapCreatorMain getMapCreatorData(){
        if (mapCreatorMain == null){
            mapCreatorMain = new MapCreatorMain();
        }
        return mapCreatorMain;
    }

    private MapCreatorMain(){
    }

    public void init(){
        background.getMatrix()[0][0] = MapCreator.getJokalaria();
        new Thread(this::update).start();
        new Thread(this::render).start();
    }

    public void update(){

       while (true){
           if (MapCreator.getJokalaria().getIntereactive()){
               interactables.updateMatrix(MapCreator.getJokalaria().update());
           } else {
               background.updateMatrix(MapCreator.getJokalaria().update());
           }
       }
    }

    public void render(){
        while (true){
            background.render();
            interactables.render();
        }
    }

    public void stop() {
//TODO
        String s1 = "";
        String s2 = "";
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < GraficsConfig.GAME_Y_GRID_SIZE; j++) {
            for (int i = 0; i < GraficsConfig.GAME_X_GRID_SIZE; i++) {
                if (background.getMatrix()[i][j] != null) {
                    sb.append(background.getMatrix()[i][j].toString());
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        s1 = sb.toString();

        sb = new StringBuilder();

        for (int i = 0; i < GraficsConfig.GAME_Y_GRID_SIZE; i++) {
            for (int j = 0; j < GraficsConfig.GAME_X_GRID_SIZE; j++) {
                if (interactables.getMatrix()[j][i] != null) {
                    sb.append(interactables.getMatrix()[i][j].toString());
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        s2 = sb.toString();

        try (FileWriter file = new FileWriter("map1Background.txt")) {
            file.write(s1);
            System.out.println("Mapako Backgrounda gordeta");
            file.close();

            FileWriter file2 = new FileWriter("map1Interactable.txt");
            file2.write(s2);
            System.out.println("Mapako kapa interaktiboak gordeta");
            file2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.exit(0);

    }


}
