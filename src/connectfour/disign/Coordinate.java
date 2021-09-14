package connectfour.disign;

import java.util.Scanner;

public class Coordinate {
    public static final int X_SIZE = 4;
    public static final int Y_SIZE = 4;

    private Integer row;
    private Integer column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Coordinate() {}

    public boolean isNull() {
        return null != this.column && null != this.row;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getColumn() {
        return column;
    }

    public void read() {
        Scanner readScanner = new Scanner(System.in);
        System.out.println("Introduzca la fila y columna en la que desea poner la ficha(X,Y): ");
        this.row = readScanner.nextInt();
        this.column = readScanner.nextInt();

    }
}
