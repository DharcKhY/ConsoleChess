package partida.exception;

import tabuleiro.exception.BoardException;

public class MatchException extends BoardException {
	private static final long serialVersionUID = 1L;

	public MatchException(String errorMsg) {
		super(errorMsg);
	}

}
