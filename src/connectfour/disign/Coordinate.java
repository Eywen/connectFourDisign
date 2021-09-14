package connectfour.disign;

public class Coordinate {
    public static final int X_SIZE = 4;
    public static final int Y_SIZE = 4;

    private Integer row;
    private Integer column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean isNull() {
        return null != this.column && null != this.row;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getColumn() {
        return column;
    }
}
