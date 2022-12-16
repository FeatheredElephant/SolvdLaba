package app.exceptions;

public class WrongInputException extends Exception{
	private static final long serialVersionUID = 1L;

	WrongInputException(String errorMessage){
		super(errorMessage);
	}
}
