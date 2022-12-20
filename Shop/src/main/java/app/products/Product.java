package app.products;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Random;

public class Product {
	private ProductType type;
	private String id;
	private String supplier;
	private static AtomicInteger baseId;
	
	public Product(ProductType type) {
		this.type = type;
		generateNewId();
		this.supplier = "";
	}
	
	public Product(ProductType type, String supplier){
		this.type = type;
		generateNewId();
		this.supplier = supplier;
	}
	
	public ProductType getType() {
		return type;
	}
	
	public String getName() {
		return type.getName();
	}
	
	public String getId() {
		return id;
	}
	
	public void generateNewId() {
		Random r = new Random();
		id = "" + baseId.addAndGet(r.nextInt(100));
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