package app.finance;
import java.util.Objects;

import app.IOManager;
//Accounts are anything that money can be transferred to and from.
public abstract class FinancialAccount implements IGetPaid, IPay{
	private String id;
	private int funds;
	
	FinancialAccount(String id){
		this.id = id;
		funds = 0;
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

	@Override
	public String toString() {
		return "Account [id=" + id + ", funds=" + funds + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FinancialAccount other = (FinancialAccount) obj;
		return Objects.equals(id, other.id);
	}
}