package partida.pieces;

import partida.ChessPiece;
import partida.colors.Color;
import tabuleiro.Board;

public class Rook extends ChessPiece {
	
	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	
	
	@Override
	public String toString() {
		return "RK";
	}
}
