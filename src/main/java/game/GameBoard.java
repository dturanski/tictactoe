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

	public GameBoard() {
		board = new char[ROWS][COLS]; //allocate array of boardpositions
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				board[i][j] = BoardPosition.EMPTY; //allocates each element
			}
		}
	}

	public boolean checkSpace(BoardPosition position) {
		//returns true if the position specified in pos is available, false otherwise
		return (board[position.getRow()][position.getColumn()] == BoardPosition.EMPTY);

	}

	/**
	 * Places the character in marker on the position specified by marker.
	 *
	 * @param position the {@link BoardPosition}
	 */
	public void placeMarker(BoardPosition position) {

		if (checkSpace(position)) {
			board[position.getRow()][position.getColumn()] = position.getMarker();
		}
	}

	public boolean checkForWinner(BoardPosition lastPos) {
		//function will check to see if the lastPos placed resulted in a winner. returns true or false
		return checkHorzintalWin(lastPos) || checkVerticalWin(lastPos) || checkDiagonalWin(lastPos);
	}

	private boolean checkHorzintalWin(BoardPosition lastPos) {
		// lastPos is counted twice
		return count(lastPos, 0, 1) + count(lastPos, 0, -1) > COUNT_FOR_WIN;

	}

	private boolean checkVerticalWin(BoardPosition lastPos) {
		// lastPos is counted twice
		return count(lastPos, 1, 0) + count(lastPos, -1, 0) > COUNT_FOR_WIN;
	}

	private boolean checkDiagonalWin(BoardPosition lastPos) {
		return false;
	}

	private int count(BoardPosition position, int rowStep, int colStep) {
		int row = position.getRow();
		int col = position.getColumn();
		int count = 0;
		while (row < GameBoard.ROWS && row >= 0 && col < GameBoard.COLS && col >= 0 && board[row][col] == position
			.getMarker()) {
			count++;
			row = row + rowStep;
			col = col + colStep;

		}
		return count;
	}

	//need to override the toString() method inherited from the object class. this will return one
	//string that shows the entire game board
	//you will then be able to call it in gamescreen.java to print it to the screen.
	@Override
	public String toString() {
		String result = "   0 1 2 3 4 5 6 7\n";
		for (int row = 0; row < ROWS; row++) {
			result += row + " |";
			for (int col = 0; col < COLS; col++) {
				result += (board[row][col] + "|");
			}
			result += "\n";
		}

		return result;
	}

}
