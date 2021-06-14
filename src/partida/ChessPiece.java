package partida;

import partida.colors.Color;
import tabuleiro.Board;
import tabuleiro.Piece;
import tabuleiro.Position;

public abstract class ChessPiece extends Piece {
	
	private Color color;
	
	
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}
	
	
	
	public Color getColor() {
		return this.color;
	}
	
	
	
	protected boolean hasOpponentPiece(Position pos) {
		ChessPiece p = (ChessPiece) getBoard().piece(pos);
		if ( p != null ) {
			if ( p.getColor() != this.color ) {
				return true;
			}
		}
		return false;
	}
	
}
