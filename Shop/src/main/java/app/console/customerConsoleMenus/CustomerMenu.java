package app.console.customerConsoleMenus;

import app.Customer;
import app.console.IDisplayMenu;

public abstract class CustomerMenu implements IDisplayMenu{
	private Customer user;

	public CustomerMenu(Customer user){
		setUser(user);
	}
	
	public Customer getUser() {
		return user;
	}

	public void setUser(Customer user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}