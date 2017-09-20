/*
 * Copyright 2017 the original author or authors.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package game;

public class GameBoard {

    public static final int ROWS = 8, COLS = 8;

    BoardPosition[][] board;

    public GameBoard(){
        board = new BoardPosition[ROWS][COLS]; //allocate array of boardpositions
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                board[i][j] = new BoardPosition(i, j, " "); //allocates each element
            }
        }
    }





    public boolean checkSpace (BoardPosition position){
            //returns true if the position specified in pos is available, false otherwise
        return(position == " ");

    }
    public void placeMarker (BoardPosition position){

        if(checkSpace(position))
            position.setMarker('x');

        //places the character in marker on the position specified by marker
    }
    public boolean checkForWinner(BoardPosition lastPos){
        //function will check to see if the lastPos placed resulted in a winner. returns true or false
    }

    private boolean checkHorzintalWin(BoardPosition lastPos){
        char char_to_check = lastPos.getMarker();

        for(int i = lastPos.getRow(); i < ; i++){ //if 5 horizontal positions are filled with the same letter its a win.
            int j = lastPos.getColumn();
        }

    }
    private boolean checkVerticalWin(BoardPosition lastPos){}
    private boolean checkDiagonalWin(BoardPosition lastPos){}

    public String toString() {
        String new_string;
        new_string = "|  |  |  |  |  |  |  |  |\n" + "|  |  |  |  |  |  |  |  |\n" + "|  |  |  |  |  |  |  |  |\n" + "|  |  |  |  |  |  |  |  |\n" + "|  |  |  |  |  |  |  |  |\n" + "|  |  |  |  |  |  |  |  |\n" + "|  |  |  |  |  |  |  |  |\n" + "|  |  |  |  |  |  |  |  |\n";
        return new_string;
    }
        //need to override the toString() method inherited from the object class. this will return one
    //string that shows the entire game board
    //you will then be able to call it in gamescreen.java to print it to the screen.
}
