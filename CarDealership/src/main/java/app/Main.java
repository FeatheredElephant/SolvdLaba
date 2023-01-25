package app;

import app.model.*;
import app.model.dao.*;
import app.model.domains.*;
import view.*;

public class Main {
	public static void main(String[] args) {
		IOManager io = IOManager.getInstance();
		//UserCRUDMenu uMenu = new UserCRUDMenu();
		//uMenu.view();
		
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
	}
}