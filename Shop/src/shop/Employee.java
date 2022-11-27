package shop;
import shop.accounts.Account;
import shop.other.Reference;

public class Employee {
	private int MINIMUMWAGE = Reference.getMINIMUMWAGE();
	private String name;
	private String employeeId;
	private String title;
	private int hourlyWage;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(int newWage) {
		if (newWage >= MINIMUMWAGE)
			hourlyWage = newWage;
		else
			System.out.println("Error, invalid wage input: " + newWage);
	}

	// used to reduce code repetition in constructor methods.
	void initialize(String name, String employeeId, int hourlyWage) {
		this.name = name;
		this.employeeId = employeeId;
		setHourlyWage(hourlyWage);
	}

	Employee(String name, String employeeId, int hourlyWage) {
		initialize(name, employeeId, hourlyWage);
	}

	Employee(String name, String employeeId, int hourlyWage, String title) {
		initialize(name, employeeId, hourlyWage);
		this.title = title;
	}

	public void clockIn() {
		
	}
	
	public void clockOut() {
		
	}
	
	public boolean transferFunds(Account giver, Account receiver, int amount) {
		if (giver.getFunds() >= amount) {
			giver.withdrawFunds(amount);
			receiver.depositFunds(amount);
			return true;
		}
		return false;
	}
}