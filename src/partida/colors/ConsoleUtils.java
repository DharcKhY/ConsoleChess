package partida.colors;

public enum ConsoleUtils {
	
	// Reset Color
	RESET("\033[0m"),
	
	// Clear Console
	CLEAR("\033[H\033[2J"),
	
	
	// Font Color
	FONT_BLACK("\033[1;30m"),
	FONT_RED("\033[1;31m"),
	FONT_GREEN("\033[1;32m"),
	FONT_YELLOW("\033[1;33m"),
	FONT_BLUE("\033[1;34m"),
	FONT_MAGENTA("\033[1;35m"),
	FONT_CYAN("\033[1;36m"),
	FONT_WHITE("\033[1;37m"),
	
	// Background Color
	BACKGROUND_BLACK("\033[40m"),
	BACKGROUND_RED("\033[41m"),
	BACKGROUND_GREEN("\033[42m"),
	BACKGROUND_YELLOW("\033[43m"),
	BACKGROUND_BLUE("\033[44m"),
	BACKGROUND_MAGENTA("\033[45m"),
	BACKGROUND_CYAN("\033[46m"),
	BACKGROUND_WHITE("\033[47m");
	
	private final String code;
	ConsoleUtils(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return code;
	}
}
