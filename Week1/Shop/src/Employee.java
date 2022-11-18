
public class Employee{
	final int MINIMUMWAGE = 1500;
	
	String name;
	String employeeId;
	String title;
	int hourlyWage;
	
	public void setHourlyWage(int newWage) {
		if (newWage >= MINIMUMWAGE) hourlyWage = newWage;
		else System.out.println("Error, invalid wage input: " + newWage);
	}
	public int getHourlyWage() {
		return hourlyWage;
	}
	
	//used to reduce code repetition in constructor methods.
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
}