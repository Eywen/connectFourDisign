package connectfour.disign;

public class Turn {

    static final int NUMBER_PLAYERS = 2;
    private Board board;
    private Player[] players;
    private int activePlayer;

    public Turn(Board board) {
        assert null != board;
        this.board = board;
        players = new Player[NUMBER_PLAYERS];
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
