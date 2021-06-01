package partida;

import partida.exception.MatchException;
import tabuleiro.Position;

public class ChessPosition {
	
	private char column;
	private int row;
	
	
	
	public ChessPosition(char column, int row) {
 		if ( (Character.toLowerCase(column) < 'a' || Character.toLowerCase(column) > 'h') || (row < 1 || row > 8) ) {
 			throw new MatchException("Match Exception :: valid values are from 'a1' to 'h8'");
 		}
		this.column = column;
		this.row = row;
	}
	
	
	
	public char getColumn() {
		return this.column;
	}
	public int getRow() {
		return this.row;
	}
	
	
	
	protected Position toPosition() {
		return new Position( (8 - this.row), (this.column - 'a') );
	}
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition( (char)('a' - position.getColumn()), (int)(8 - position.getRow()) );
	}
	
	
	
	@Override
	public String toString() {
		return ("" + this.column + this.row);
	}
}
