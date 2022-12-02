package shop;

import shop.products.*;

public class Main {
	public static final void main(String[] args) {
		Shop myShop = new Shop("myShop","123 Foo Street");
		myShop.addEmployee(new Employee("Abed", "abc123", 2000, "password"));
		myShop.inventory.addProduct(new Product(new ProductType("Apple", 100), "apple0"));
		myShop.inventory.addProduct(new Product(new ProductType("Orange", 150), "orange0"));
		myShop.openShopConsole();
	}
}