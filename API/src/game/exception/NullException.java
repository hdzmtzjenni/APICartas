package game.exception;

public class NullException extends Exception {
    public NullException() {
		super("NullException"); //super.message
	}

	public String toString() {
		return String.format("%s \nNo se admiten apuntadores nulos", getMessage());
	}
}
