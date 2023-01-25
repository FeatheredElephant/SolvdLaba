package app.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import app.model.domains.ServiceProvider;

public class ServiceProviderDAO extends CarDealershipDAO implements BaseDAO<ServiceProvider>{

	@Override
	public boolean create(ServiceProvider ServiceProvider) {
		try {
			Connection connection = getConnectionPool().getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO service_provider VALUES (?,?)");
			ps.setInt(1, ServiceProvider.getServiceProviderId());
			ps.setInt(2, ServiceProvider.getUserId());
			int i = ps.executeUpdate();
			getConnectionPool().releaseConnection(connection);
			if (i == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ServiceProvider read(int id) {
		ResultSet rs = null;
		try {
			Connection connection = getConnectionPool().getConnection();
			Statement statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM service_provider WHERE service_provider_id=" + id);
			getConnectionPool().releaseConnection(connection);
			if (rs.next()) {
				return new ServiceProvider(rs.getInt("service_provider_id"), rs.getInt("person_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(ServiceProvider ServiceProvider) {
		try {
			Connection connection = getConnectionPool().getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE service_provider SET person_id=? WHERE service_provider_id=?");
			ps.setInt(1, ServiceProvider.getUserId());
			ps.setInt(2, ServiceProvider.getServiceProviderId());
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
			int i = s.executeUpdate("DELETE FROM service_provider WHERE service_provider_id=" + id);
			getConnectionPool().releaseConnection(connection);
			if (i==1) return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Set<ServiceProvider> readAll() {
		ResultSet rs = null;
		try {
			Connection connection = getConnectionPool().getConnection();
			Statement statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM service_provider");
			getConnectionPool().releaseConnection(connection);
			Set<ServiceProvider> userSet = new HashSet<ServiceProvider>();
			while(rs.next()) {
				userSet.add(new ServiceProvider(rs.getInt("service_provider_id"), rs.getInt("person_id")));
			}
			return userSet;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
