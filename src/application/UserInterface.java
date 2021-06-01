package application;

import partida.ChessPiece;

public class UserInterface {

	public static void showBoard(ChessPiece[][] pieces) {
		
		printColumns();
		System.out.println("\n");
		for ( int x = 0; x < pieces.length; x++ ) {
			System.out.print("[# " + (8 - x) + " ]\t");
			for ( int y = 0; y < pieces[x].length; y++ ) {
				printPiece(pieces[x][y]);
			}
			System.out.print(" [# " + (8 - x) + " ]");
			System.out.println();
		}
		System.out.println();
		printColumns();
		
	}

	// Print only one piece
	public static void printPiece(ChessPiece piece) {
		if ( piece == null ) {
			System.out.print("[    ] ");
		} else {
			System.out.print("[ " + piece + " ] ");
		}
	}
	
	//  Print vertical column
	public static void printColumns() {
		System.out.print("\t");
		for (int i = 0; i < 8; i++) {
			String s = Character.toString('A' + i);
			System.out.print("[# " + s + " ] ");
			
		}
	}
	
	
	
}
