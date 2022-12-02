package shop;
import java.util.*;

import shop.other.IOManager;
import shop.products.*;

//Mistake to make customer an account. Each payment method of customer should be separate account.
public class Customer{
	ArrayList<Product> cart;
	
	static IOManager io = IOManager.getInstance();
	private Shop shop;
	
	public Customer(){
		cart = new ArrayList<Product>();
	}
	
	public Customer(Shop shop) {
		setShop(shop);
	}
	
	public ArrayList<Product> getCart() {
		return cart;
	}

	//Request user to select a product to add to their cart.
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	//Add product to cart.
	public void addProduct(Product product) {
		cart.add(product);
	}
	
	//Remove product from cart.
	public void removeProduct(Product p) {
		cart.remove(p);
		p.getType().addProduct(p);
	}
	
	//Purchase items in cart.
	public void checkout() {
		
	}
	
	//Return a purchased item.
	public void returnItem(Product p, Receipt r) {
		
	}
}