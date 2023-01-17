package app.dao;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UserDAO extends CarDealershipDAO implements BaseDAO<User>{
	
	@Override
	public boolean create(User user) {
		try {
			Connection connection = getConnectionPool().getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO person VALUES (?,?)");
			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			int i = ps.executeUpdate();
			getConnectionPool().releaseConnection(connection);
			if (i == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User read(int id) {
		ResultSet rs = null;
		try {
			Connection connection = getConnectionPool().getConnection();
			Statement statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM person WHERE person_id=" + id);
			getConnectionPool().releaseConnection(connection);
			if (rs.next()) {
				return new User(rs.getInt("person_id"), rs.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(User user) {
		try {
			Connection connection = getConnectionPool().getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE person SET name=? WHERE person_id=?");
			ps.setString(1, user.getName());
			ps.setInt(2, user.getId());
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
			int i = s.executeUpdate("DELETE FROM person WHERE person_id=" + id);
			getConnectionPool().releaseConnection(connection);
			if (i==1) return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Set<User> readAll() {
		ResultSet rs = null;
		try {
			Connection connection = getConnectionPool().getConnection();
			Statement statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM person");
			getConnectionPool().releaseConnection(connection);
			Set<User> userSet = new HashSet<User>();
			while(rs.next()) {
				userSet.add(new User(rs.getInt("person_id"), rs.getString("name")));
			}
			return userSet;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
