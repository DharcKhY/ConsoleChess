package partida;

import partida.colors.Color;
import tabuleiro.Board;
import tabuleiro.Piece;

public class ChessPiece extends Piece {
	
	private Color color;
	
	
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}
	
	
	
	public Color color() {
		return this.color;
	}
	
}
