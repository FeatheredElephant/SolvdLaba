package shop.console;
import java.util.ArrayList;

import shop.Shop;
import shop.Employee;

public class EmployeeConsole implements ILogin{
	
	public EmployeeConsole(){
		
	}
	
	public void login(Shop shop) {
		Employee selectedAccount = io.selectFromArray("Please select your account", shop.getEmployees());
		if (selectedAccount == null) {return;}
		
		boolean tryAgain = true;
		
		do {
			io.println("password:");
			if (selectedAccount.checkPassword(io.requestString())) {
				displayHome(selectedAccount);
				tryAgain = false;
			}
			else if (!io.yesOrNo("Incorrect password, would you like to try again?")) {
				tryAgain = false;
			}
		} while (tryAgain);
		login(shop);
	}
	
	public void displayHome(Employee user) {
		
		ArrayList<String> defaultActions = new ArrayList<>();
		
		if (!user.isClockedIn()) defaultActions.add("Clock in");
		else defaultActions.add("Clock out");
		
		String option = io.selectFromArray("What would you like to do?", defaultActions);
		if (option == null) return;
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
		displayHome(user);
	}
}
