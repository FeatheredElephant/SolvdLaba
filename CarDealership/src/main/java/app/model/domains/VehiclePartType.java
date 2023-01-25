package app.model.domains;

import java.util.Objects;

public class VehiclePartType {
	int typeId;
	String name;
	float price;
	public VehiclePartType(int typeId, String name, float price) {
		super();
		this.typeId = typeId;
		this.name = name;
		this.price = price;
	}public VehiclePartType() {
		// TODO Auto-generated constructor stub
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, price, typeId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehiclePartType other = (VehiclePartType) obj;
		return Objects.equals(name, other.name) && Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& typeId == other.typeId;
	}
	@Override
	public String toString() {
		return "VehiclePartType [typeId=" + typeId + ", name=" + name + ", price=" + price + "]";
	}
}
