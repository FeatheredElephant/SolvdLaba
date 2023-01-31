package app;

import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import app.model.*;
import app.model.dao.*;
import app.model.domains.*;
import app.model.mappers.UserMapper;
import view.*;

public class Main {
	public static void main(String[] args) {
		IOManager io = IOManager.getInstance();
		//UserCRUDMenu uMenu = new UserCRUDMenu();
		//uMenu.view();
		
		/*
		//Test DAO
		VendorDAO dao = new VendorDAO();
		Vendor e = new Vendor(15, 1);
		io.println(dao.readAll());
		dao.create(e);
		io.println(dao.read(15));
		e.setUserId(2);
		dao.update(e);
		io.println(dao.read(15));
		dao.delete(15);
		io.println(dao.read(15));
		*/
		
		//TestMapper
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			Properties props = new Properties();
			props.load(Resources.getResourceAsStream("cddb.properties"));
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is, props);
			SqlSession session = factory.openSession();
			session.getConfiguration().addMapper(UserMapper.class);
			UserMapper mapper = session.getMapper(UserMapper.class);
			io.println(mapper.readAll());
		}	
		catch (Exception e){
			io.reportError(e);
		}
		
		
		//SqlSession session = sessionPool.getSession();
		//session.getConfiguration().addMapper(UserMapper.class);
		//UserMapper mapper = session.getMapper(UserMapper.class);
		
		//io.println(mapper.readAll());		
	}
}