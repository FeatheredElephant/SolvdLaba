package app.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import app.model.domains.Vendor;

public class VendorDAO extends CarDealershipDAO implements BaseDAO<Vendor>{

	@Override
	public boolean create(Vendor Vendor) {
		try {
			Connection connection = getConnectionPool().getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO vendor VALUES (?,?)");
			ps.setInt(1, Vendor.getVendorId());
			ps.setInt(2, Vendor.getUserId());
			int i = ps.executeUpdate();
			getConnectionPool().releaseConnection(connection);
			if (i == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Vendor read(int id) {
		ResultSet rs = null;
		try {
			Connection connection = getConnectionPool().getConnection();
			Statement statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM vendor WHERE vendor_id=" + id);
			getConnectionPool().releaseConnection(connection);
			if (rs.next()) {
				return new Vendor(rs.getInt("vendor_id"), rs.getInt("person_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Vendor Vendor) {
		try {
			Connection connection = getConnectionPool().getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE vendor SET person_id=? WHERE vendor_id=?");
			ps.setInt(1, Vendor.getUserId());
			ps.setInt(2, Vendor.getVendorId());
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
			int i = s.executeUpdate("DELETE FROM vendor WHERE vendor_id=" + id);
			getConnectionPool().releaseConnection(connection);
			if (i==1) return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Set<Vendor> readAll() {
		ResultSet rs = null;
		try {
			Connection connection = getConnectionPool().getConnection();
			Statement statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM vendor");
			getConnectionPool().releaseConnection(connection);
			Set<Vendor> userSet = new HashSet<Vendor>();
			while(rs.next()) {
				userSet.add(new Vendor(rs.getInt("vendor_id"), rs.getInt("person_id")));
			}
			return userSet;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
