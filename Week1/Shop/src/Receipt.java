import java.util.ArrayList;

public class Receipt {
	ArrayList<Product> purchasedProducts;
	String paymentMethod;
	int fundsTransfered;
	Register register;
	Employee cashier;

	Receipt(ArrayList<Product> purchasedProducts, String paymentMethod, int fundsTransfered, Register register) {
		this.purchasedProducts = purchasedProducts;
		this.paymentMethod = paymentMethod;
		this.fundsTransfered = fundsTransfered;
		this.register = register;
		this.cashier = register.getCashier();
	}

	void printReceipt() {
		System.out.println("Goods: ");
		for (Product p : purchasedProducts) {
			System.out.println("  " + p.getName() + "  " + p.getCost());
		}
		System.out.println("Total: " + fundsTransfered);
		System.out.println("Register: " + register.getId());
		System.out.println("Serviced by: " + cashier.getName());
	}
}