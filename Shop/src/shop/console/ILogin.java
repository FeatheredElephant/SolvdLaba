package shop.console;
import shop.Shop;
import shop.other.IOManager;

public interface ILogin {
	public final static IOManager io = IOManager.getInstance();
	
	public void login(Shop shop);
}
