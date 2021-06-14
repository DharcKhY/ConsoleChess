package tabuleiro;

import tabuleiro.exception.BoardException;

public abstract class Piece {
	
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
	
	
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMoves(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	
	
	public boolean isMovable() {
		boolean[][] moves = possibleMoves();
		for (int x = 0; x < moves.length; x++) {
			for (int y = 0; y < moves[x].length; y++) {
				if (moves[x][y]) {
					return true;
				}
			}
		}
		return false;
	}
	
	
}
