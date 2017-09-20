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

    public static final int ROWS = 8, COLS = 8, COUNT_FOR_WIN = 5;

    char[][] board;

    public GameBoard(){
        board = new char[ROWS][COLS]; //allocate array of boardpositions
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                board[i][j] =  BoardPosition.EMPTY; //allocates each element
            }
        }
    }


    public boolean checkSpace (BoardPosition position){
            //returns true if the position specified in pos is available, false otherwise
        return(board[position.getRow()][position.getColumn()] == BoardPosition.EMPTY);

    }

    /**
     *  Places the character in marker on the position specified by marker.
     * @param position the {@link BoardPosition}
     */
    public void placeMarker (BoardPosition position){

        if(checkSpace(position)){
            board[position.getRow()][position.getColumn()] = position.getMarker();
        }
    }

    public boolean checkForWinner(BoardPosition lastPos){
        //function will check to see if the lastPos placed resulted in a winner. returns true or false
        return checkHorzintalWin(lastPos) || checkVerticalWin(lastPos) || checkDiagonalWin(lastPos);
    }

    private boolean checkHorzintalWin(BoardPosition lastPos){
        System.out.println("checking horizontal " + lastPos);
        int row = lastPos.getRow();
        char marker = lastPos.getMarker();
        int count = 0;
        for (int i = 0; i < COLS; i++) {
            System.out.println(String.format("checking position %d, %d, %s ", row,i, board[row][i]));
            if (board[row][i] == marker) {
                count ++;
            }
            else {
                if (count < COUNT_FOR_WIN) {
                    count = 0;
                }
            }
        }
        return count >= COUNT_FOR_WIN;

    }
    private boolean checkVerticalWin(BoardPosition lastPos){
        System.out.println("checking vertical " + lastPos);
        int col = lastPos.getColumn();
        char marker = lastPos.getMarker();
        int count = 0;
        for (int i = 0; i < ROWS; i++) {
            System.out.println(String.format("checking position %d, %d, %s ", i,col, board[i][col]));
            if (board[i][col] == marker) {
                count ++;
            }
            else {
                if (count < COUNT_FOR_WIN) {
                    count = 0;
                }
            }
        }
        return count >= COUNT_FOR_WIN;

    }
    private boolean checkDiagonalWin(BoardPosition lastPos){
        return false;
    }

    @Override
    public String toString() {
        String new_string;
        new_string =
            "|  |  |  |  |  |  |  |  |\n" +
            "|  |  |  |  |  |  |  |  |\n" +
                "|  |  |  |  |  |  |  |  |\n" +
                "|  |  |  |  |  |  |  |  |\n" +
                "|  |  |  |  |  |  |  |  |\n" +
                "|  |  |  |  |  |  |  |  |\n" +
                "|  |  |  |  |  |  |  |  |\n" +
                "|  |  |  |  |  |  |  |  |\n";
        return new_string;
    }
    //need to override the toString() method inherited from the object class. this will return one
    //string that shows the entire game board
    //you will then be able to call it in gamescreen.java to print it to the screen.
}
