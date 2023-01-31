package app.model.domains;

import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;

public class Customer {

	int customerId;

	int userId;

	public Customer(int customerId, int userId) {
		this.customerId = customerId;
		this.userId = userId;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@XmlElement(name = "userId")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return customerId == other.customerId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", userId=" + userId + "]";
	}
}
