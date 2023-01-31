package app.model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import app.IOManager;

public class SessionPool {
	private List<SqlSession> sessionPool;
	private List<SqlSession> usedConnections = new ArrayList<>();
	private static IOManager io = IOManager.getInstance();
	
	public SessionPool(int initialPoolSize) {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			Properties props = new Properties();
			props.load(Resources.getResourceAsStream("cddb.properties"));
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is, props);
			sessionPool = new ArrayList<>(initialPoolSize);
			for (int i = 0; i<sessionPool.size(); i++) {
				sessionPool.add(factory.openSession());
			}
		}
		catch(Exception e){
			io.reportError(e);
		}
	}
	
	public SqlSession getSession() {
		try {
			SqlSession s = sessionPool.remove(sessionPool.size()-1);
			usedConnections.add(s);
			return s;
		}
		catch (IndexOutOfBoundsException e){
			io.reportError(e);
			return null;
		}
	}
	
	public boolean releaseSession(SqlSession session) {
		sessionPool.add(session);
        return usedConnections.remove(session);
	}
}
