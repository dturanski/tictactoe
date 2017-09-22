package game;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Random;

public class GameboardTest {
	@Test
	public void initialState() {
		GameBoard board = new GameBoard();
		System.out.println(board);
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
		for (int i = 0; i < 1000; i++) {
			GameBoard board = new GameBoard();
			Random random = new Random();
			int row = random.nextInt(GameBoard.ROWS);
			int startCol = random.nextInt(GameBoard.COLS - GameBoard.COUNT_FOR_WIN);
			BoardPosition lastPos = null;
			for (int col = startCol; col < startCol + GameBoard.COUNT_FOR_WIN; col++) {
				lastPos = new BoardPosition(row, col, BoardPosition.O);
				board.placeMarker(lastPos);
			}
			try {
				row = lastPos.getRow();
				int col = lastPos.getColumn();
				for (int j = 0; j < GameBoard.COUNT_FOR_WIN; j++) {
					BoardPosition position = new BoardPosition(lastPos.getRow(), col--, lastPos.getMarker());
					assertTrue(board.checkForWinner(position));
				}
			}
			catch (Throwable t) {
				System.out.println(board);
				fail();

			}
		}
	}

	@Test
	public void checkForWinnerVertical() {
		for (int i = 0; i < 1000; i++) {
			GameBoard board = new GameBoard();
			Random random = new Random();
			int col = random.nextInt(GameBoard.COLS);
			int startRow = random.nextInt(GameBoard.ROWS - GameBoard.COUNT_FOR_WIN);
			BoardPosition lastPos = null;

			for (int row = startRow; row < startRow + GameBoard.COUNT_FOR_WIN; row++) {
				lastPos = new BoardPosition(row, col, BoardPosition.O);
				board.placeMarker(lastPos);
			}

			try {
				int row = lastPos.getRow();
				for (int j = 0; j < GameBoard.COUNT_FOR_WIN; j++) {
					BoardPosition position = new BoardPosition(row--, lastPos.getColumn(), lastPos.getMarker());
					assertTrue(board.checkForWinner(position));
				}
			}
			catch (Throwable t) {
				System.out.println(board);
				fail();
			}
		}
	}

	@Test
	public void checkForWinnerDiagonalUpAndRight() {
		for (int i = 0; i < 1000; i++) {
			GameBoard board = new GameBoard();
			Random random = new Random();
			int startRow = GameBoard.ROWS - 1 - random.nextInt(4);
			int startCol = random.nextInt(3);
			BoardPosition lastPos = null;

			int col = startCol;
			for (int row = startRow; row > startRow - GameBoard.COUNT_FOR_WIN; row--) {
				lastPos = new BoardPosition(row, col, BoardPosition.O);
				board.placeMarker(lastPos);
				col++;
			}
			try {
				int row = lastPos.getRow();
				col = lastPos.getColumn();
				for (int j = 0; j < GameBoard.COUNT_FOR_WIN; j++) {
					BoardPosition position = new BoardPosition(row++, col--, lastPos.getMarker());
					assertTrue(board.checkForWinner(position));
				}
			}
			catch (Throwable t) {
				System.out.println(board);
				fail();
			}

		}
	}

	@Test
	public void checkForWinnerDiagonalDownAndRight() {
		for (int i = 0; i < 1000; i++) {
			GameBoard board = new GameBoard();
			Random random = new Random();
			int startRow = random.nextInt(4);
			int startCol = random.nextInt(4);
			BoardPosition lastPos = null;

			int col = startCol;
			for (int row = startRow; row < startRow + GameBoard.COUNT_FOR_WIN; row++) {
				lastPos = new BoardPosition(row, col, BoardPosition.O);
				board.placeMarker(lastPos);
				col++;
			}
			try {
				int row = lastPos.getRow();
				col = lastPos.getColumn();
				for (int j = 0; j < GameBoard.COUNT_FOR_WIN; j++) {
					BoardPosition position = new BoardPosition(row--, col--, lastPos.getMarker());
					assertTrue(board.checkForWinner(position));
				}

			}
			catch (Throwable t) {
				System.out.println(board);
				fail();
			}

		}
	}
}
