package app.model.domains;

import java.util.Objects;

public class Payment {
	int paymentId;
	float amount;
	int personId;

	public Payment(int paymentId, float amount, int personId) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.personId = personId;
	}
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(paymentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return paymentId == other.paymentId;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", amount=" + amount + ", personId=" + personId + "]";
	}
}
