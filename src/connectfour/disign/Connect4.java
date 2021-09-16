package connectfour.disign;

public class Connect4 {

    private Board board;
    private Turn turn;

    public Connect4 (){
        this.board = new Board();
        this.turn = new Turn (this.board);
    }

    private void play (){
        do{
            board.paint();
            turn.play();
        } while (!this.connect4());
        board.paint();
        System.out.println("¡Ganador el Jugador de color :" + turn.getActiveColor() + "!");
    }

    private boolean connect4() {
        boolean connect4 = board.isConnect4(this.turn);
        this.activeNextPlayer(connect4);
        return connect4;
    }

    private void activeNextPlayer(boolean connect4){
        if (!connect4)
            turn.activeNextPlayer();
    }

    public static void main (String[] arg){

        new Connect4().play();
        System.out.println("Game finished :) !");
    }
}
