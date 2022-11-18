
public class Customer extends Account{
	Boolean isMember;
	void addFunds(int amount){
		this.funds += amount;
	}
	void updateMembershipStatus(Boolean b) {
		isMember = b;
	}
}