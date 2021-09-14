package connectfour.disign;

import java.util.Scanner;

public class Player {

    private Board board;
    private Color color;
    private int indexToken;

    public Player(Board board, Color color) {
        this.board = board;
        this.color = color;
        this.indexToken = 0;
    }

    public void play() {
        Coordinate coordinate;
        coordinate = this.getCoordinate();
        boolean tokenError = board.verifyCoordinate(coordinate);
        if (tokenError)
            coordinate.reload();
        //Error error;
        /*do {
            coordinate = this.getCoordinate(Message.ENTER_COORDINATE_TO_PUT);
            error = this.getPutTokenError(coordinate);
        } while (!error.isNull());*/
        this.board.setToken(coordinate, this.color);
        this.indexToken++;
    }

    private Coordinate getCoordinate(){
        //assert message != null;
        Coordinate coordinate = new Coordinate();
        coordinate.read();
        //coordinate.read(message.toString());
        return coordinate;
    }


}
