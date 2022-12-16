package app.exceptions;

public class RequestFromEmptyException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public RequestFromEmptyException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
