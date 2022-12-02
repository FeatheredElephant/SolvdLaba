package shop.products;

import java.util.Objects;

public class Product {
	private ProductType type;
	private String id;
	private String supplier;
	
	public Product(ProductType type, String id){
		this.type = type;
		this.id = id;
		this.supplier = "";
	}
	
	public Product(ProductType type, String id, String supplier){
		this.type = type;
		this.id = id;
		this.supplier = supplier;
	}
	
	public ProductType getType() {
		return type;
	}
	
	public String getName() {
		return type.getName();
	}
	
	public int getCurrentCost() {
		return type.getCost();
	}
	
	public int getCurrentStock() {
		return type.getStock().size();
	}

	@Override
	public String toString() {
		return type.getName() + " " + id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, supplier, type);
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
		return Objects.equals(id, other.id) && Objects.equals(supplier, other.supplier)
				&& Objects.equals(type, other.type);
	}
}