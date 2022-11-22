import Accounts.Register;
import Products.Food;
import Products.Utility;

public class Main {
	public static final void main(String[] args) {
		Shop myShop = new Shop("TheShop", "123 Solvd Ave.");
		
		myShop.addEmployee(new Employee("Maria", "123ABC", 3000, "manager"));
		myShop.addEmployee(new Employee("Mark", "234BCE", 2000, "cashier"));
		myShop.addEmployee(new Employee("Shawn", "FOOBAR123", 2000, "cashier"));
		
		myShop.addRegister(new Register("REG1"));
		myShop.addRegister(new Register("REG2"));
		myShop.addRegister(new Register("REG3"));
		
		myShop.getRegister(0).setCashier(myShop.getEmployee(1));
		myShop.getRegister(2).setCashier(myShop.getEmployee(2));
		
		myShop.addProduct(new Food("Apple", 50, 10));
		myShop.addProduct(new Food("Tomato", 100, 10));
		myShop.addProduct(new Food("Bannana", 40, 10));
		myShop.addProduct(new Food("Carrot", 20, 10));
		myShop.addProduct(new Utility("Paper Towel", 200, 5));
		
		Customer you = new Customer();
		you.visitShop(myShop);
		you.selectProducts();
	}
}

/*
 * Issues to fix:
 * - Inventory is untracked.
 * - Customer payment validity is untracked.
 * - Customer can checkout without having chosen any items.
 * - 
 */
*/