package app.console;
import java.util.ArrayList;

import app.Employee;
import app.Shop;
import app.exceptions.EmptyArrayListException;
import app.exceptions.HandleExitRequestException;

public class EmployeeConsole implements ILogin{
	
	Employee user;
	
	public EmployeeConsole(){
		
	}
	
	public void login(Shop shop) {
		Employee selectedAccount = null;
		try {
			selectedAccount = io.selectFromArray("Please select your account", shop.getEmployees());
		} catch (EmptyArrayListException e) {
			io.reportError("Error: " + e);
		} catch (HandleExitRequestException e) {
			return;
		}
		
		boolean tryAgain = true;
		
		do {
			io.println("password:");
			if (selectedAccount.checkPassword(io.requestString())) {
				user = selectedAccount;
				displayMenu();
				tryAgain = false;
			}
			else if (!io.yesOrNo("Incorrect password, would you like to try again?")) {
				tryAgain = false;
			}
		} while (tryAgain);
		login(shop);
	}
	
	public void displayMenu() {
		
		ArrayList<String> options = new ArrayList<>();
		
		if (!user.isClockedIn()) options.add("Clock in");
		else options.add("Clock out");
		
		String option = null;
		try {
			option = io.selectFromArray("What would you like to do?", options);
		} catch (EmptyArrayListException e) {
			io.reportError("Error: " + e);
		} catch (HandleExitRequestException e) {
			return;
		}
		
		switch(option) {
			case "Clock in":
				user.clockIn();
				io.println("You have been clocked in.");
				break;
			case "Clock out":
				user.clockOut();
				io.println("You have been clocked out.");
				break;
			default:
				break;
		}
		displayMenu();
	}

	@Override
	public String toString() {
		return "Employee Console";
	}
}
