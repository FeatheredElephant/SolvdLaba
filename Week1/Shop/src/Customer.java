import java.util.*;

//Mistake to make customer an account. Each payment method of customer should be separate account.
public class Customer extends Account {
	private Shop currentShop;
	private ArrayList<Product> cart;

	Customer() {
		cart = new ArrayList<Product>();
	}

	void addFunds(int amount) {
		this.funds += amount;
	}

	ArrayList<Product> getCart() {
		return cart;
	}
	
	void selectProducts() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("What would you like to add to your cart?");
		ArrayList<Product> products = currentShop.getProducts();
		int index = 0;
		System.out.println("-1. Exit Store");
		System.out.println(" 0. Checkout");
		for (Product p: products) {
			System.out.println(" " + (index + 1) + ". " + p.getName() + " " + p.getCost());
			index ++;
		}
		int input = scanner.nextInt() - 1;
		switch(input) {
			case(-2):
				exitShop();
				break;
			case(-1):
				checkout();
				break;
			default:
				if (input >= currentShop.getProducts().size()) {
					System.out.println("Input outside of available options. Please select a valid option.\n");
				}
				else {
					addProduct(currentShop.getProduct(input));
				}
				selectProducts();
		}
	}
	
	void addProduct(Product p) {
		cart.add(p);
		System.out.println(p.getName() + " has been added to your cart.");
	}

	void removeProduct(Product p) {
		if (!cart.remove(p)) {
			System.out.println("Error: Attempted to remove product that wasn't in cart.");
		}
	}

	void visitShop(Shop shop) {
		System.out.println("Welcome to " + shop.getName() + "!");
		this.currentShop = shop;
		cart = new ArrayList<Product>();
	}
	
	void exitShop() {
		System.out.println("Thank you for shopping with " + currentShop.getName() + ", have a nice day!");
		cart = null;
		currentShop = null;
	}

	void checkout() {
		if (cart.isEmpty()) {
			
		}
		currentShop.handleCheckout(this);
	}
}