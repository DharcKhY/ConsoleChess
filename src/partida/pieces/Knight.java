package partida.pieces;

import partida.ChessPiece;
import partida.colors.Color;
import tabuleiro.Board;

public class Knight extends ChessPiece {
	
	public Knight(Board board, Color color) {
		super(board, color);
	}
	
	
	
	@Override
	public String toString() {
		return "KN";
	}
}
