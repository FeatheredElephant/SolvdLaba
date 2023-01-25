package app.model.dao;

import app.model.ConnectionPool;

public abstract class CarDealershipDAO{
	private ConnectionPool connectionPool;

	public CarDealershipDAO() {
		setConnectionPool(new ConnectionPool("cddb.properties", 10));
	}

	public ConnectionPool getConnectionPool() {
		return connectionPool;
	}

	public void setConnectionPool(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}
}