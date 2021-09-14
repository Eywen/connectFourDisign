package connectfour.disign;

public class Turn {

    static final int NUMBER_PLAYERS = 2;
    private Board board;
    private Player[] players;
    private int activePlayer;

    public Turn(Board board) {
        assert null != board;
        this.board = board;
        this.players = new Player[NUMBER_PLAYERS];
        this.inicializePlayer();
    }

    void inicializePlayer() {
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            this.players[i] = new Player(this.board, Color.getColor(i));
        }
        this.activePlayer = 0;
    }

    public void play() {
        players[activePlayer].play();
        //si no es fin de juego activo el sgt jugador
       /* if (!this.board.isTicTacToe(this.getActiveColor())){
            this.activePlayer = (this.activePlayer+1) % Turn.NUMBER_PLAYERS;
        }*/
    }

   /* void writeWinner(){
        this.players[this.activePlayer].writeWinner();
    }*/

    /*Color getActiveColor() {
        return this.players[this.activePlayer].getColor();
    }*/
}
