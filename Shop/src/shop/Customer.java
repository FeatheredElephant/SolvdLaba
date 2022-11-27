package shop;
import java.util.*;

import shop.accounts.*;
import shop.products.Product;

//Mistake to make customer an account. Each payment method of customer should be separate account.
public class Customer{
	private HashMap<Product, Integer> cart;
	
	public Customer() {
		cart = new ArrayList<Product>();
	}
	
	void addProductToCart(Product p) {

	}
	
	boolean removeProductFromCart(Product p) {

	}
	
	void checkout() {

	}
	
}