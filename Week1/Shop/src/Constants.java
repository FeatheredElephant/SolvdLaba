
public final class Constants {
	private static final int MINIMUMWAGE = 1500;
	private static final String[] PAYMENTMETHODS = { "Cash", "Credit", "Debit", "PayPal", "GooglePay", "ApplePay" };

	public static int getMINIMUMWAGE() {
		return MINIMUMWAGE;
	}

	public static String[] getPAYMENTMETHODS() {
		return PAYMENTMETHODS;
	}
}