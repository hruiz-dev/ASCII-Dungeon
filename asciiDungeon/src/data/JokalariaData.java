package data;

import data.interactive.Arma;
import data.interactive.Armadura;
import data.noInteractive.Formak;

public class JokalariaData {

    private static int bizia;
    private static int dirua = 0;
    private static int giltzak;

    private static char azkenZapaldutakoTekla;
    private static char azkenMugimendua;

    private static Arma arma = new Arma(Formak.FLOOR, "Ezpata", 0, 3);
    private static Armadura armadura = new Armadura(Formak.SHIELD3 , "Armadura", 0, 10);

    public static int getBizia() {
        return bizia;
    }

    public static void setBizia(int bizia) {
        JokalariaData.bizia = bizia;
    }

    public static int getDirua() {
        return dirua;
    }

    public static void setDirua(int puntuazioa) {
        JokalariaData.dirua = puntuazioa;
    }

    public static void addDirua(int puntuazioa) {
        JokalariaData.dirua += puntuazioa;
    }

    public static int getGiltzak() {
        return giltzak;
    }

    public static void setGiltzak(int giltzak) {
        JokalariaData.giltzak = giltzak;
    }

    public static char getAzkenZapaldutakoTekla() {
        return azkenZapaldutakoTekla;
    }

    public static void setAzkenZapaldutakoTekla(char azkenZapaldutakoTekla) {
        JokalariaData.azkenZapaldutakoTekla = azkenZapaldutakoTekla;
    }

    public static char getAzkenMugimendua() {
        return azkenMugimendua;
    }

    public static void setAzkenMugimendua(char azkenMugimendua) {
        JokalariaData.azkenMugimendua = azkenMugimendua;
    }

    public static Arma getArma() {
        return arma;
    }

    public static void setArma(Arma arma) {
        JokalariaData.arma = arma;
    }

    public static Armadura getArmadura() {
        return armadura;
    }

    public static void setArmadura(Armadura armadura) {
        JokalariaData.armadura = armadura;
    }
}
