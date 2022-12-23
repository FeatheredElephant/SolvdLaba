package app.products;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Set;

import app.exceptions.RequestFromEmptyException;

public class Inventory {

	private HashMap<ProductType, ProductStack> inventory;
	
	public Inventory() {
		inventory = new HashMap<>();
	}
	
	public HashMap<ProductType, ProductStack> getInventory(){
		return inventory;
	}
	
	public ArrayList<ProductType> getAllProductTypes(){
		return new ArrayList<ProductType>(inventory.keySet());
	}
	
	public ProductType getProductType(String name) throws NoSuchElementException{
		var e = inventory.entrySet().stream()
			.filter(entry -> entry.getKey().getName().equalsIgnoreCase(name))
			.findAny()
			.get();
		return e.getKey();
	}
	
	public void addProduct(ProductType type, Product product) {
		if (!inventory.containsKey(type)) {
			inventory.put(type, new ProductStack());
		}
		ProductStack productStack = inventory.get(type);
		if (productStack.search(product) == -1) productStack.push(product);
	}
	
	public Product popProduct(ProductType type) throws RequestFromEmptyException{
		ProductStack products = inventory.get(type);
		if (products.empty()) throw new RequestFromEmptyException("Attempting to pull from empty ProductStack");
		return products.pop();
	}
	
	public int getStockSize(ProductType type) {
		return inventory.get(type).size();
	}

	@Override
	public String toString() {
		String output = "";
		Set<ProductType> types = inventory.keySet();
		for (ProductType type: types) {
			output += type.getName() + " " + type.getCost() + " " + inventory.get(type).size() + "\n";
		}
		return output;
	}
}