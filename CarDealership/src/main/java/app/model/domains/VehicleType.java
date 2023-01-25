package app.model.domains;

import java.util.Objects;

public class VehicleType {
	int vehicleTypeId;
	String name;
	public VehicleType(int vehicleTypeId, String name) {
		super();
		this.vehicleTypeId = vehicleTypeId;
		this.name = name;
	}public VehicleType() {
		// TODO Auto-generated constructor stub
	}
	public int getVehicleTypeId() {
		return vehicleTypeId;
	}
	public void setVehicleTypeId(int vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(vehicleTypeId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleType other = (VehicleType) obj;
		return vehicleTypeId == other.vehicleTypeId;
	}
	@Override
	public String toString() {
		return "VehicleType [vehicleTypeId=" + vehicleTypeId + ", name=" + name + "]";
	}
}
