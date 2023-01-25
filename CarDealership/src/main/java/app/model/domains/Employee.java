package app.model.domains;

import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;

public class Employee {
	
	int employeeId;
	
	double wage;
	
	String title;
	
	int userId;
	
	public Employee(int employeeId, double wage, String title, int userId){
		setEmployee_id(employeeId);
		setWage(wage);
		setTitle(title);
		setUserId(userId);
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	@XmlElement(name="employeeId")
	public void setEmployee_id(int employeeId) {
		this.employeeId = employeeId;
	}
	public double getWage() {
		return wage;
	}
	@XmlElement(name="wage")
	public void setWage(double wage) {
		this.wage = wage;
	}
	public String getTitle() {
		return title;
	}
	@XmlElement(name="title")
	public void setTitle(String title) {
		this.title = title;
	}

	public int getUserId() {
		return userId;
	}
	@XmlElement(name="userId")
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(employeeId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return employeeId == other.employeeId;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", wage=" + wage + ", title=" + title + ", userId=" + userId
				+ "]";
	}
}
