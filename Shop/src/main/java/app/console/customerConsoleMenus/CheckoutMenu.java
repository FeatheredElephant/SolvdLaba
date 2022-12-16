package app.console.customerConsoleMenus;

import app.Customer;

public class CheckoutMenu extends CustomerMenu{
	
	public CheckoutMenu(Customer user) {
		super(user);
	}

	@Override
	public void displayMenu() {
		/*
		 * 1. Select Register
		 * 2. Register calculates total cost
		 * 2. Confirm purchase (list items & total cost) with customer
		 * 3. Request payment
		 * 4. 
		 */
		
	}

	@Override
	public String toString() {
		return "Checkout";
	}
}
