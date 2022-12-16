package app.exceptions;

public class HandleExitRequestException extends Exception{
	private static final long serialVersionUID = 1L;

	public HandleExitRequestException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
