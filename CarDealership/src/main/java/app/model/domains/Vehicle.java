package app.model.domains;

import java.util.Objects;

public class Vehicle {
	int vehicleId;
	int year;
	int modelId;
	int colorId;
	float price;

	public Vehicle(int vehicleId, int year, int modelId, int colorId, float price) {
		super();
		this.vehicleId = vehicleId;
		this.year = year;
		this.modelId = modelId;
		this.colorId = colorId;
		this.price = price;
	}

	public Vehicle() {
		
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(vehicleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return vehicleId == other.vehicleId;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", year=" + year + ", modelId=" + modelId + ", colorId=" + colorId
				+ ", price=" + price + "]";
	}

}
