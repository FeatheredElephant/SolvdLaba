package app;

public final class Reference {
	private static final int MINIMUMWAGE = 1500;
	private static final String[] PAYMENTMETHODS = { "Cash", "Credit", "Debit", "PayPal", "GooglePay", "ApplePay" };
	private static int id = 0;

	public static int getMINIMUMWAGE() {
		return MINIMUMWAGE;
	}

	public static String[] getPAYMENTMETHODS() {
		return PAYMENTMETHODS;
	}
	
	public static int getNewId() {
		id++;
		return id;
	}
}