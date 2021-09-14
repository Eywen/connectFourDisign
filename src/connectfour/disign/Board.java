package connectfour.disign;

import com.sun.scenario.effect.impl.state.RenderState;

public class Board {

    private Color[][] colors;
   // private Coordinate coordinate;

    public Board() {
        this.colors = new Color[Coordinate.X_SIZE][Coordinate.Y_SIZE];       
        this.boardInicialize();
    }

    private void boardInicialize () {
        for (int i = 0; i < Coordinate.Y_SIZE; i++) {
            for (int j = 0; j < Coordinate.X_SIZE; j++) {
                this.colors[i][j] = Color.NULL;
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
                System.out.print("  ");
            }
            System.out.println("");
            //Console.getInstance().writeln();
        }
       // Message.HORIZONTAL_LINE.writeln();
    }

    private Color getColor(Coordinate coordinate) {
        assert !coordinate.isNull();
        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    public boolean isConnect4() {

        return false;
    }

    public void setToken(Coordinate coordinate, Color color) {
        assert !coordinate.isNull();
        this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
    }
}
