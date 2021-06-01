package partida.pieces;

import partida.ChessPiece;
import partida.colors.Color;
import tabuleiro.Board;

public class Queen extends ChessPiece {
	
	public Queen(Board board, Color color) {
		super(board, color);
	}
	
	
	
	@Override
	public String toString() {
		return "QN";
	}
}
