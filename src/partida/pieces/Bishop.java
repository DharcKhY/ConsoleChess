package partida.pieces;

import partida.ChessPiece;
import partida.colors.Color;
import tabuleiro.Board;

public class Bishop extends ChessPiece {
	
	public Bishop(Board board, Color color) {
		super(board, color);
	}
	
	
	
	@Override
	public String toString() {
		return "BS";
	}



	@Override
	public boolean[][] possibleMoves() {
		boolean[][] moves = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return moves;
	}
}
