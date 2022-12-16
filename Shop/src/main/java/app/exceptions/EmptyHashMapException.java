package app.exceptions;

public class EmptyHashMapException extends Exception {
	private static final long serialVersionUID = 1L;

	public EmptyHashMapException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
