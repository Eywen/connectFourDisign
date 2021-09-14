package connectfour.disign;

import com.sun.scenario.effect.impl.state.RenderState;

public class Board {

    private Color[][] colors;
   // private Coordinate coordinate;

    public Board() {
        //colors = new Color[coordinate.X_SIZE][coordinate.Y_SIZE];
        //inicializar el tablero
        for (int i = 0; i<Coordinate.Y_SIZE; i++){
            for (int j = 0; i<Coordinate.X_SIZE; j++){
                colors[i][j] = null;
            }
        }
    }

    public void paint() {        
        // escribimos linea horizontal Message.HORIZONTAL_LINE.writeln();
        for (int i = 0; i < Coordinate.X_SIZE; i++) {
            // escribimos linea vertical Message.VERTICAL_LINE.write();
            for (int j = 0; j < Coordinate.Y_SIZE; j++) {
                this.getColor(new Coordinate(i, j)).write();
                //Message.VERTICAL_LINE.write();
            }
            //Console.getInstance().writeln();
        }
       // Message.HORIZONTAL_LINE.writeln();
    }

    private Color getColor(Coordinate coordinate) {
        assert !coordinate.isNull();
        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    public boolean isConnect4() {
        
    }
}
