package app.console.adminConsoleMenus;

import java.util.ArrayList;

import app.Shop;
import app.exceptions.EmptyArrayListException;
import app.exceptions.HandleExitRequestException;

public class ProductManagerMenu extends AdminMenu{

	public ProductManagerMenu(Shop shop){
		super(shop);
	}
	
	public void displayMenu() {
		ArrayList<AdminMenu> options = new ArrayList<>();
		options.add(new addProductMenu(getShop()));
		options.add(new removeProductMenu(getShop()));
		options.add(new editProductTypeMenu(getShop()));
		
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
}