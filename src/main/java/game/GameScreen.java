import com.company.GameBoard;

public class GameScreen { //gets user input and sends it to gameboard.java

    private GameBoard board;
    private boolean game_won = false;


    public static final int ROWS = 8, COLS = 8;
    public static int[][] board = new int[ROWS][COLS];

    boolean x_won, y_won, draw;

    public static void main(){
        createGame();

    }

    public static void createGame(){
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                board[i][j] = 0;
            }
        }
    }


}
