package connectfour.disign;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Board {

    private static final int NUM_TOKEN_WINNER = 4;
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
        int i = 0;
        boolean winner = false;
        for (Map.Entry<String, Coordinate> coordinateentrySet : colorAdjacentMap.entrySet()) {
            assert null == coordinateentrySet.getKey();
            if (coordinateentrySet.getKey().equals(Coordinate.NEXT_HORIZONTAL) && coordinateentrySet.getValue().getColumn() < Coordinate.Y_SIZE) {
                winner =  verifyHorizontalNextWinner(coordinateentrySet.getValue(), activeColor);
            } else  if (coordinateentrySet.getKey().equals(Coordinate.PREVIOUS_HORIZONTAL) && coordinateentrySet.getValue().getColumn() >= 0) {
                winner = verifyHorizontalPreviousWinner(coordinateentrySet.getValue(),activeColor);
            }
        }
        return winner;
    }

    private boolean verifyHorizontalNextWinner(Coordinate coordinate, Color activeColor) {
        int numTokensWinner = 1;
        while (numTokensWinner < NUM_TOKEN_WINNER) {
            if (this.getColor(coordinate).equals(activeColor)) {
                coordinate = coordinate.getNextHorizontalCoordinate(this.getColor(coordinate));
            } else return false;
            numTokensWinner++;
        }
        return true;
    }
     private boolean verifyHorizontalPreviousWinner(Coordinate coordinate, Color activeColor) {
        int numTokensWinner = 3;
        while (numTokensWinner > 0) {
            if (this.getColor(coordinate).equals(activeColor)) {
                coordinate = coordinate.getPreviosHorizontalCoordinate(this.getColor(coordinate));
            } else return false;
            numTokensWinner --;
        }
        return true;
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
