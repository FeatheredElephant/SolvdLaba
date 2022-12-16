package app;
import java.util.ArrayList;

import app.products.Product;

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
	
	//Empties the cart by declaring new ArrayList. (returns old cart)
	public ArrayList<Product> EmptyCart() {
		ArrayList<Product> r = cart;
		cart = new ArrayList<Product>();
		return r;
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
	public void returnProductFromCart(Product p) {
		shop.inventory.addProduct(p.getType(), p);
		cart.remove(p);
	}
	
	//Return a purchased item.
	public void returnItem(Product p, Receipt r) {
		
	}
}