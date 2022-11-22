public abstract class Product {
	private String name;
	private int cost;
	private int stock;

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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	Product(String name, int cost, int stock) {
		this.name = name;
		this.cost = cost;
		this.stock = stock;
	}
}