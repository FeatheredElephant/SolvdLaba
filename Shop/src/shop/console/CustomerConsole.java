package shop.console;
import java.util.ArrayList;

import shop.Shop;
import shop.products.*;
import shop.Customer;

public class CustomerConsole implements ILogin{
	private Customer customer;
	
	public CustomerConsole(){
		this.customer = new Customer();
	}
	
	public void login(Shop shop) {
		customer.setShop(shop);
		displayHome();
	}
	
	public void displayHome() {
		ArrayList<String> defaultActions = new ArrayList<String>();
		defaultActions.add("Make a purchase");
		defaultActions.add("Return an Item");
		
		String option = io.selectFromArray("What would you like to do?", defaultActions);
		if (option == null) return;
		switch(option) {
			case "Make a purchase":
				shoppingMenu();
				break;
			case "Return an Item":
				io.println("Functionality coming soon.");
				break;
			case "Exit Store":
				io.println("Thank you for shopping with us!");
				return;
			default:
				break;
		}
		
		displayHome();
	}
	
	public void shoppingMenu() {
		ArrayList<String> options = new ArrayList<String>();
		options.add("Add item to cart.");
		if (customer.getCart().size() > 0) {
			options.add("remove item from cart.");
			options.add("checkout");
		}
		
		String option = io.selectFromArray("Please select from the following options", options);
		if (option == null) return;
		switch(option) {
		case "Add item to cart.":
			addProductsToCart();
			break;
		case "remove item from cart":
			removeProductsFromCart();
			break;
		case "checkout":
			checkout();
		}
	}
	
	public void addProductsToCart() {
		//Select a product or request Exit.
		ProductType selectedProductType = io.selectFromArray("Please select an item to purchase.", "Product Cost Stock", customer.getShop().inventory.getAllProductTypes());
		if (selectedProductType == null) return;
		
		//How many of product?
		if (selectedProductType.getStock().size() == 0) io.println("Apologies, we are out of " + selectedProductType.getName());
		else {
			io.println("How many " + selectedProductType.getName() + "s would you like to add to your cart? (Max = " + selectedProductType.getStock().size() + ")");
			int amount = io.requestIntInRange(0, selectedProductType.getStock().size());
			for (int i=0; i<amount; i++) {
				Product product = selectedProductType.pullProduct();
				if (product == null) io.println("Error: Attempted to pull product from empty ProductType.");
				customer.addProduct(product);
			}
		}
		
		//Add to cart.
		addProductsToCart();
	}
	
	public void removeProductsFromCart() {
		Product selectedProduct = io.selectFromArray("Please select an item to remove from your cart.", "Product Cost Stock", customer.getCart());
		if (selectedProduct == null) return;
		
		
	}
	
	public void checkout() {
		
	}
}
