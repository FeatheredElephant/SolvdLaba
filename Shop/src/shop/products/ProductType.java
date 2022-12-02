package shop.products;

import java.util.*;

public class ProductType {
	private String name;
	private int cost;
	private ArrayList<Product> stock;
	
	public ProductType(String name, int cost){
		this.name = name;
		this.cost = cost;
		stock = new ArrayList<Product>();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}

	public ArrayList<Product> getStock() {
		return stock;
	}
	
	public Product pullProduct() {
		if (stock.isEmpty()) return null;
		
		Product pulledProduct = stock.get(0);
		stock.remove(pulledProduct);
		return pulledProduct;
	}
	
	//Adds product to stock.
	public void addProduct(Product product) {
		if (stock.contains(product)) return;
		stock.add(product);
	}
	
	//Removes product from stock.
	public void removeProduct(Product product) {
		stock.remove(product);
	}
	
	@Override
	public String toString() {
		return name + " " + cost + " " + stock.size();
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductType other = (ProductType) obj;
		return Objects.equals(name, other.name);
	}
}