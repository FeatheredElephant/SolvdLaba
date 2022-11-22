import java.util.*;

public class Shop {
	private String name;
	private String address;
	private ArrayList<Employee> employees;
	private ArrayList<Register> registers;
	private ArrayList<Product> products;
	private ArrayList<Receipt> receipts;

	Shop(String name, String address) {
		this.name = name;
		this.address = address;
		employees = new ArrayList<>();
		registers = new ArrayList<>();
		products = new ArrayList<>();
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
		// to be implemented
	}
	
	//Need to add try/catch for appropriate data type and int range
	public void handleCheckout(Customer customer) {
		// Select Register
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please select from the available registers:");
		int index = 0;
		for (Register r : registers) {
			if (r.isActive()) {
				System.out.println((index + 1) + ". " + r.getId());
			}
			index++;
		}
		Register register = registers.get(scanner.nextInt() - 1);
		if (!register.isActive()) {
			System.out.println("You have selected an inactive register.");
			this.handleCheckout(customer);
			scanner.close();
			return;
		}
		register.handleCheckout(customer);
	}
}