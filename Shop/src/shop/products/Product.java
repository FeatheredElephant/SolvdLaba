package shop.products;

import java.util.Objects;

public class Product {
	private String name;
	private int cost;

	public Product(String name, int cost) {
		this.name = name;
		this.cost = cost;
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
		if (cost > 0)
			this.cost = cost;
	}

	@Override
	public String toString() {
		return (name + ": " + cost);
	}
	
	public static String sampleToString() {
		
		return "Name: Cost";
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
		Product other = (Product) obj;
		return Objects.equals(name, other.name);
	}
}