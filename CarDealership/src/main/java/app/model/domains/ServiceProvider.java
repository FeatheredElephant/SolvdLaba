package app.model.domains;

import java.util.Objects;

public class ServiceProvider {
	int serviceProviderId;
	int userId;

	public ServiceProvider(int serviceProviderId, int userId) {
		this.serviceProviderId = serviceProviderId;
		this.userId = userId;
	}

	public ServiceProvider() {
		// TODO Auto-generated constructor stub
	}

	public int getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(int serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(serviceProviderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceProvider other = (ServiceProvider) obj;
		return serviceProviderId == other.serviceProviderId;
	}

	@Override
	public String toString() {
		return "ServiceProvider [serviceProviderId=" + serviceProviderId + ", userId=" + userId + "]";
	}
}
