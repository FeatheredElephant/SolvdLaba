package app;

import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	
	public File getFileFromResources(String fileName) throws URISyntaxException, IllegalArgumentException{
			URL resource = getClass().getClassLoader().getResource(fileName);
			if (resource == null) throw new IllegalArgumentException("File not found. " + fileName);
			else return new File(resource.toURI());
	}
}
