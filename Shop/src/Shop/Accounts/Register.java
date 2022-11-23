package Shop.Accounts;
import java.util.*;
import Shop.Employee;
import Shop.Customer;
import Shop.Receipt;
import Shop.Products.Product;
import Shop.Constants;


public class Register extends Account {
	private String id;
	private Employee cashier;

	Register(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Employee getCashier() {
		return cashier;
	}

	public void setCashier(Employee employee) {
		this.cashier = employee;
	}

	public Receipt handleCheckout(Customer customer) {

		// Calculate cost of purchase
		ArrayList<Product> selectedProducts = customer.getCart();
		int totalCost = calculateCost(selectedProducts);

		// Select Payment method
		String paymentMethod = requestPaymentMethod();

		// Transfer funds
		cashier.transferFunds(customer, this, totalCost);

		// Print + Return receipt
		Receipt receipt = new Receipt(selectedProducts, paymentMethod, totalCost, this);
		System.out.println("Thank you for shopping with us. Here's your receipt.");
		receipt.printReceipt();
		return receipt;
	}

	// Requests user's payment method (string).
	// Need to add try/catch for mismatching types.
	String requestPaymentMethod() {

		String response;

		// Provide user with payment options.
		System.out.println("Please select a method of payment");

		String[] PAYMENTMETHODS = Constants.getPAYMENTMETHODS();
		for (int i = 0; i < PAYMENTMETHODS.length; i++) {
			System.out.println((i + 1) + ". " + PAYMENTMETHODS[i]);
		}

		// Request user response
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();

		// Check if valid response
		if (input < 1 || Constants.getPAYMENTMETHODS().length < input) {
			System.out.println("Invalid value input.");
			response = requestPaymentMethod();
			scanner.close();
			return response;
		}

		// close scanner and return selected payment method
		scanner.close();
		response = Constants.getPAYMENTMETHODS()[input - 1];
		return response;
	}

	int calculateCost(ArrayList<Product> selectedProducts) {
		int totalCost = 0;
		for (Product p : selectedProducts) {
			totalCost += p.getCost();
		}
		return totalCost;
	}
	
	public Boolean isActive() {
		if (cashier == null) return false;
		return true;
	}
}