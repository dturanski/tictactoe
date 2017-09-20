package game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Random;

public class GameboardTest {
	@Test
	public void initialState() {
		GameBoard board = new GameBoard();
		for (int row = 0; row < GameBoard.ROWS; row++) {
			for (int col = 0; col < GameBoard.COLS; col++) {
				assertTrue(board.checkSpace(new BoardPosition(row, col, BoardPosition.X)));
			}
		}
	}

	@Test
	public void placeMarker() {
		GameBoard board = new GameBoard();
		BoardPosition position = new BoardPosition(0, 0, BoardPosition.X);
		board.placeMarker(position);
		assertFalse(board.checkSpace(position));
	}

	@Test
	public void checkForWinnerHorizontal() {
		GameBoard board = new GameBoard();
		Random random = new Random();
		int row = random.nextInt(GameBoard.ROWS);
		int startCol = random.nextInt(GameBoard.COLS - GameBoard.COUNT_FOR_WIN);

		for (int col = startCol; col < startCol + GameBoard.COUNT_FOR_WIN; col++) {
			board.placeMarker(new BoardPosition(row, col, BoardPosition.X));
		}
		assertTrue(board.checkForWinner(new BoardPosition(row, startCol + GameBoard.COUNT_FOR_WIN, BoardPosition.X)));
	}

	@Test
	public void checkForWinnerVertical() {
		GameBoard board = new GameBoard();
		Random random = new Random();
		int col = random.nextInt(GameBoard.COLS);
		int startRow = random.nextInt(GameBoard.ROWS - GameBoard.COUNT_FOR_WIN);

		for (int row = startRow; row < startRow + GameBoard.COUNT_FOR_WIN; row++) {
			board.placeMarker(new BoardPosition(row, col, BoardPosition.O));
		}
		assertTrue(board.checkForWinner(new BoardPosition(startRow + GameBoard.COUNT_FOR_WIN, col, BoardPosition.O)));
	}

	@Test
	public void checkForWinnerDiagonal() {
		GameBoard board = new GameBoard();
		Random random = new Random();
		int startRow = random.nextInt(3);
		int startCol = random.nextInt(3);

		for (int row = startRow; row < startRow + GameBoard.COUNT_FOR_WIN; row++) {
			for (int col = startCol; col < startCol + GameBoard.COUNT_FOR_WIN; col++) {
				board.placeMarker(new BoardPosition(row, col, BoardPosition.O));
			}
		}
		assertTrue(board.checkForWinner(
			new BoardPosition(startRow + GameBoard.COUNT_FOR_WIN, startCol + GameBoard.COUNT_FOR_WIN,
				BoardPosition.O)));
	}
}
