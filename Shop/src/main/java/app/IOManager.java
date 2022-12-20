package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import app.exceptions.EmptyArrayListException;
import app.exceptions.EmptyHashMapException;
import app.exceptions.HandleExitRequestException;

public class IOManager {
	private Scanner scanner;
	private static Logger logger = LogManager.getLogger(IOManager.class.getName());
	private static final IOManager instance = new IOManager();

	private IOManager() {
		scanner = new Scanner(System.in);
	}

	public static IOManager getInstance() {
		return instance;
	}

	public <T> T selectFromArray(String prompt, ArrayList<T> options)
			throws EmptyArrayListException, HandleExitRequestException {
		return selectFromArray(prompt, "", options);
	}
	
	// Displays array as a list and returns user's selected item or request to exit
	// (null).
	public <T> T selectFromArray(String prompt, String sampleItem, ArrayList<T> options)
			throws EmptyArrayListException, HandleExitRequestException {
		if (options.size() == 0) {
			throw new EmptyArrayListException("Attempting to display empty ArrayList.");
		}
		println("\n" + prompt);
		
		// Display list of options
		if (sampleItem != "")
			println("#. " + sampleItem + "\n----------------------");
		int itemCount = 1;
		println("0. Exit");
		for (T t : options) {
			println(itemCount + ". " + t.toString());
			itemCount++;
		}
		int response = requestIntInRange(0, options.size());
		if (response == 0) throw new HandleExitRequestException("User requesting exit.");
		return options.get(response - 1);
	}
	
	public <K,V> K selectFromHashMap(String prompt, String sampleItem, HashMap<K,V> options) 
			throws EmptyHashMapException, HandleExitRequestException {
		if (options.isEmpty()) {
			throw new EmptyHashMapException("Attempting to display empty HashMap");
		}
		
		println("\n" + prompt);
		if (sampleItem != "")
			println("#. " + sampleItem + "\n----------------------");
		
		println("0. Exit");
		int itemCount = 1;
		ArrayList<K> keys = new ArrayList<>(options.keySet());
		for (K key:keys) {
			println(itemCount + ". " + key.toString() + " " + options.get(key).toString());
			itemCount++;
		}
		
		int response = requestIntInRange(0, options.size());
		if (response == 0) throw new HandleExitRequestException("User requesting exit.");
		return keys.get(response - 1);
	}
	
	public <T> void displayList(ArrayList<T> elements){
		for (T element: elements) {
			println(element.toString());
		}
	}

	// Ask user a yes or no question
	public boolean yesOrNo(String prompt) {
		println(prompt + " (0 = no, 1 = yes)");
		int response;
		boolean continueInput = true;
		do {
			response = requestInt();
			if (response == 0 || response == 1)
				continueInput = false;
			else
				println("Please input '0' for no or '1' for yes.");
		} while (continueInput);

		return (response == 1);
	}

	// Request int between inclusive min and inclusive max.
	public int requestIntInRange(int min, int max) {
		boolean correctInput = false;
		int input;
		do {
			input = requestInt();
			if (min <= input && input <= max)
				correctInput = true;
			else
				println("Incorrect input: Please make sure your input is in range.");
		} while (!correctInput);

		return input;
	}

	// Guarantees input is an integer.
	public int requestInt() {
		boolean correctInput = false;
		int input = -1;

		do {
			try {
				input = scanner.nextInt();
				correctInput = true;
			} catch (InputMismatchException e) {
				println("Incorrect input. An integer is required.");
				scanner.nextLine();
			}
		} while (!correctInput);
		return input;
	}

	// gets String from user
	public String requestString() {
		String input = scanner.next();
		return input;
	}

	public <T> void println(T output) {
		logger.debug(output + "\n");
	}
	
	public <T> void reportError(T output) {
		logger.error(output);
	}
}
