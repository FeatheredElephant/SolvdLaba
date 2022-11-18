//Accounts are anything that money can be transferred to and from.
public abstract class Account {
	int funds;
	
	public int getFunds() {
		return funds;
	}
	
	public int withdrawFunds(int amount) {
		if (amount > funds) {
			System.out.println("Error, attempted to withdraw invalid amount from register: " + amount);
			return 0;
		}
		
		funds -= amount;
		return amount;
	}
	
	public void depositFunds(int amount) {
		if (amount < 0) {
			System.out.println("Error, attempted to deposit invalid amount into register: " + amount);
			return;
		}
		
		this.funds += amount;
	}
}