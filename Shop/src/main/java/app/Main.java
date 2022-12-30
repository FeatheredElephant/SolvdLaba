package app;

import app.products.Product;
import app.products.ProductType;

public class Main {
	public static final void main(String[] args) {
		Shop myShop = new Shop("myShop","123 Foo Street");
		myShop.addEmployee(new Employee("Abed", "abc123", 2000, "password"));

		ProductType apple = new ProductType("Apple", 100);
		myShop.inventory.addProduct(apple, new Product(apple));
		
		
		//ProductType orange = new ProductType("Orange", 200);
		

		//myShop.inventory.addProduct(orange, new Product(orange));
		
		myShop.openShopConsole();
		
	}
}