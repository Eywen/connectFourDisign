package connectfour.disign;

import java.util.Scanner;

public class Coordinate {
    public static final int X_SIZE = 4;
    public static final int Y_SIZE = 4;
    public static final String NEXT_HORIZONTAL = "NH";
    public static final String NEXT_VERTICAL = "NV";
    public static final String PREVIOUS_HORIZONTAL = "PH";
    public static final String PREVIOUS_VERTICAL = "PV";
    public static final String ACTUAL = "ACTUAL";

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
        System.out.println("Introduzca la fila y columna en la que desea poner la ficha(X,Y). " );
        System.out.println("Tenga en cuenta poner la ficha en la parte mas baja libre del tablero. La parte mas baja del tablero es la fila : " + (X_SIZE-1) +
                ", la parte alta es la fila 0. Las columnas van de izquierda a derecha desde la 0 hasta la " + (Y_SIZE-1) + ": ");
        this.row = readScanner.nextInt();
        this.column = readScanner.nextInt();
    }
}
