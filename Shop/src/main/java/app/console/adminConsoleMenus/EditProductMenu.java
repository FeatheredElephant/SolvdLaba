package app.console.adminConsoleMenus;

import java.util.HashMap;

import app.Shop;
import app.exceptions.EmptyHashMapException;
import app.exceptions.HandleExitRequestException;
import app.exceptions.RequestFromEmptyException;
import app.products.Inventory;
import app.products.Product;
import app.products.ProductType;

public class EditProductMenu extends AdminMenu {
	
	private ProductType productType;
	public EditProductMenu(Shop shop, ProductType productType) {
		super(shop);
		this.productType = productType;
	}

	@Override
	public void displayMenu() {
		HashMap<String, IHandle<ProductType>> options = new HashMap<>();
		options.put("Add product stock", (pt)-> addProductStock(productType));
		options.put("Reduce product stock", (pt) -> reduceProductStock(productType));
		options.put("Change cost of product", (pt) -> changeCostOfProduct(productType));
		IHandle<ProductType> option = null;;
		try {
			option = options.get(io.selectFromHashMap("What would you like to do?", options));
		} catch (EmptyHashMapException e) {
			io.reportError(e);
			e.printStackTrace();
		} catch (HandleExitRequestException e) {
			return;
		}
		option.handle(productType);
	}
	
	//Reduces stock of product
	void reduceProductStock(ProductType productType) {
		int currentStock = getShop().inventory.getStockSize(productType);
		
		io.println("amount of stock to remove? (Current stock = " + currentStock + ")");
		int stockReduction = io.requestIntInRange(0, currentStock);
		for (int i=0; i < stockReduction; i++) {
			try {
				getShop().inventory.popProduct(productType);
			} catch (RequestFromEmptyException e) {
				io.reportError(e);
				e.printStackTrace();
			}
		}
	}
	
	//Increases stock of product
	void addProductStock(ProductType productType) {
		io.println("amount to add to stock?");
		int stockIncrease = io.requestIntInRange(0, 10000);
		Inventory inventory = getShop().inventory;
		for (int i = 0; i < stockIncrease; i++) {
			inventory.addProduct(productType, new Product(productType));
		}
		io.println(stockIncrease + " " + productType.getName() + "s added.");
	}
	
	void changeCostOfProduct(ProductType productType) {
		io.println("Current cost:" + productType.getCost());
		io.println("New Cost?");
		productType.setCost(io.requestInt());
	}
}
