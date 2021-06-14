package partida.pieces;

import partida.ChessPiece;
import partida.colors.Color;
import tabuleiro.Board;
import tabuleiro.Position;

public class Rook extends ChessPiece {
	
	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	
	
	@Override
	public String toString() {
		return "RK";
	}



	
	// Está com erro ainda tem que verificar o que está causando o problema e como arrumar o problema
	@Override
	public boolean[][] possibleMoves() {
		
		boolean[][] moves = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);
		
		
		// Verifica a posição 'Acima' da peça
		p.setValues(position.getRow() - 1, position.getColumn());
		while ( getBoard().isValidPosition(p) && !getBoard().hasPiece(p) ) {
			moves[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);	
		}
		if (getBoard().hasPiece(p) && hasOpponentPiece(p)) {
			moves[p.getRow()][p.getColumn()] = true;
		}
		
		
		return moves;
	}
}
