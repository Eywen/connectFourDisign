package connectfour.disign;

import java.util.List;

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
        for (int i = 0; i < Coordinate.X_SIZE; i++) {
            for (int j = 0; j < Coordinate.Y_SIZE; j++) {
                this.getColor(new Coordinate(i, j)).write();
                System.out.print("  ");
            }
            System.out.println("");
        }
    }

    private Color getColor(Coordinate coordinate) {
        assert !coordinate.isNull();
        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    public boolean isConnect4(Turn turn) {
        assert !turn.getActiveColor().isNull();
        List<Color> colorAdjacentList = getadjacent(turn.getActiveColor());
        if (colorAdjacentList.isEmpty()){
            return false;
        } else{
            //turn.getActivePlayer().getActualCoordinate();
            Coordinate lastCoordinate = turn.getActiveColor().getlastCoordinate();
            if (verifyHorizontalWinner(lastCoordinate) || verifyVerticalWinner){
                return true;
            }
        }
        return false;
    }

    public void setToken(Coordinate coordinate, Color color) {
        assert !coordinate.isNull();
        this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
    }

    public boolean verifyCoordinate(Coordinate coordinate) {
        if (verifyCoordinate(coordinate.getRow(), Coordinate.X_SIZE) && verifyCoordinate(coordinate.getColumn(),Coordinate.Y_SIZE)
                && this.getColor(coordinate).equals(Color.NULL)){
            return verifyDownRow(coordinate);
        }else
            return false;
    }

    private boolean verifyCoordinate(Integer coordinateElem, int coordinateMax) {
        return ((coordinateElem > (coordinateMax - 1)) || (coordinateElem < 0)) ? false : true;
    }

    private boolean verifyDownRow(Coordinate coordinate) {
        if ((coordinate.getRow() != (Coordinate.X_SIZE - 1)) && (this.colors[coordinate.getRow()+1][coordinate.getColumn()].equals(Color.NULL)) ){
            return false;
        }
        return true;
    }
}
