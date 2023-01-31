package app.model.domains;

import java.util.Objects;

public class VehicleModel {
	int modelId;
	String name;
	int brandId;
	int vehicleTypeId;

	public VehicleModel(int modelId, String name, int brandId, int vehicleTypeId) {
		super();
		this.modelId = modelId;
		this.name = name;
		this.brandId = brandId;
		this.vehicleTypeId = vehicleTypeId;
	}

	public VehicleModel() {
	
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(int vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(modelId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleModel other = (VehicleModel) obj;
		return modelId == other.modelId;
	}

	@Override
	public String toString() {
		return "VehicleModel [modelId=" + modelId + ", name=" + name + ", brandId=" + brandId + ", vehicleTypeId="
				+ vehicleTypeId + "]";
	}
}
