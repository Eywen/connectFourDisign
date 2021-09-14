package connectfour.disign;

public class Connect4 {

    private Board board;
    private Turn turn;

    public Connect4 (){
        this.board = new Board();
        this.turn = new Turn (this.board);
    }

    private void play (){
        //escribir la parte inicial de la partida
        do{
            board.paint();
            turn.play();
        } while (!connect4());

        //escribir estado final de la partida, turno ganador si lo hay
    }

    private boolean connect4() {
        return board.isConnect4();
    }

    public static void main (String[] arg){

        new Connect4().play();
        System.out.println("Game finished :) !");
    }
}
