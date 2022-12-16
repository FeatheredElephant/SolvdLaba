package app.console.customerConsoleMenus;

import java.util.ArrayList;

import app.Customer;
import app.console.IDisplayMenu;
import app.exceptions.EmptyArrayListException;
import app.exceptions.HandleExitRequestException;

public class ShoppingMenu extends CustomerMenu{
	
	public ShoppingMenu(Customer user){
		super(user);
	}
	
	public void displayMenu() {
		ArrayList<CustomerMenu> options = new ArrayList<>();
		options.add(new AddProductsMenu(getUser()));
		if (getUser().getCart().size() > 0) {
			options.add(new RemoveProductsMenu(getUser()));
			options.add(new CheckoutMenu(getUser()));
		}
		
		IDisplayMenu option = null;
		try {
			option = io.selectFromArray("Please select from the following options", options);
		} catch (EmptyArrayListException e) {
			io.reportError("Error:" + e);
		} catch (HandleExitRequestException e) {
			return;
		}

		option.displayMenu();
		displayMenu();
	}
	
	@Override
	public String toString() {
		return "Shopping Menu";
	}
}
