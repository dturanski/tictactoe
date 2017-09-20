package game;

//For every Board Position we will either have a space, X, or O
public class BoardPosition {

    public static char X = 'X';
    public static char O = 'O';
    public static char EMPTY = ' ';
    private int row;
    private int col;
    private char marker;


    public BoardPosition(int row, int col, char marker){
        this.row = row;
        this.col = col;
        this.marker= marker;
    }

    /**@requires [row_pos has a value]
    **@ensures getRow = row_pos;
    */
    public int getRow(){
        return row;
    }

    /**@requires [col has a value]
     * @ensures getColumn = col;
     * @return
     */
    public int getColumn(){
        return col;
    }

    /**@requires [marker == x || marker == o]
     * @ensures getMarker = marker
     * @return
     */
    public char getMarker(){
        return marker;
    }

    @Override
    public String toString(){
        return String.format("row: %s, col: %s, marker: %s",row,col,marker);
    }
}


