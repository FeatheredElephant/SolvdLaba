package app.console.customerConsoleMenus;

import app.Customer;
import app.exceptions.EmptyHashMapException;
import app.exceptions.HandleExitRequestException;
import app.exceptions.RequestFromEmptyException;
import app.products.Inventory;
import app.products.Product;
import app.products.ProductType;

public class AddProductsMenu extends CustomerMenu{
	
	public AddProductsMenu(Customer user){
		super(user);
	}
	
	public void displayMenu() {
		Inventory shopInventory = getUser().getShop().inventory;
		
		//Select a product or request Exit.
		ProductType selectedProductType = null;
		try {
			selectedProductType = io.selectFromHashMap("Please select an item to purchase.", "Product Cost", shopInventory.getInventory());
		} catch (EmptyHashMapException e) {
			io.reportError("Error:" + e);
		} catch (HandleExitRequestException e) {
			return;
		}
		
		
		//Check if out of stock.
		if (shopInventory.getStockSize(selectedProductType) == 0) {
			io.println("Apologies, we are out of " + selectedProductType.getName() + ".");
			displayMenu();
			return;
		}
		
		//Add how many individual products of Product Type to cart?
		io.println("How many " + selectedProductType.getName() + "s would you like to add to your cart? (Max = " + shopInventory.getStockSize(selectedProductType) + ")");
		int amount = io.requestIntInRange(0, shopInventory.getStockSize(selectedProductType));
		for (int i=0; i<amount; i++) {
			Product product = null;
			try {
				product = shopInventory.popProduct(selectedProductType);
				getUser().addProduct(product);
			} catch (RequestFromEmptyException e) {
				io.reportError("Attempted to pull from empty ProductStack: " + selectedProductType);
			}
		}
		
		displayMenu();
	}

	@Override
	public String toString() {
		return "Add Products to Cart";
	}
}