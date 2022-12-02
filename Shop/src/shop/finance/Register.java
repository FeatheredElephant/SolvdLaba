package shop.finance;
import java.util.*;

import shop.other.IOManager;
import shop.other.Reference;
import shop.Customer;
import shop.Employee;
import shop.Receipt;
import shop.products.Product;


public class Register extends FinancialAccount{
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

	public Receipt handleCheckout(Customer customer, String paymentMethod) {
		/*
		 * 1) Calculate products -- Done
		 * 2) Request payment
		 * 3) Verify payment
		 * 4) Request transfer of funds 
		 * 5) Create, Save, & Print receipt
		 */
		
		int totalCost = calculateCost(customer.getCart());
		
		
		return null;
	}
	
	String requestPaymentMethod() {
		return IOManager.getInstance().selectFromArray("Please select from the following payment methods:", (ArrayList<String>) Arrays.asList(Reference.getPAYMENTMETHODS()));
	}

	int calculateCost(ArrayList<Product> cart) {
		int totalCost = 0;
		for (Product p : cart) {
			totalCost += p.getCurrentCost();
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