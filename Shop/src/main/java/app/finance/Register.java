package app.finance;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.Employee;
import app.IOManager;
import app.exceptions.EmptyArrayListException;
import app.exceptions.HandleExitRequestException;
import app.products.Product;
import app.Constants.*;


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
	
	PaymentMethods requestPaymentMethod() {
		try {
			return IOManager.getInstance().selectFromArray("Please select from the following payment methods:", new ArrayList<PaymentMethods>(Arrays.asList(PaymentMethods.values())));
		} catch (EmptyArrayListException e) {
			IOManager.getInstance().reportError("Error: " + e);
		} catch (HandleExitRequestException e) {
			return null;
		}
		return null;
	}

	int calculateTotalCost(ArrayList<Product> cart) {
		int totalCost = 0;
		for (Product p : cart) {
			totalCost += p.getType().getCost();
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
	
}