package app.products;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import app.IOManager;
import app.exceptions.RequestFromEmptyException;

public class Inventory{

	private HashMap<ProductType, ProductStack> inventory;
	ExecutorService executor = Executors.newCachedThreadPool();
	
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
		var e = inventory.entrySet().parallelStream()
			.filter(entry -> entry.getKey().getName().equalsIgnoreCase(name))
			.findAny()
			.get();
		return e.getKey();
	}
	
	public void addProduct(ProductType type, Product product) {
		executor.execute(() -> {
			if (!inventory.containsKey(type)) {
				inventory.put(type, new ProductStack());
			}
			ProductStack productStack = inventory.get(type);
			if (productStack.search(product) == -1) productStack.push(product);
		});
	}
	
	public Product popProduct(ProductType type) throws RequestFromEmptyException{
		Future<Product> poppedProduct = executor.submit(() -> {
			ProductStack products = inventory.get(type);
			if (products.empty()) throw new RequestFromEmptyException("Attempted to pull from empty ProductStack");
			return products.pop();
		});
		
		while(true) {
			try {
				return poppedProduct.get();
			} catch (InterruptedException e) {
				IOManager.getInstance().reportError(e);
				e.printStackTrace();
			} catch (ExecutionException e) {
				IOManager.getInstance().reportError(e);
				e.printStackTrace();
			}
		}
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