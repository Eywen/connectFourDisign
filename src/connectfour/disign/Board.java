package connectfour.disign;

import com.sun.scenario.effect.impl.state.RenderState;

public class Board {

    private Color[][] colors;
    private Coordinate coordinate;

    public Board() {
        //inicializar el tablero
        for (int i = 0; i<coordinate.Y_SIZE; i++){
            for (int j = 0; i<coordinate.X_SIZE; j++){
                colors[i][j] = null;
            }
        }
    }

    public void paint() {
        //colors = new Color[coordinate.X_SIZE][coordinate.Y_SIZE];

    }


}
