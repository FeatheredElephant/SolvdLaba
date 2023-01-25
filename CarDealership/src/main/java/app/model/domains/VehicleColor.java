package app.model.domains;

import java.util.Objects;

public class VehicleColor {
	int colorId;
	String name;

	public VehicleColor(int colorId, String name) {
		super();
		this.colorId = colorId;
		this.name = name;
	}

	public VehicleColor() {
		// TODO Auto-generated constructor stub
	}

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "VehicleColor [colorId=" + colorId + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(colorId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleColor other = (VehicleColor) obj;
		return colorId == other.colorId;
	}
}
