package app.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import app.IOManager;

public class ConnectionPool {
	private String url;
	private String user;
	private String password;
	
	private List<Connection> connectionPool;
	private List<Connection> usedConnections = new ArrayList<>();
	
	private static IOManager io = IOManager.getInstance();
	
	public ConnectionPool(String propertiesFileName, int initPoolSize){
		Properties props = null;
		try {
			props = readPropertiesFile(propertiesFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		initialize(props.getProperty("URL"), props.getProperty("USER"), props.getProperty("PASSWORD"), initPoolSize);
	}
	
	ConnectionPool(String baseURL, String username, String password, int initPoolSize){
		initialize(baseURL, username, password, initPoolSize);
	}
	
	void initialize(String baseURL, String username, String password, int initPoolSize) {
		this.url = baseURL;
		this.user = username;
		this.password = password;
		
		connectionPool = new ArrayList<>(initPoolSize);
		for (int index = 0; index<initPoolSize; index++) {
			connectionPool.add(createConnection());
		}
	}
	
	public Connection getConnection() {
		try {
			Connection c = connectionPool.remove(connectionPool.size()-1);
			usedConnections.add(c);
			return c;
		}
		catch (IndexOutOfBoundsException e){
			io.reportError(e);
			return null;
		}
	}
	
	public boolean releaseConnection(Connection connection) {
		connectionPool.add(connection);
        return usedConnections.remove(connection);
	}
	
	private static Properties readPropertiesFile(String fileName) throws IOException {
		InputStream is = null;
		Properties prop = null;
		try {
		   is = ConnectionPool.class
				.getClassLoader()
				.getResourceAsStream(fileName);
		   prop = new Properties();
		   prop.load(is);
		} catch(FileNotFoundException e) {
		   e.printStackTrace();
		} catch(IOException e) {
		   e.printStackTrace();
		} finally {
		   is.close();
		}
		return prop;
	}
	
	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(this.url, this.user, this.password);
		}
		catch (Exception e) {
			io.println(e);
		}
		return connection;
	}
}
