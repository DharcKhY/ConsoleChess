package tabuleiro;

import tabuleiro.exception.BoardException;

public class Position {
	
	private int row;
	private int column;
	
	
	
	public Position() {
	}
	public Position(int row, int column) {
		if ( (row < 0 || row > 7) || (column < 0 || column > 7)) {
			throw new BoardException("Board Exception :: Position is not valid");
		}
		this.row = row;
		this.column = column;
	}
	
	
	
	public int getRow() {
		return this.row;
	}
	public int getColumn() {
		return this.column;
	}
	
	
	
	@Override
	public String toString() {
		return this.row + ", " + this.column;
	}

	
}
