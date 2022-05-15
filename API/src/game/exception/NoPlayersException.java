package game.exception;

public class NoPlayersException extends Exception {
	public NoPlayersException() {
		super("NoPlayersInGame"); //super.message
	}

	public String toString() {
		return String.format("%s \nNo hay suficientes jugadores en el juego ", getMessage());
	}
}
