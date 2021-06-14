package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import partida.ChessMatch;
import partida.ChessPiece;
import partida.ChessPosition;
import partida.exception.MatchException;

public class ConsoleChess {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		ChessMatch match = new ChessMatch();
		
		while (true) {
			try {
				UserInterface.clearConsole();
				UserInterface.showBoard(match.getPieces());
				
				System.out.println();
				System.out.print("Source: ");
				
				ChessPosition source = UserInterface.readPosition(s);
				
				System.out.println();
				System.out.print("Target: ");
				
				ChessPosition target = UserInterface.readPosition(s);
				ChessPiece capturedPiece = match.movePiece(source, target);
				System.out.println(capturedPiece);
			} catch(MatchException me) {
				System.out.println(me.getMessage());
				s.nextLine();
			} catch(InputMismatchException ime) {
				System.out.println(ime.getMessage());
				s.nextLine();
			}
		}
	}
}
