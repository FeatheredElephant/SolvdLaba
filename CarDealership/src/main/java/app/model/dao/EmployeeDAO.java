package app.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import app.model.domains.Employee;
import app.model.domains.User;

public class EmployeeDAO extends CarDealershipDAO implements BaseDAO<Employee>{
	@Override
	public boolean create(Employee employee) {
		try {
			Connection connection = getConnectionPool().getConnection();
			
			PreparedStatement ps = connection.prepareStatement("INSERT INTO employee VALUES (?,?,?,?)");
			ps.setInt(1, employee.getEmployeeId());
			ps.setDouble(2, employee.getWage());
			ps.setString(3, employee.getTitle());
			ps.setInt(4, employee.getUserId());
			
			int i = ps.executeUpdate();
			getConnectionPool().releaseConnection(connection);
			if (i == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Employee read(int id) {
		ResultSet rs = null;
		try {
			Connection connection = getConnectionPool().getConnection();
			Statement statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM employee WHERE employee_id=" + id);
			getConnectionPool().releaseConnection(connection);
			if (rs.next()) {
				return new Employee(rs.getInt("employee_id"), rs.getDouble("wage"), rs.getString("title"), rs.getInt("person_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Employee employee) {
		try {
			Connection connection = getConnectionPool().getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE employee SET wage=?, title=?  WHERE employee_id=?");
			ps.setDouble(1, employee.getWage());
			ps.setString(2, employee.getTitle());
			ps.setInt(3, employee.getEmployeeId());
			int i = ps.executeUpdate();
			getConnectionPool().releaseConnection(connection);
			if (i==1) return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
			Connection connection = getConnectionPool().getConnection();
			Statement s = connection.createStatement();
			int i = s.executeUpdate("DELETE FROM employee WHERE employee_id=" + id);
			getConnectionPool().releaseConnection(connection);
			if (i==1) return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} 
	
	public Set<Employee> readAll() {
		ResultSet rs = null;
		try {
			Connection connection = getConnectionPool().getConnection();
			Statement statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM employee");
			getConnectionPool().releaseConnection(connection);
			Set<Employee> employeeSet = new HashSet<Employee>();
			while(rs.next()) {
				employeeSet.add(new Employee(rs.getInt("employee_id"), rs.getDouble("wage"), rs.getString("title"), rs.getInt("person_id")));
			}
			return employeeSet;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
