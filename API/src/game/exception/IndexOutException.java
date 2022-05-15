package game.exception;

public class IndexOutException extends Exception {
    private int number;

    public IndexOutException(int number) {
		super("IndexOutException"); //super.message
        this.number = number;
	}

	public String toString() {
		return String.format("%s \nIndexOutException: %d ", getMessage(),number);
	}
}
