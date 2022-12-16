package app.console;
import app.IOManager;

public interface IDisplayMenu{
	public final static IOManager io = IOManager.getInstance();
	
	public void displayMenu();
}