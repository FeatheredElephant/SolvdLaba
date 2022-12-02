package shop;

import java.util.*;

import shop.products.*;
import shop.console.*;
import shop.finance.Register;
import shop.other.IOManager;

public class Shop {
	private String name;
	private String address;
	private ArrayList<Employee> employees;
	private ArrayList<Register> registers;
	private ArrayList<Receipt> receipts;
	
	public Inventory inventory;
	
	Shop(String name, String address) {
		this.name = name;
		this.address = address;
		employees = new ArrayList<>();
		registers = new ArrayList<>();
		inventory = new Inventory();
		receipts = new ArrayList<>();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public Employee getEmployee(int index) {
		return employees.get(index);
	}
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	public void removeEmployee(Employee employee) {
		employees.remove(employee);
	}
	
	public Register getRegister(int index) {
		return registers.get(index);
	}
	public void addRegister(Register register) {
		registers.add(register);
	}
	public void removeRegister(Register register) {
		registers.remove(register);
	}
	
	public void saveReceipt(Receipt receipt) {
		receipts.add(receipt);
	}
	
	void openShopConsole() {
		IOManager io = IOManager.getInstance();
		
		io.println("Welcome to " + getName() + "!");
		
		ArrayList<String> userOptions = new ArrayList<>();
		userOptions.add("customer");
		userOptions.add("employee");
		userOptions.add("admin");
		
		ILogin user = null;
		String selectedOption = io.selectFromArray("What user type are you?", userOptions);
		if (selectedOption == null) {
			io.println("\nGoodbye.");
			return;
		}
		switch(selectedOption) {
			case "customer":
				user = new CustomerConsole();
				break;
			case "employee":
				user = new EmployeeConsole();
				break;
			case "admin":
				user = new AdminConsole();
				break;
			default:	
		}
		user.login(this);
		openShopConsole();
	}

	@Override
	public String toString() {
		return "Shop [name=" + name + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shop other = (Shop) obj;
		return Objects.equals(address, other.address) && Objects.equals(name, other.name);
	}
}
