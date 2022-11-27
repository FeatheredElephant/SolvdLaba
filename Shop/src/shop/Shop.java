package shop;

import java.util.*;

import Shop.Accounts.Register;
import Shop.Products.Product;
import shop.other.IOManager;

public class Shop {
	private String name;
	private String address;
	private ArrayList<Employee> employees;
	private ArrayList<Register> registers;
	private HashMap<Product, Integer> products;
	private ArrayList<Receipt> receipts;
	private ArrayList<Customer> customers;

	Shop(String name, String address) {
		this.name = name;
		this.address = address;
		employees = new ArrayList<>();
		registers = new ArrayList<>();
		products = new HashMap<Product,Integer>();
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

	public Product getProduct(int index) {
		return products.get(index);
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void removeProduct(Product product) {
		products.remove(product);
	}

	public void saveReceipt(Receipt receipt) {
		receipts.add(receipt);
	}

	public void viewReceipts(Customer customer) {
		ArrayList<Receipt> customerReceipts;
		for (Receipt r:receipts) {
			if (r.)
		}
	}

	public void handleCheckout(Customer customer) {
		IOManager io = IOManager.getInstance();
		ArrayList<Register> activeRegisters = new ArrayList<>();
		if (activeRegisters.size() < 1) {
			"Apologies. We have no active registers at this time. Please come back another time.";
			//return to customer action select.
		}
		for (Register r : registers)
			if (r.isActive())
				activeRegisters.add(r);
		activeRegisters.get(io.selectFromArray("Please select a register to handle your purchase.", activeRegisters)).handleCheckout(customer);
	}
}