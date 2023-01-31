package app.model.domains;

import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.*;

//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("carDealership")
@XmlRootElement(name = "carDealership")
public class CarDealership {

	List<User> users;

	List<Employee> employees;

	List<Customer> customers;

	List<Vendor> vendors;

	List<ServiceProvider> serviceProviders;

	List<Payment> payments;

	List<Vehicle> vehicles;

	List<VehicleColor> vehicleColors;

	List<VehicleModel> vehicleModels;

	List<VehicleType> vehicleTypes;

	List<VehicleBrand> vehicleBrands;

	List<VehicleSale> vehicleSales;

	List<VehicleService> vehicleServices;

	List<VehiclePurchase> vehiclePurchases;

	List<VehiclePartPurchase> partPurchases;

	List<VehiclePart> vehicleParts;

	List<VehiclePartType> vehiclePartTypes;

	public CarDealership() {
		super();
	}

	public CarDealership(List<User> users, List<Employee> employees, List<Customer> customers, List<Vendor> vendors,
			List<ServiceProvider> serviceProviders, List<Payment> payments, List<Vehicle> vehicles,
			List<VehicleColor> vehicleColors, List<VehicleModel> vehicleModels, List<VehicleType> vehicleTypes,
			List<VehicleBrand> vehicleBrands, List<VehicleSale> vehicleSales, List<VehicleService> vehicleServices,
			List<VehiclePurchase> vehiclePurchases, List<VehiclePartPurchase> partPurchases,
			List<VehiclePart> vehicleParts, List<VehiclePartType> vehiclePartTypes) {
		super();
		this.users = users;
		this.employees = employees;
		this.customers = customers;
		this.vendors = vendors;
		this.serviceProviders = serviceProviders;
		this.payments = payments;
		this.vehicles = vehicles;
		this.vehicleColors = vehicleColors;
		this.vehicleModels = vehicleModels;
		this.vehicleTypes = vehicleTypes;
		this.vehicleBrands = vehicleBrands;
		this.vehicleSales = vehicleSales;
		this.vehicleServices = vehicleServices;
		this.vehiclePurchases = vehiclePurchases;
		this.partPurchases = partPurchases;
		this.vehicleParts = vehicleParts;
		this.vehiclePartTypes = vehiclePartTypes;
	}

	public List<User> getUsers() {
		return users;
	}

	@JsonProperty("users")
	@XmlElementWrapper(name = "users")
	@XmlElement(name = "user")
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	@JsonProperty("employees")
	@XmlElementWrapper(name = "employees")
	@XmlElement(name = "employee")
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	@JsonProperty("customers")
	@XmlElementWrapper(name = "customers")
	@XmlElement(name = "customer")
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Vendor> getVendors() {
		return vendors;
	}

