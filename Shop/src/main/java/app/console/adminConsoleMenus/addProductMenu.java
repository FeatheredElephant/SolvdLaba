package app.console.adminConsoleMenus;

import java.util.ArrayList;

import app.Shop;
import app.products.Inventory;
import app.products.Product;
import app.products.ProductType;

public class addProductMenu extends AdminMenu {

	public addProductMenu(Shop shop) {
		super(shop);
	}

	public void displayMenu() {
		ArrayList<ProductType> productTypes = getShop().inventory.getAllProductTypes();
		io.displayList(productTypes);

		io.println("Name?");
		String name = io.requestString();

		ProductType pt = productTypes.stream()
				.filter((type) -> type.getName().equalsIgnoreCase(name))
				.findAny().get();

		if (pt != null) {
			addProduct(pt);
			return;
		}
		if (io.yesOrNo("Name not found in list. Would you like to create a new ProductType?")) {
			createProductType(name);
			return;
		}
	}

	void createProductType(String name) {
		io.println("Cost? (cents)");
		int cost = io.requestInt();
		addProduct(new ProductType(name, cost));

	}

	void addProduct(ProductType productType) {
		io.println("amount to add?");
		int stock = io.requestIntInRange(1, 10000);
		Inventory inventory = getShop().inventory;
		for (int i = 0; i < stock; i++) {
			inventory.addProduct(productType, new Product(productType));
		}
		io.println(stock + " " + productType.getName() + "s added.");
	}
}