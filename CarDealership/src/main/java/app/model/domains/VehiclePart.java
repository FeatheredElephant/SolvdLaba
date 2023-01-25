package app.model.domains;

import java.util.Objects;

public class VehiclePart {
	int partId;
	int partTypeId;

	public VehiclePart(int partId, int partTypeId) {
		super();
		this.partId = partId;
		this.partTypeId = partTypeId;
	}
	public VehiclePart() {
		// TODO Auto-generated constructor stub
	}
	public int getPartId() {
		return partId;
	}
	public void setPartId(int partId) {
		this.partId = partId;
	}
	public int getPartTypeId() {
		return partTypeId;
	}
	public void setPartTypeId(int partTypeId) {
		this.partTypeId = partTypeId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(partId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehiclePart other = (VehiclePart) obj;
		return partId == other.partId;
	}
	@Override
	public String toString() {
		return "VehiclePart [partId=" + partId + ", partTypeId=" + partTypeId + "]";
	}
}
