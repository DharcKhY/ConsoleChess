package partida;

import partida.colors.Color;
import partida.exception.MatchException;
import partida.pieces.Bishop;
import partida.pieces.King;
import partida.pieces.Knight;
import partida.pieces.Queen;
import partida.pieces.Rook;
import tabuleiro.Board;
import tabuleiro.Piece;
import tabuleiro.Position;

public class ChessMatch {
	
	private Board board;
	
	
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
	
	
	
	// Retorna a posi��o da matriz de todas as pe�as do tabuleiro
	public ChessPiece[][] getPieces() {
		ChessPiece[][] chessPiece = new ChessPiece[board.getRows()][board.getColumns()];
		for (int x = 0; x < chessPiece.length; x++) {
			for (int y = 0; y < chessPiece[x].length; y++) {
				chessPiece[x][y] = (ChessPiece) board.piece(x, y);
			}
		}
		return chessPiece;
	}
	
	
	
	// Adiciona uma pe�a no tabuleiro
	// Recebe a posi��o do tipo 'char' para a vari�vel "Column", e um 'int' primitivo para a vari�vel 'Row'
	// E como terceiro par�metro, obt�m a pe�a que ser� inserida no tabuleiro
	private void addNewPiece(char column, int row, ChessPiece piece) {
		if (column > 'A' || column < 'H') {
			column = toLower(column);
		}
		board.insertPiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	
	
	// Nessa fun��o ser� passado uma String 'position' como argumento
	// Que ser� convertido nas posi��es da fun��o addNewPiece(char, int, ChessPiece)
	// Caso seja passado o par�metro como sendo "A1", por exemplo
	// Ser� extra�do ambos os valores 'A' e 1 e passando na fun��o acima ('A', 1, piece)
	private void addNewPiece(String position, ChessPiece piece) {
		char column = position.charAt(0);
		
		// Converte a posi��o no indice 1 da string position para inteiro, para passar no parametro de nova pe�a adicionada
		// A convers�o � necess�ria para essa posi��o, por que ele retorna um valor do tipo char
		// Se o parametro for passado dessa forma, o parametro ser� passado em um valor inteiro da tabela ASCII
		// se 'A' for passado como parametro, sendo um char, ele vai retornar o valor correspondente
		// na tabela ASCII, e ir� gerar um erro de posi��o.
		int row = Integer.parseInt(String.valueOf(position.charAt(1)));
		
		addNewPiece(column, row, piece);
	}
	
	
	
	// Essa fun��o auxiliar serve para converter os valores dos caracteres Mai�sculos
	// Para os caracteres min�sculos.
	// Essa fun��o serve para converter todas as posi��es para min�sculo, para que haja compatibilidade
	// na hora de passar um par�metro que contenha letras Mai�sculas, por exemplo: "A1"
	// Sem essa convers�o do toLower(arg) ao passar o par�metro contendo letra Mai�scula.
	// Ser� gerado um erro ao adicionar a pe�a no tabuleiro
	protected static char toLower(char position) {
		switch(position) {
		case 'A':
			return 'a';
		case 'B':
			return 'b';
		case 'C':
			return 'c';			
		case 'D':
			return 'd';
		case 'E':
			return 'e';
		case 'F':
			return 'f';
		case 'G':
			return 'g';
		case 'H':
			return 'h';	
		default:
			return position;
		}	
	}
	
	
	
	public ChessPiece movePiece(ChessPosition source, ChessPosition target) {
		Position src = source.toPosition();
		Position tgt = target.toPosition();	
		validatePosition(src);
		Piece capturedPiece = moveTo(src, tgt);
		return (ChessPiece) capturedPiece;
	}
	
	
	
	private void validatePosition(Position position) {
		if ( !board.hasPiece(position) ) {
			throw new MatchException("Posi��o inv�lida e/ou fora das dimens�es do tabuleiro");
		}	
	}
	
	
	
	private Piece moveTo(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPieces = board.removePiece(target);
		board.insertPiece(p, target);
		return capturedPieces;
	}	
	
		
	
	// Posi��o inicial das pe�as do tabuleiro
	private void initialSetup() {
															//   Pe�a	|   Cor
															// ---------+----------
		addNewPiece("A1", new Rook(board, Color.WHITE));	// TORRE	| BRANCO
		addNewPiece("A8", new Rook(board, Color.BLACK));	// TORRE	| PRETO
		addNewPiece("B1", new Knight(board, Color.WHITE));	// CAVALO	| BRANCO
		addNewPiece("B8", new Knight(board, Color.BLACK));	// CAVALO	| PRETO
		addNewPiece("C1", new Bishop(board, Color.WHITE));	// BISPO	| BRANCO
		addNewPiece("C8", new Bishop(board, Color.BLACK));	// BISPO	| PRETO
		addNewPiece("D1", new Queen(board, Color.WHITE));	// RAINHA	| BRANCO
		addNewPiece("D8", new Queen(board, Color.BLACK));	// RAINHA	| PRETO
		addNewPiece("E1", new King(board, Color.WHITE));	// REI		| BRANCO
		addNewPiece("E8", new King(board, Color.BLACK));	// REI		| PRETO 
		addNewPiece("F1", new Bishop(board, Color.WHITE));	// BISPO	| BRANCO
		addNewPiece("F8", new Bishop(board, Color.BLACK));	// BISPO	| PRETO
		addNewPiece("G1", new Knight(board, Color.WHITE));	// CAVALO	| BRANCO
		addNewPiece("G8", new Knight(board, Color.BLACK));	// CAVALO 	| PRETO
		addNewPiece("H1", new Rook(board, Color.WHITE));	// TORRE 	| BRANCO
		addNewPiece("H8", new Rook(board, Color.BLACK));	// TORRE 	| PRETO
		
		
	}
}
