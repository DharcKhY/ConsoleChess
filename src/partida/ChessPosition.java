package partida;

import partida.exception.MatchException;
import tabuleiro.Position;

public class ChessPosition {
	
	private char column;
	private int row;
	
	
	
	public ChessPosition(char column, int row) {
		column = ChessMatch.toLower(column);
 		if ( (column < 'a' || column > 'h') || (row < 1 || row > 8) ) {
 			throw new MatchException("Posição incorreta, as posições válidas são entre a1(A1) até h8(H8)");
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
