package tabuleiro;

import tabuleiro.exception.BoardException;

public class Piece {
	
	protected Position position;
	private Board board;
	
	
	
	public Piece() {
	}
	public Piece(Board board) {
		if (board.equals(null)) {
			throw new BoardException("Board Exception :: Board was not found");
		}
		this.board = board;
	}
	
	
	
	protected Board getBoard() {
		return this.board;
	}
	
}
