package partida.exception;

import java.io.Serializable;

public class MatchException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;

	public MatchException(String errorMsg) {
		super(errorMsg);
	}

}
