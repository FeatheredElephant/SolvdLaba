package shop;
import shop.products.*;
public class ProductInventory extends Inventory<Product>{
	Integer checkStock(String name) {
		return checkStock(new Product("name", -1));
	}
	
}