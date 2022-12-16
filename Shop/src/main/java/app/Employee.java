package app;

import java.util.Objects;

import app.finance.FinancialAccount;

public class Employee {
	private int MINIMUMWAGE = Reference.getMINIMUMWAGE();
	private String name;
	private String employeeId;
	private String title;
	private String accountPassword;
	private int hourlyWage;
	private boolean clockedIn;

	// Constructors---------------------------------------------------------------------------------------------------

	void initialize(String name, String employeeId, int hourlyWage, String password) {
		this.name = name;
		this.employeeId = employeeId;
		setHourlyWage(hourlyWage);
		clockedIn = false;
		accountPassword = password;
	}

	Employee(String name, String employeeId, int hourlyWage, String password) {
		initialize(name, employeeId, hourlyWage, password);
		this.title = "";
	}

	Employee(String name, String employeeId, int hourlyWage, String password, String title) {
		initialize(name, employeeId, hourlyWage, password);
		this.title = title;
	}

	// Getters and
	// Setters-----------------------------------------------------------------------------------------------------
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

	public boolean isClockedIn() {
		return clockedIn;
	}

	// -------------------------------------------------------------------------------------------------------------------------

	public void clockIn() {
		clockedIn = true;
	}

	public void clockOut() {
		clockedIn = false;
	}

	public boolean transferFunds(FinancialAccount giver, FinancialAccount receiver, int amount) {
		if (giver.getFunds() >= amount) {
			giver.withdrawFunds(amount);
			receiver.depositFunds(amount);
			return true;
		}
		return false;
	}

	public boolean checkPassword(String input) {
		if (input.equals(accountPassword)) {
			return true;
		}
		return false;
	}

	// Overrides----------------------------------------------------------------------------------------------------------------

	@Override
	public String toString() {
		return name + " " + employeeId + " " + title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(employeeId, other.employeeId);
	}
}