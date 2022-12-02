package shop.other;
import java.util.*;

public class IOManager {
	private Scanner scanner;
	
	private static final IOManager instance = new IOManager();
	
	private IOManager(){
		scanner = new Scanner(System.in);
	}
	
	public static IOManager getInstance() {
		return instance;
	}
	
	public <T> T selectFromArray(String prompt, ArrayList<T> options) {
		return selectFromArray(prompt, "", options);
	}
	
	//Displays array as a list and returns user's selected item or request to exit (null).
	public <T> T selectFromArray(String prompt, String sampleItem, ArrayList<T> options) {
		if (options.size() == 0) {
			println("Error: Attempted to display empty array.");
			return null;
		}
		println("\n" + prompt);
		//Display list of options
		if (sampleItem != "") println("#. " + sampleItem + "\n----------------------");
		int index = 1;
		println("0. Exit");
		for(T t:options) {
			println(index + ". " + t.toString());
			index++;
		}
		
		//Request response from user.
		boolean continueInput = true;
		int response;
		do {
			response = requestInt() - 1;
			if (0 <= response && response < options.size()) {
				continueInput = false;
			}
			else if(response == -1) {return null;}
			else { println("Please choose a valid option."); }
		} while (continueInput);
		
		return options.get(response);
	}
	
	//Ask user a yes or no question
	public boolean yesOrNo(String prompt) {
		println(prompt + " (0 = no, 1 = yes)");
		int response;
		boolean continueInput = true;
		do {
			response = requestInt();
			if (response == 0 || response == 1) continueInput = false;
			else println("Please input '0' for no or '1' for yes.");
		} while (continueInput);
		
		return (response == 1);
	}
	
	//Request int between inclusive min and inclusive max.
	public int requestIntInRange(int min, int max) {
		boolean correctInput = false;
		int input;
		do{
			input = requestInt();
			if (min <= input && input <= max) correctInput = true;
			else println("Incorrect input: Please make sure your input is in range.");
		} while (!correctInput);
		
		return input;
	}
	
	//Guarantees input is an integer.
	public int requestInt() {
		boolean correctInput = false;
		int input = -1;
		
		do {
			try {
				input = scanner.nextInt();
				correctInput = true;
			}
			catch(InputMismatchException e){
				println("Incorrect input. An integer is required.");
				scanner.nextLine();
			}
		} while (!correctInput);
		return input;
	}
	
	//gets String from user
	public String requestString() {
		String input = scanner.next();
		return input;
	}
	
	public <T> void println(T output){
		System.out.print(output + "\n");
	}
}
