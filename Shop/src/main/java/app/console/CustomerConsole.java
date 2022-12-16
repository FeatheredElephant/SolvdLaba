package app.console;
import java.util.ArrayList;

import app.Customer;
import app.Shop;
import app.console.customerConsoleMenus.CustomerMenu;
import app.console.customerConsoleMenus.ShoppingMenu;
import app.exceptions.EmptyArrayListException;
import app.exceptions.HandleExitRequestException;

public class CustomerConsole implements ILogin{
	private Customer customer;
	
	public CustomerConsole(){
		this.customer = new Customer();
	}
	
	public void login(Shop shop) {
		customer.setShop(shop);
		displayMenu();
	}
	
	public void displayMenu() {
		ArrayList<CustomerMenu> defaultActions = new ArrayList<>();
		defaultActions.add(new ShoppingMenu(customer));
		
		CustomerMenu option = null;
		try {
			option = io.selectFromArray("What would you like to do?", defaultActions);
		} catch (EmptyArrayListException e) {
			io.reportError("Error:" + e);
		} catch (HandleExitRequestException e) {
			return;
		}
		
		option.displayMenu();
		displayMenu();
	}

	public void checkout() {

		
	}
	
	
	@Override
	public String toString() {
		return "Customer Console";
	}
}
