package tabuleiro;

import tabuleiro.exception.BoardException;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] boardPieces;
	
	
	
	public Board() {
	}
	public Board(int rows, int columns) {
		if ( (rows < 0 || rows > 8) || (columns < 0 || columns > 8) ) {
			throw new BoardException("Board Exception :: was not possible initialize game board");
		}
		this.rows = rows;
		this.columns = columns;
		this.boardPieces = new Piece[rows][columns];
	}
	
	
	
	public int getRows() {
		return this.rows;
	}
	public int getColumns() {
		return this.columns;
	}
	
	
	
	public Piece piece(int row, int column) {
		if ( !isValidPosition(row, column) ) {
			throw new BoardException("Board Exception :: position is not valid on game board");
		}
		return this.boardPieces[row][column];
	}
	public Piece piece(Position position) {
		if ( !isValidPosition(position) ) {
			throw new BoardException("Board Exception :: position is not valid on game board");
		}
		return this.boardPieces[position.getRow()][position.getColumn()];
	}
	
	
	
	public void insertPiece(Piece piece, Position position) {
		if (hasPiece(position)) {
			throw new BoardException("Board Exception :: it has already a piece at this position {" + position + "}");
		}
		boardPieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	
	
	public Piece removePiece(Position position) {
		if ( !isValidPosition(position) ) {
			throw new BoardException("Board Exception :: position is not valid on game board");
		}
		if ( piece(position) == null ) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		boardPieces[position.getRow()][position.getColumn()] = null;
		
		return aux;
	}
	
	
	
	// Verifica se a posição informada é válida dentro das especificidades do tabuleiro
	public boolean isValidPosition(int row, int column) {
		if ( !(row < 0 || row > this.rows) || !(column < 0 || column > this.columns) ) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isValidPosition(Position position) {
		return isValidPosition(position.getRow(), position.getColumn());
	}
	
	
	
	// Verifica se há uma uma peça no tabuleiro na posição informada
	public boolean hasPiece(Position position) {
		if ( !isValidPosition(position) ) {
			throw new BoardException("Board Exception :: position is not valid on game board");
		}
		return piece(position) != null;
	}
}
