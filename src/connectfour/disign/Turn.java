package connectfour.disign;

public class Turn {

    static final int NUMBER_PLAYERS = 2;
    private Board board;
    private Player[] players;
    private int activePlayer;

    public Turn(Board board) {

        this.board = board;
        players = new Player[NUMBER_PLAYERS];
    }

    public void play() {

    }
}
