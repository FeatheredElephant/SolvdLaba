package app.model.domains;

import java.util.Objects;

public class VehicleSale {
	int saleId;
	int customerId;
	int vehicleId;
	float discount;
	float total;

	public VehicleSale(int saleId, int customerId, int vehicleId, float discount, float total) {
		super();
		this.saleId = saleId;
		this.customerId = customerId;
		this.vehicleId = vehicleId;
		this.discount = discount;
		this.total = total;
	}

	public VehicleSale() {
		// TODO Auto-generated constructor stub
	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(saleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleSale other = (VehicleSale) obj;
		return saleId == other.saleId;
	}

	@Override
	public String toString() {
		return "VehicleSale [saleId=" + saleId + ", customerId=" + customerId + ", vehicleId=" + vehicleId
				+ ", discount=" + discount + ", total=" + total + "]";
	}
}
