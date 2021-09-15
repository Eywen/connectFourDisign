package connectfour.disign;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Coordinate> colorAdjacentMap = this.getadjacent(turn.getActiveColor());
        if (colorAdjacentMap.isEmpty()){
            return false;
        } else{
            if (this.verifyHorizontalWinner(colorAdjacentMap) || this.verifyVerticalWinner(colorAdjacentMap)){
                return true;
            }
        }
        return false;
    }

    private Map<String,Coordinate> getadjacent(Color color) {
        assert color.getlastCoordinate().getColumn() + 1 >= Coordinate.Y_SIZE;
        assert color.getlastCoordinate().getRow() + 1 >= Coordinate.X_SIZE;
        assert color.getlastCoordinate().getRow()-1 < 0;
        assert color.getlastCoordinate().getColumn()-1 < 0;
        Map<String,Coordinate> adjacentCoordinateMap = new HashMap<>();
        adjacentCoordinateMap.put(Coordinate.ACTUAL,new Coordinate(color.getlastCoordinate().getRow(), color.getlastCoordinate().getColumn()));
        adjacentCoordinateMap.put(Coordinate.NEXT_HORIZONTAL,new Coordinate(color.getlastCoordinate().getRow(), color.getlastCoordinate().getColumn() + 1));
        adjacentCoordinateMap.put(Coordinate.NEXT_VERTICAL,new Coordinate(color.getlastCoordinate().getRow()+1, color.getlastCoordinate().getColumn()));
        adjacentCoordinateMap.put(Coordinate.PREVIOUS_HORIZONTAL,new Coordinate(color.getlastCoordinate().getRow(), color.getlastCoordinate().getColumn()-1));
        adjacentCoordinateMap.put(Coordinate.PREVIOUS_VERTICAL,new Coordinate(color.getlastCoordinate().getRow()-1, color.getlastCoordinate().getColumn()));
        return adjacentCoordinateMap;
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
