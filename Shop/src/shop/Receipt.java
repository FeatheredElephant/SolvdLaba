package shop;
import java.util.ArrayList;

import shop.finance.*;
import shop.products.*;

public class Receipt {
	private ArrayList<Product> purchasedProducts;
	private String paymentMethod;
	private int fundsTransfered;
	private Register register;
	private Employee cashier;

	public Receipt(ArrayList<Product> purchasedProducts, String paymentMethod, int fundsTransfered, Register register) {
		this.purchasedProducts = purchasedProducts;
		this.paymentMethod = paymentMethod;
		this.fundsTransfered = fundsTransfered;
		this.register = register;
		this.cashier = register.getCashier();
	}
	
	@Override
	public String toString() {
		String s = "Total Cost: " + fundsTransfered + "\n";
		for (Product p: purchasedProducts) {
			s += " " + p.toString() + "\n";
		}
		s += "payment method: " + paymentMethod + "\n";
		s += "register: " + register + "\n";
		s += "serviced by: " + cashier + "\n";
		return s;
	}
}