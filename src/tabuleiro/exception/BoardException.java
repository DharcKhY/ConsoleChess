package tabuleiro.exception;

import java.io.Serializable;

public class BoardException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public BoardException(String errorMsg) {
		super(errorMsg);
	}

}
