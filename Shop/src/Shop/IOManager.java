package Shop;
import java.util.*;

public class IOManager {
	private Scanner scanner;
	boolean continueInput = true;
	
	IOManager(){
		scanner = new Scanner(System.in);
	}
	
	//Displays array as list of options and returns user's selected index.
	public <T> int selectFromArray(String prompt, ArrayList<T> options) {
		
		//Display list of options
		int index = 1;
		System.out.println(prompt);
		for(T t:options) {
			println(index + ". " + t.toString());
			index++;
		}
		
		//Request response from user.
		boolean continueInput = true;
		int response = -1;
		do {
			try {
				response = scanner.nextInt() - 1;
				if (0 <= response && response < options.size()) {
					continueInput = false;
				}
				else { println("Please choose a valid option."); }
			}
			catch (InputMismatchException e){ 
				println("Incorrect input. An integer is required.");
				scanner.nextLine();
			}
		} while (continueInput);
		return response;
	}
	

	
	public void println(String string){
		System.out.println(string);
	}
}
