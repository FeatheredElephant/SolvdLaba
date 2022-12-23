package app.console;

import java.util.ArrayList;

import app.Shop;
import app.console.adminConsoleMenus.AdminMenu;
import app.console.adminConsoleMenus.EmployeeManagerMenu;
import app.console.adminConsoleMenus.ProductManagerMenu;
import app.exceptions.EmptyArrayListException;
import app.exceptions.HandleExitRequestException;

public class AdminConsole implements ILogin {

	Shop shop;
	
	public void login(Shop shop) {
		this.shop = shop;
		displayMenu();
	}

	public void displayMenu() {
		ArrayList<AdminMenu> options = new ArrayList<>();
		options.add(new ProductManagerMenu(shop));
		options.add(new EmployeeManagerMenu(shop));
		
		AdminMenu option = null;
		try {
			option = io.selectFromArray("Please select from the following options:", options);
		} catch (EmptyArrayListException e) {
			io.reportError("Error: " + e);
		} catch (HandleExitRequestException e) {
			return;
		}
		option.displayMenu();
		displayMenu();
	}

	
	@Override
	public String toString() {
		return "Admin Console";
	}
}
