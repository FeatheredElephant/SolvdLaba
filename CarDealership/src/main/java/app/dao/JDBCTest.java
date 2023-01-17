package app.dao;

import java.io.*;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCTest {
	private static final String propertiesFile = "cddb.properties";
	
	public void test() {
		try {
			Properties p = readPropertiesFile(propertiesFile);
			Connection connection = DriverManager.getConnection(p.getProperty("DBURL"), p.getProperty("USER"), p.getProperty("PASSWORD"));
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM person");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
			
			connection.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Properties readPropertiesFile(String fileName) throws IOException {
	      InputStream is = null;
	      Properties prop = null;
	      try {
	         is = this.getClass()
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
}