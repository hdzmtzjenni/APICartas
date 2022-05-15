package game.exception;

public class NumberException extends Exception {
    private String number;

    public NumberException(char c) {
		super("NumberFormatException"); //super.message
        this.number = c;
	}

	public String toString() {
		return String.format("%s \nNumberFormatException: %d ", getMessage(),number);
	}
}
