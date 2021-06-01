package partida.pieces;

import partida.ChessPiece;
import partida.colors.Color;
import tabuleiro.Board;

public class Pawn extends ChessPiece {
	
	public Pawn(Board board, Color color) {
		super(board, color);
	}
	
	
	
	@Override
	public String toString() {
		return "PN";
	}
}
