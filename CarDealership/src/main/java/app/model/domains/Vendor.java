package app.model.domains;

import java.util.Objects;

public class Vendor{
	int vendorId;
	int userId;
	
	public Vendor(int vendorId, int userId) {
		super();
		this.vendorId = vendorId;
		this.userId = userId;
	}public Vendor() {
		// TODO Auto-generated constructor stub
	}
	
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(vendorId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendor other = (Vendor) obj;
		return vendorId == other.vendorId;
	}
	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", userId=" + userId + "]";
	}
}
