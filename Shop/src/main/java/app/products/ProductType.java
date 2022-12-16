package app.products;

import java.util.Objects;

public class ProductType {
	private String name;
	private int cost;
	
	public ProductType(String name, int cost){
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
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return name + " " + cost;
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