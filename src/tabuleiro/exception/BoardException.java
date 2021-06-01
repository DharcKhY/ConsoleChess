package tabuleiro.exception;

import java.io.Serializable;

import partida.exception.MatchException;

public class BoardException extends MatchException implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public BoardException(String errorMsg) {
		super(errorMsg);
	}

}
