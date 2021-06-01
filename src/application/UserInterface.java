package application;

import partida.ChessPiece;
import partida.colors.BashColor;
import partida.colors.Color;

public class UserInterface {

	public static void showBoard(ChessPiece[][] pieces) {
		
		System.out.println();
		System.out.println();
		printColumns();
		System.out.println("\n");
		for ( int x = 0; x < pieces.length; x++ ) {
			System.out.print("[# " + (8 - x) + " ]\t");
			for ( int y = 0; y < pieces[x].length; y++ ) {
				// printPiece_COLORLESS(pieces[x][y]);
				printPiece_COLORFUL(pieces[x][y]);
			}
			System.out.print(" [# " + (8 - x) + " ]");
			System.out.println();
		}
		System.out.println();
		printColumns();
		System.out.println();
		System.out.println();
	}

	// Print only one piece - Without console color
	public static void printPiece_COLORLESS(ChessPiece piece) {
		if ( piece == null ) {
			System.out.print("[    ] ");
		} else {
			System.out.print("[ " + piece + " ] ");
		}
	}
	
	public static void printPiece_COLORFUL(ChessPiece piece) {
		if ( piece == null ) {
			System.out.print("[    ] ");
		} else {
			if ( piece.getColor() == Color.WHITE ) {
				System.out.print(BashColor.BACKGROUND_BLUE + "" + BashColor.FONT_WHITE + "[ " + piece + " ]" + BashColor.RESET + " ");
			} else {
				System.out.print(BashColor.BACKGROUND_CYAN + "" + BashColor.FONT_BLACK + "[ " + piece + " ]" + BashColor.RESET + " ");
			}
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
