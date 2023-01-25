package app.model.domains;

import java.util.Objects;

public class VehicleBrand {
	int brandId;
	String name;

	public VehicleBrand(int brandId, String name) {
		super();
		this.brandId = brandId;
		this.name = name;
	}

	public VehicleBrand() {
		// TODO Auto-generated constructor stub
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brandId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleBrand other = (VehicleBrand) obj;
		return brandId == other.brandId;
	}

	@Override
	public String toString() {
		return "VehicleBrand [brandId=" + brandId + ", name=" + name + "]";
	}
}
