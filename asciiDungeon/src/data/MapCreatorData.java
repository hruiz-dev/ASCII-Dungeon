package data;

import render.GraficsConfig;
import render.Layers;

public class MapCreatorData {

    private static MapCreatorData mapCreatorData;
    private Layers map = new Layers(0, GraficsConfig.GAME_X_GRID_SIZE, GraficsConfig.GAME_Y_GRID_SIZE, GraficsConfig.GAME_X_CANVAS_SIZE, GraficsConfig.GAME_Y_CANVAS_SIZE);

    public Layers getMap() {
        return map;
    }

    public void setMap(Layers map) {
        this.map = map;
    }

    public static MapCreatorData getMapCreatorData(){
        if (mapCreatorData == null){
            mapCreatorData = new MapCreatorData();
        }
        return mapCreatorData;
    }
}
