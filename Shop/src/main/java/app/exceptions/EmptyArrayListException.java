package app.exceptions;

public class EmptyArrayListException extends Exception{
	private static final long serialVersionUID = 1L;

	public EmptyArrayListException(String errorMessage){
		super(errorMessage);
	}
}
