package app;

import app.products.Product;
import app.products.ProductType;
import wordcounter.WordCounter;

public class Main {
	public static final void main(String[] args) {
		/*
		Shop myShop = new Shop("myShop","123 Foo Street");
		myShop.addEmployee(new Employee("Abed", "abc123", 2000, "password"));
		
		ProductType apple = new ProductType("Apple", 100);
		//ProductType orange = new ProductType("Orange", 200);
		
		myShop.inventory.addProduct(apple, new Product(apple));
		//myShop.inventory.addProduct(orange, new Product(orange));
		
		myShop.openShopConsole();
		*/
		
		WordCounter w = new WordCounter();
		System.out.println(System.getProperty("user.dir"));
		w.countWords("./src/main/resources/inputTestFile.txt", "./src/main/resources");
	}
}