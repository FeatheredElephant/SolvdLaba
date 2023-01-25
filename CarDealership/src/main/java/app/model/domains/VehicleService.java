package app.model.domains;

import java.util.Objects;

public class VehicleService {
	int serviceId;
	int serviceProviderId;
	int vehicleId;
	float serviceCost;
	String description;
	public VehicleService(int serviceId, int serviceProviderId, int vehicleId, float serviceCost, String description) {
		super();
		this.serviceId = serviceId;
		this.serviceProviderId = serviceProviderId;
		this.vehicleId = vehicleId;
		this.serviceCost = serviceCost;
		this.description = description;
	}public VehicleService() {
		// TODO Auto-generated constructor stub
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public int getServiceProviderId() {
		return serviceProviderId;
	}
	public void setServiceProviderId(int serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public float getServiceCost() {
		return serviceCost;
	}
	public void setServiceCost(float serviceCost) {
		this.serviceCost = serviceCost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		return Objects.hash(serviceId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleService other = (VehicleService) obj;
		return serviceId == other.serviceId;
	}
	@Override
	public String toString() {
		return "VehicleService [serviceId=" + serviceId + ", serviceProviderId=" + serviceProviderId + ", vehicleId="
				+ vehicleId + ", serviceCost=" + serviceCost + ", description=" + description + "]";
	}
}
