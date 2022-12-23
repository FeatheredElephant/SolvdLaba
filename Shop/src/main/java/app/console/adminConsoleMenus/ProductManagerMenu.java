package app.console.adminConsoleMenus;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import app.Shop;
import app.products.ProductType;

public class ProductManagerMenu extends AdminMenu{

	public ProductManagerMenu(Shop shop){
		super(shop);
	}
	
	public void displayMenu() {
		//Displays currently existing products
		ArrayList<ProductType> productTypes = getShop().inventory.getAllProductTypes();
		io.displayList(productTypes);
		
		//Requests from user name of product to edit
		io.println("Name of product to edit? (0 to Exit)");
		String name = io.requestString();
		
		if (name.equals("0")) return;
		
		ProductType pt;
		try {
			//Looks for named product in inventory.
			pt = productTypes.stream()
					.filter((type) -> type.getName().equalsIgnoreCase(name))
					.findAny()
					.get();
		} catch (NoSuchElementException e) {
			//If productType not in inventory, asks if you would like to add a new productType.
			if (io.yesOrNo("Name not found in list. Would you like to create a new ProductType?")) {
				pt = createProductType(name);
			}
			else return;
		}
		EditProductMenu epm = new EditProductMenu(getShop(), pt);
		epm.displayMenu();
		displayMenu();
	}
	
	//Creates new ProductType
	ProductType createProductType(String name) {
		io.println("Cost? (cents)");
		int cost = io.requestInt();
		return new ProductType(name, cost);
	}
}