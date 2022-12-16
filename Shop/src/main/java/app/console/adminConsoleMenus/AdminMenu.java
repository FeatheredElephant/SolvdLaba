package app.console.adminConsoleMenus;

import app.Shop;
import app.console.IDisplayMenu;

public abstract class AdminMenu implements IDisplayMenu{
	private Shop shop;

	public AdminMenu(Shop shop){
		this.shop = shop;
	}
	
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
