package app.model.domains;

import java.util.Objects;

public class VehiclePartPurchase {
	int partPurchaseId;
	int vendorId;
	int partId;

	public VehiclePartPurchase(int partPurchaseId, int vendorId, int partId) {
		super();
		this.partPurchaseId = partPurchaseId;
		this.vendorId = vendorId;
		this.partId = partId;
	}

	public VehiclePartPurchase() {
		// TODO Auto-generated constructor stub
	}

	public int getPartPurchaseId() {
		return partPurchaseId;
	}

	public void setPartPurchaseId(int partPurchaseId) {
		this.partPurchaseId = partPurchaseId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(partPurchaseId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehiclePartPurchase other = (VehiclePartPurchase) obj;
		return partPurchaseId == other.partPurchaseId;
	}
	
	@Override
	public String toString() {
		return "VehiclePartPurchase [partPurchaseId=" + partPurchaseId + ", vendorId=" + vendorId + ", partId=" + partId
				+ "]";
	}

}
