package shop.accounts;
import java.util.*;

import shop.other.IOManager;
import shop.other.Reference;
import shop.Customer;
import shop.Employee;
import shop.Receipt;
import shop.products.Product;


public class Register extends Account {
	private Employee cashier;

	public Register(String id) {
		super(id);
	}

	public Employee getCashier() {
		return cashier;
	}

	public void setCashier(Employee employee) {
		this.cashier = employee;
	}

	public Receipt handleCheckout(Customer customer) {
		return null;
	}
	
	String requestPaymentMethod() {
		return IOManager.getInstance().selectFromArray("Please select from the following payment methods:", (ArrayList<String>) Arrays.asList(Reference.getPAYMENTMETHODS()));
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
	
	@Override
	public String toString() {
		return getId();
	}
	
	public static String sampleToString() {
		return "RegisterId serviced by CashierName";
	}
}