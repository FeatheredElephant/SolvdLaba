package shop.products;
import java.util.*;

public class Inventory {
	private ArrayList<ProductType> inventory;
	
	public Inventory(){
		inventory = new ArrayList<>();
	}
	
	//Returns all ProductTypes in inventory.
	public ArrayList<ProductType> getAllProductTypes(){
		return inventory;
	}
	
	//Searches inventory for ProductType with name.
	public ProductType getProductType(String name) {
		for (ProductType pt: inventory) {
			if (pt.getName().equalsIgnoreCase(name)) {
				return pt;
			}
		}
		return null;
	}
	
	//If ProductType does not exist in inventory, adds ProductType.
	//Adds product to productType stock
	public void addProduct(Product product) {
		ProductType pt = product.getType();
		if (!inventory.contains(pt)){
			inventory.add(pt);
		}
		pt.addProduct(product);
	}
	
	//removes product from associated ProductType stock
	public void removeProduct(Product product) {
		ProductType pt = product.getType();
		pt.removeProduct(product);
	}
}
