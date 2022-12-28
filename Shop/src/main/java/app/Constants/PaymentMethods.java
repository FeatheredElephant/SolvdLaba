package app.Constants;

public enum PaymentMethods {
	CASH("Cash"), 
	CREDIT("Credit", 10), 
	DEBIT("Debit"), 
	PAYPAL("Paypal"), 
	PAYMENTAPP("Payment App");
	
	private String name;
	private int additionalChargeAmount;
	
	PaymentMethods(String name){
		this.name = name;
		this.additionalChargeAmount = 0;
	}
	
	PaymentMethods(String name, int additionalChargeAmount){
		this.name = name;
		this.additionalChargeAmount = additionalChargeAmount;
	}
	
	int getAdditionalChargeAmount() {
		return additionalChargeAmount;
	}
	
	@Override
	public String toString() {
		return name;
	}
}