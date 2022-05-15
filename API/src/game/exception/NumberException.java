package game.exception;

public class NumberException extends Exception {
    private char c;

    public NumberException(char c) {
		super("NumberFormatException"); //super.message
        this.c = c;
	}

	public String toString() {
		return String.format("%s \nNumberFormatException: %c ", getMessage(),c);
	}
}
