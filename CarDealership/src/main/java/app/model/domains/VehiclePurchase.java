package app.model.domains;

import java.util.Objects;

public class VehiclePurchase {
	int purchaseId;
	int vehicleId;
	int vendorId;
	float cost;

	public VehiclePurchase(int purchaseId, int vehicleId, int vendorId, float cost) {
		super();
		this.purchaseId = purchaseId;
		this.vehicleId = vehicleId;
		this.vendorId = vendorId;
		this.cost = cost;
	}

	public VehiclePurchase() {
		// TODO Auto-generated constructor stub
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		return Objects.hash(purchaseId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehiclePurchase other = (VehiclePurchase) obj;
		return purchaseId == other.purchaseId;
	}

	@Override
	public String toString() {
		return "VehiclePurchase [purchaseId=" + purchaseId + ", vehicleId=" + vehicleId + ", vendorId=" + vendorId
				+ ", cost=" + cost + "]";
	}
}
