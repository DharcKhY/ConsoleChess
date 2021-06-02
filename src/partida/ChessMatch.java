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
	
	
	
	// Retorna a posição da matriz de todas as peças do tabuleiro
	public ChessPiece[][] getPieces() {
		ChessPiece[][] chessPiece = new ChessPiece[board.getRows()][board.getColumns()];
		for (int x = 0; x < chessPiece.length; x++) {
			for (int y = 0; y < chessPiece[x].length; y++) {
				chessPiece[x][y] = (ChessPiece) board.piece(x, y);
			}
		}
		return chessPiece;
	}
	
	
	
	// Adiciona uma peça no tabuleiro
	// Recebe a posição do tipo 'char' para a variável "Column", e um 'int' primitivo para a variável 'Row'
	// E como terceiro parâmetro, obtém a peça que será inserida no tabuleiro
	private void addNewPiece(char column, int row, ChessPiece piece) {
		if (column > 'A' || column < 'H') {
			column = toLower(column);
		}
		board.insertPiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	
	
	// Nessa função será passado uma String 'position' como argumento
	// Que será convertido nas posições da função addNewPiece(char, int, ChessPiece)
	// Caso seja passado o parâmetro como sendo "A1", por exemplo
	// Será extraído ambos os valores 'A' e 1 e passando na função acima ('A', 1, piece)
	private void addNewPiece(String position, ChessPiece piece) {
		char column = position.charAt(0);
		
		// Converte a posição no indice 1 da string position para inteiro, para passar no parametro de nova peça adicionada
		// A conversão é necessária para essa posição, por que ele retorna um valor do tipo char
		// Se o parametro for passado dessa forma, o parametro será passado em um valor inteiro da tabela ASCII
		// se 'A' for passado como parametro, sendo um char, ele vai retornar o valor correspondente
		// na tabela ASCII, e irá gerar um erro de posição.
		int row = Integer.parseInt(String.valueOf(position.charAt(1)));
		
		addNewPiece(column, row, piece);
	}
	
	
	
	// Essa função auxiliar serve para converter os valores dos caracteres Maiúsculos
	// Para os caracteres minúsculos.
	// Essa função serve para converter todas as posições para minúsculo, para que haja compatibilidade
	// na hora de passar um parâmetro que contenha letras Maiúsculas, por exemplo: "A1"
	// Sem essa conversão do toLower(arg) ao passar o parâmetro contendo letra Maiúscula.
	// Será gerado um erro ao adicionar a peça no tabuleiro
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
			throw new MatchException("Posição inválida e/ou fora das dimensões do tabuleiro");
		}	
	}
	
	
	
	private Piece moveTo(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPieces = board.removePiece(target);
		board.insertPiece(p, target);
		return capturedPieces;
	}	
	
		
	
	// Posição inicial das peças do tabuleiro
	private void initialSetup() {
															//   Peça	|   Cor
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