	@JsonProperty("vendors")
	@XmlElementWrapper(name = "vendors")
	@XmlElement(name = "vendor")
	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}

	public List<ServiceProvider> getServiceProviders() {
		return serviceProviders;
	}

	@JsonProperty("serviceproviders")
	@XmlElementWrapper(name = "serviceProviders")
	@XmlElement(name = "serviceProvider")
	public void setServiceProviders(List<ServiceProvider> serviceProviders) {
		this.serviceProviders = serviceProviders;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	@JsonProperty("payments")
	@XmlElementWrapper(name = "payments")
	@XmlElement(name = "payment")
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	@JsonProperty("vehicles")
	@XmlElementWrapper(name = "vehicles")
	@XmlElement(name = "vehicle")
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public List<VehicleColor> getVehicleColors() {
		return vehicleColors;
	}

	@JsonProperty("vehicleColors")
	@XmlElementWrapper(name = "vehicleColors")
	@XmlElement(name = "vehicleColor")
	public void setVehicleColors(List<VehicleColor> vehicleColors) {
		this.vehicleColors = vehicleColors;
	}

	public List<VehicleModel> getVehicleModels() {
		return vehicleModels;
	}

	@JsonProperty("vehicleModels")
	@XmlElementWrapper(name = "vehicleModels")
	@XmlElement(name = "vehicleModel")
	public void setVehicleModels(List<VehicleModel> vehicleModels) {
		this.vehicleModels = vehicleModels;
	}

	public List<VehicleType> getVehicleTypes() {
		return vehicleTypes;
	}

	@JsonProperty("vehicleTypes")
	@XmlElementWrapper(name = "vehicleTypes")
	@XmlElement(name = "vehicleType")
	public void setVehicleTypes(List<VehicleType> vehicleTypes) {
		this.vehicleTypes = vehicleTypes;
	}

	public List<VehicleBrand> getVehicleBrands() {
		return vehicleBrands;
	}

	@JsonProperty("vehicleBrands")
	@XmlElementWrapper(name = "vehicleBrands")
	@XmlElement(name = "vehicleBrand")
	public void setVehicleBrands(List<VehicleBrand> vehicleBrands) {
		this.vehicleBrands = vehicleBrands;
	}

	public List<VehicleSale> getVehicleSales() {
		return vehicleSales;
	}

	@JsonProperty("vehicleSales")
	@XmlElementWrapper(name = "vehicleSales")
	@XmlElement(name = "vehicleSale")
	public void setVehicleSales(List<VehicleSale> vehicleSales) {
		this.vehicleSales = vehicleSales;
	}

	public List<VehicleService> getVehicleServices() {
		return vehicleServices;
	}

	@JsonProperty("vehicleServices")
	@XmlElementWrapper(name = "vehicleServices")
	@XmlElement(name = "vehicleService")
	public void setVehicleServices(List<VehicleService> vehicleServices) {
		this.vehicleServices = vehicleServices;
	}

	public List<VehiclePurchase> getVehiclePurchases() {
		return vehiclePurchases;
	}

	@JsonProperty("vehiclePurchases")
	@XmlElementWrapper(name = "vehiclePurchases")
	@XmlElement(name = "vehiclePurchase")
	public void setVehiclePurchases(List<VehiclePurchase> vehiclePurchases) {
		this.vehiclePurchases = vehiclePurchases;
	}

	public List<VehiclePartPurchase> getPartPurchases() {
		return partPurchases;
	}

	@JsonProperty("partPurchases")
	@XmlElementWrapper(name = "partPurchases")
	@XmlElement(name = "partPurchase")
	public void setPartPurchases(List<VehiclePartPurchase> partPurchases) {
		this.partPurchases = partPurchases;
	}

	public List<VehiclePart> getVehicleParts() {
		return vehicleParts;
	}

	@JsonProperty("vehicleParts")
	@XmlElementWrapper(name = "vehicleParts")
	@XmlElement(name = "vehiclePart")
	public void setVehicleParts(List<VehiclePart> vehicleParts) {
		this.vehicleParts = vehicleParts;
	}

	public List<VehiclePartType> getVehiclePartTypes() {
		return vehiclePartTypes;
	}

	@JsonProperty("vehiclePartTypes")
	@XmlElementWrapper(name = "vehiclePartTypes")
	@XmlElement(name = "vehiclePartType")
	public void setVehiclePartTypes(List<VehiclePartType> vehiclePartTypes) {
		this.vehiclePartTypes = vehiclePartTypes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customers, employees, partPurchases, payments, serviceProviders, users, vehicleBrands,
				vehicleColors, vehicleModels, vehiclePartTypes, vehicleParts, vehiclePurchases, vehicleSales,
				vehicleServices, vehicleTypes, vehicles, vendors);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarDealership other = (CarDealership) obj;
		return Objects.equals(customers, other.customers) && Objects.equals(employees, other.employees)
				&& Objects.equals(partPurchases, other.partPurchases) && Objects.equals(payments, other.payments)
				&& Objects.equals(serviceProviders, other.serviceProviders) && Objects.equals(users, other.users)
				&& Objects.equals(vehicleBrands, other.vehicleBrands)
				&& Objects.equals(vehicleColors, other.vehicleColors)
				&& Objects.equals(vehicleModels, other.vehicleModels)
				&& Objects.equals(vehiclePartTypes, other.vehiclePartTypes)
				&& Objects.equals(vehicleParts, other.vehicleParts)
				&& Objects.equals(vehiclePurchases, other.vehiclePurchases)
				&& Objects.equals(vehicleSales, other.vehicleSales)
				&& Objects.equals(vehicleServices, other.vehicleServices)
				&& Objects.equals(vehicleTypes, other.vehicleTypes) && Objects.equals(vehicles, other.vehicles)
				&& Objects.equals(vendors, other.vendors);
	}

	@Override
	public String toString() {
		return "CarDealership [users=" + users + ", employees=" + employees + ", customers=" + customers + ", vendors="
				+ vendors + ", serviceProviders=" + serviceProviders + ", payments=" + payments + ", vehicles="
				+ vehicles + ", vehicleColors=" + vehicleColors + ", vehicleModels=" + vehicleModels + ", vehicleTypes="
				+ vehicleTypes + ", vehicleBrands=" + vehicleBrands + ", vehicleSales=" + vehicleSales
				+ ", vehicleServices=" + vehicleServices + ", vehiclePurchases=" + vehiclePurchases + ", partPurchases="
				+ partPurchases + ", vehicleParts=" + vehicleParts + ", vehiclePartTypes=" + vehiclePartTypes
				+ ", getUsers()=" + getUsers() + ", getEmployees()=" + getEmployees() + ", getCustomers()="
				+ getCustomers() + ", getVendors()=" + getVendors() + ", getServiceProviders()=" + getServiceProviders()
				+ ", getPayments()=" + getPayments() + ", getVehicles()=" + getVehicles() + ", getVehicleColors()="
				+ getVehicleColors() + ", getVehicleModels()=" + getVehicleModels() + ", getVehicleTypes()="
				+ getVehicleTypes() + ", getVehicleBrands()=" + getVehicleBrands() + ", getVehicleSales()="
				+ getVehicleSales() + ", getVehicleServices()=" + getVehicleServices() + ", getVehiclePurchases()="
				+ getVehiclePurchases() + ", getPartPurchases()=" + getPartPurchases() + ", getVehicleParts()="
				+ getVehicleParts() + ", getVehiclePartTypes()=" + getVehiclePartTypes() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
}