import render.Graficos;

public class Main {
    public static void main(String[] args) {
     try {
         Graficos a = new Graficos();
         a.render();
     } catch (Exception e) {
         e.printStackTrace();
     }
    }
}
