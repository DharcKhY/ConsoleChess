package application;

import partida.ChessMatch;

public class ConsoleChess {

	public static void main(String[] args) {
		
		ChessMatch match = new ChessMatch();
		UserInterface.showBoard(match.getPieces());

	}

}
