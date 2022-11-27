package shop;
import java.util.*;
import shop.accounts.*;
import shop.other.IOManager;
import shop.products.*;

public class Main {
	public static final void main(String[] args) {
		/*
		IOManager io = IOManager.getInstance();		
		
		ArrayList<Product> arr = new ArrayList<>();
		arr.add(new Food("Tomato", 50));
		arr.add(new Food("Carrot", 25));
		arr.add(new Utility("Toothbrush", 400));
		
		Register r = new Register("REG1");
		
		Receipt c = new Receipt(arr, "MasterCard", 100, r);
		io.println(c);
		*/
		Inventory<Product> products = new Inventory<>();
		products.addItem(new Food("Apple", 10));
		products.addItem(new Food("Orange", 5));
		IOManager.getInstance().println(products.checkStock("Apple"));
	}
}