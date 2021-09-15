package connectfour.disign;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        Map<String, Coordinate> coordinateAdjacentMap = this.getadjacent(turn.getActiveColor());
        if (coordinateAdjacentMap.isEmpty()){
            return false;
        } else{
            if (this.verifyWinner(coordinateAdjacentMap,turn.getActiveColor())){
                return true;
            }
        }
        return false;
    }

    private boolean verifyWinner(Map<String, Coordinate> colorAdjacentMap, Color activeColor) {

        for (Map.Entry<String, Coordinate> coordinateentrySet : colorAdjacentMap.entrySet()) {
            if (null != coordinateentrySet.getKey()){
                String coordinateKey = coordinateentrySet.getKey();
                Coordinate coordinate = coordinateentrySet.getValue();
                verifyHorizontalWinner(coordinateentrySet.getKey(),coordinateentrySet.getValue(),activeColor);
                verificar vertical
            }

        }
    }

    private void verifyHorizontalWinner(String direction, Coordinate coordinate, Color activeColor) {
        if (direction.equals(Coordinate.NEXT_HORIZONTAL)){
            for (1 a 4 ){
                if (this.getColor(coordinate).equals(activeColor)) {
                    coordinate.getNextHorizontalCoordinate(activeColor)
                }
            }
        }else if (direction.equals(Coordinate.PREVIOUS_HORIZONTAL)){

        }
    }

    private Map<String,Coordinate> getadjacent(Color color) {
        assert color.getlastCoordinate().getColumn() + 1 >= Coordinate.Y_SIZE;
        assert color.getlastCoordinate().getRow() + 1 >= Coordinate.X_SIZE;
        assert color.getlastCoordinate().getRow()-1 < 0;
        assert color.getlastCoordinate().getColumn()-1 < 0;
        Map<String,Coordinate> adjacentCoordinateMap = new HashMap<>();
        Coordinate actualCoordinate = new Coordinate(color.getlastCoordinate().getRow(), color.getlastCoordinate().getColumn());
        adjacentCoordinateMap.put(Coordinate.ACTUAL,actualCoordinate);
        adjacentCoordinateMap.put(Coordinate.NEXT_HORIZONTAL, actualCoordinate.getNextHorizontalCoordinate(color));
        adjacentCoordinateMap.put(Coordinate.NEXT_VERTICAL, actualCoordinate.getNextVerticalCoordinate(color));
        adjacentCoordinateMap.put(Coordinate.PREVIOUS_HORIZONTAL, actualCoordinate.getPreviosHorizontalCoordinate(color));
        adjacentCoordinateMap.put(Coordinate.PREVIOUS_VERTICAL, actualCoordinate.getPreviosVerticalCoordinate(color));
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
