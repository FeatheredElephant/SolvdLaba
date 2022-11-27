package shop.accounts;
import shop.other.IOManager;
//Accounts are anything that money can be transferred to and from.
public abstract class Account {
	private int funds;
	private String id;
	
	public Account(String id){
		funds = 0;
		this.id = id;
	}
	
	public int getFunds() {
		return funds;
	}
	
	public String getId() {
		return id;
	}
	
	public int withdrawFunds(int amount) {
		if (amount > funds) {
			IOManager.getInstance().println("Error, attempted to withdraw invalid amount from register: " + amount);
			return 0;
		}

		funds -= amount;
		return amount;
	}

	public void depositFunds(int amount) {
		if (amount < 0) {
			IOManager.getInstance().println("Error, attempted to deposit invalid amount into register: " + amount);
			return;
		}
		this.funds += amount;
	}
}