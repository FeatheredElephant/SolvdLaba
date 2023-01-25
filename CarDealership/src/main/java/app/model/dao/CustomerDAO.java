package app.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import app.model.domains.Customer;

public class CustomerDAO extends CarDealershipDAO implements BaseDAO<Customer>{

	@Override
	public boolean create(Customer Customer) {
		try {
			Connection connection = getConnectionPool().getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO customer VALUES (?,?)");
			ps.setInt(1, Customer.getCustomerId());
			ps.setInt(2, Customer.getUserId());
			int i = ps.executeUpdate();
			getConnectionPool().releaseConnection(connection);
			if (i == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Customer read(int id) {
		ResultSet rs = null;
		try {
			Connection connection = getConnectionPool().getConnection();
			Statement statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM customer WHERE customer_id=" + id);
			getConnectionPool().releaseConnection(connection);
			if (rs.next()) {
				return new Customer(rs.getInt("customer_id"), rs.getInt("person_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Customer Customer) {
		try {
			Connection connection = getConnectionPool().getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE customer SET person_id=? WHERE customer_id=?");
			ps.setInt(1, Customer.getUserId());
			ps.setInt(2, Customer.getCustomerId());
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
			int i = s.executeUpdate("DELETE FROM customer WHERE customer_id=" + id);
			getConnectionPool().releaseConnection(connection);
			if (i==1) return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Set<Customer> readAll() {
		ResultSet rs = null;
		try {
			Connection connection = getConnectionPool().getConnection();
			Statement statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM person");
			getConnectionPool().releaseConnection(connection);
			Set<Customer> userSet = new HashSet<Customer>();
			while(rs.next()) {
				userSet.add(new Customer(rs.getInt("customer_id"), rs.getInt("person_id")));
			}
			return userSet;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
