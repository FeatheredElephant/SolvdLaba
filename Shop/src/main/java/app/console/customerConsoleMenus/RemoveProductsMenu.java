package app.console.customerConsoleMenus;

import app.Customer;
import app.exceptions.EmptyArrayListException;
import app.exceptions.HandleExitRequestException;
import app.products.Product;

public class RemoveProductsMenu extends CustomerMenu{
	public RemoveProductsMenu(Customer user){
		super(user);
	}
	
	public void displayMenu() {
		Product selectedProduct = null;
		try {
			selectedProduct = io.selectFromArray("Please select an item to remove from your cart.", "Product Cost Stock", getUser().getCart());
		} catch (EmptyArrayListException e) {
			io.reportError("Error:" + e);
		} catch (HandleExitRequestException e) {
			return;
		}
		
		getUser().returnProductFromCart(selectedProduct);
		io.println("Product removed.");
		displayMenu();
	}

	@Override
	public String toString() {
		return "Remove Products from Cart";
	}
}