#JAVA #Proiektua
## Primer Dia 16/04/2024

### Parte 1 Testing de concepto y planificacion

Primero he utilizando draw io he echo un esquema uml de mi proyecto java

![Eskemaren irudia](./imagenes/asciiDungeon.png)

En este esquema he pensado en un "motor de videjuegos" que funciona en base a una matriz de dos dimensiones ya que el juego que haremos solo tine dos dimensiones.

Despues de hacer un esquema he hecho pruebas de como puedo pintar pixeles en un JFrame en java, haciendo test al final me a quedado este codigo:

```java
import javax.swing.*;
import java.awt.*;

public class ConceptTest {
    private static final int X_CANVAS_SIZE = 1056;
    private static final int Y_CANVAS_SIZE = 720;
    private static final int X_GRID_SIZE = 66;
    private static final int Y_GRID_SIZE = 45;
    private static final int CELL_SIZE = 16;

    private int[][] matrix = new int[X_GRID_SIZE][Y_GRID_SIZE];
    private JPanel panel;

    private JFrame frame;

    public ConceptTest() {
        frame = new JFrame();
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < X_GRID_SIZE; i++) {
                    for (int j = 0; j < Y_GRID_SIZE; j++) {
                        int x = i * CELL_SIZE;
                        int y = j * CELL_SIZE;
                        if (matrix[i][j] == 1) {
                            g.setColor(Color.BLACK);
                            g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                        } else {
                            g.setColor(Color.WHITE);
                            g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                        }
                    }
                }
            }
        };
        panel.setPreferredSize(new Dimension(X_CANVAS_SIZE, Y_CANVAS_SIZE));
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        for (int i = 0; i < X_GRID_SIZE; i++) {
            for (int j = 0; j < 25; j++) {
                matrix[i][j] = 1;
            }
        }
    }

    public void render() {
        panel.repaint();
    }

    public void updateMatrix(int[][] newMatrix) {
        this.matrix = newMatrix;
        render();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConceptTest a = new ConceptTest();
            a.render();
        });
    }
}

```

#### Varibles

Esta clase primero tiene las siguientes constates y variables para poder definir nuestra venta:
- X_CANVAS_SIZE: en esta constante definimos lo ancho que queremos que sea nuestra interfaz del juego.

- Y_CANVAS_SIZE: en esta constante definiremos lo alto que queremos que sea nuestra interfaz.

- X_GRID_SIZE : en esta constate definiremos cuantos "cuadrados" de ancho queremos que sea nuestro interfaz.

- Y_GRID_SIZE: en esta constate definiremos cuantos "cuadrados" de alto queremos que sea nuestra interfaz.

- CELL_SIZE: en esta constante definiremos cuanto ocupa cada "cuadrado" en la intefaz.

- matrix : esta sera la matriz encargada de manejar el juego, en esta guardaremos la posicion de todos los objetos dentro del juego, este tendrá como tamaño los valores de la altura y anchura maxima que hemos definido antes luego explícare mas en detalle como funcionara.

- panel: este es el panel que mostrara todos los datos del juego.

#### Sistema de Matriz bidimensional

Como he mencionado antes en este caso voy a utilizar u sistema basado en una matriz para poder guardar los datos sobre la partida, en este caso tenemos una matriz de 66x45 que corresponde al x16 de nuestro panel, por eso cada posicion de la matriz ocupara un espacio de 16x16 picxeles en nuestro panel.

Este sistema podeis modificarlo cambiando los valores de la constaten a vuestro gusto, por ejemplo si quereis que cada posicion el la matriz corresponda a 8x8 pixeles tendrias que cambiar el CELL_SIZE a 8 y duplicar los valores X_GRID_SIZE e Y_GRID_SIZE ya que si haceis 90x8 os da 720 que en este caso seria la altura del panel.

```java
    private static final int X_CANVAS_SIZE = 1056;
    private static final int Y_CANVAS_SIZE = 720;
    private static final int X_GRID_SIZE = 122;
    private static final int Y_GRID_SIZE = 90;
    private static final int CELL_SIZE = 8;
```

#### Renderizado del juego

Siguendo con la aplicacion segiremos con el panel donde cambiaremos su metodo paintComponent, este metodo se encarga de pintar el panel pero en nuestro caso lo canbiaremos por un for anidado que este recorrera cada poscion de la matrix en este caso si la posicion corresponde al valor 1 el "cuadrado" se pintara de negro si no de blanco.

```java
panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < X_GRID_SIZE; i++) {
                    for (int j = 0; j < Y_GRID_SIZE; j++) {
                        int x = i * CELL_SIZE;
                        int y = j * CELL_SIZE;
                        if (matrix[i][j] == 1) {
                            g.setColor(Color.BLACK);
                            g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                        } else {
                            g.setColor(Color.WHITE);
                            g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                        }
                    }
                }
            }
        };
```

luego tenemos los metodo render y updatematrix, el primero le llama a la funcion modificada del panel el repaint y el segundo recive como argumeto una matriz modificada y este se intercambia por la vieja matriz y repinta el panel.

Al final en el metodo main pondremos esto:

```java
public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConceptTest a = new ConceptTest();
            a.render();
        });
    }
```

Este codigo se ejecuta en un trhead especial que se utiliza para renderizar objetos de java Swing, en esta primero crearemos un uevo objeto de este tipo y ejecutaremos la funcion render.

#### Testing de la aplicacion

En este test para poder probar si el render funcionaba bien en el contructo he añadido un for para llenar de numeros la matriz, donde el numero de segundo for es la funcion :

```java
for (int i = 0; i < X_GRID_SIZE; i++) {
            for (int j = 0; j < 25; j++) {
                matrix[i][j] = 1;
            }
        }
```

Si lo habeis hecho bien os deveria de aparecer Un panel con la mita de los pixeles en negro

![Imagen de test terminado](./imagenes/paneTest.png)


### Parte 2 Sistema de renderizado de Sprites
