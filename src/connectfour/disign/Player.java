package connectfour.disign;

import java.util.Scanner;

public class Player {

    private Board board;
    private Color color;
    private int indexToken;
    private Coordinate actualCoordinate;

    public Player(Board board, Color color) {
        this.board = board;
        this.color = color;
        this.indexToken = 0;
    }

    public void play() {
        Coordinate coordinate;
        boolean tokenOk;
        do {
            coordinate = this.getCoordinate();
            tokenOk = board.verifyCoordinate(coordinate);
        } while (!tokenOk);
        this.board.setToken(coordinate, this.color);
        this.actualCoordinate = coordinate;
        this.color.setCoordinate(coordinate);
        this.indexToken++;
    }

    private Coordinate getCoordinate(){
        //assert message != null;
        Coordinate coordinate = new Coordinate();
        coordinate.read();
        //coordinate.read(message.toString());
        return coordinate;
    }

    public Coordinate getActualCoordinate(){
        return  this.actualCoordinate;
    }

    public Color getColor() {
        return  this.color;
    }
}
