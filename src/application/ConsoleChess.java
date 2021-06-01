package application;

import java.util.Scanner;

import partida.ChessMatch;
import partida.ChessPiece;
import partida.ChessPosition;

public class ConsoleChess {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		ChessMatch match = new ChessMatch();
		
		while (true) {
			UserInterface.showBoard(match.getPieces());
			
			System.out.println();
			System.out.print("Source: ");
			
			ChessPosition source = UserInterface.readPosition(s);
			
			System.out.println();
			System.out.print("Target: ");
			
			ChessPosition target = UserInterface.readPosition(s);
			ChessPiece capturedPiece = match.movePiece(source, target);
		}
		
	}

}
