package app.products;

import java.util.Stack;

public class ProductStack extends Stack<Product>{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return size() + "";
	}
}
