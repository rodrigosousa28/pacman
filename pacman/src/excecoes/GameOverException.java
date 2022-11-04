package excecoes;

@SuppressWarnings("serial")
public class GameOverException extends RuntimeException{

	public GameOverException() {}
	
	public String getMessage() {
		return "GAME OVER";
	}
}
