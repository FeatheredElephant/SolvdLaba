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
		
		Customer you = new Customer();
		you.visitShop(myShop);
		you.selectProducts();
	}
}

/*
 * Here are some tasks for you: - Create a class hierarchy (10-15 classes).
 * Topic - Shop. For example simple app to store info about goods, employees,
 * customers, receipts etc. I want to be able to select goods that I want to
 * buy. - Create some kind of menu in console for interaction with your app:
 * adding, editing, deleting data. - Add 5 interfaces to the existing hierarchy.
 * - Use polymorphism with the abstract class and interface from the hierarchy.
 * - Use final class, method, variable. - Use a static block, method, variable.
 * 
 * Shop Employee - Manager Good - Food --Perishable - Giftcard Customer - Member
 * Receipt Register Savings
 */