package game.exception;

public class SameNameException extends Exception{
    private String name;

    public SameNameException(String name) {
		super("SameNameException"); //super.message
        this.name = name;
	}

	public String toString() {
		return String.format("\n%s \nYa existe un jugador el nombre: %s ", getMessage(),name);
	}
}
