package view;

import app.IOManager;
import app.model.dao.UserDAO;
import app.model.domains.User;

public class UserCRUDMenu {
	IOManager io = IOManager.getInstance();
	UserDAO udao = new UserDAO();
	
	public void view() {
		io.println("What would you like to do?\n"
				+ "0. Exit\n"
				+ "1. Create User\n"
				+ "2. View User\n"
				+ "3. View All Users\n"
				+ "4. Update User\n"
				+ "5. Delete User");
		
		int response = io.requestIntInRange(0, 5);
		switch(response) {
		case 0:
			io.println("Goodbye.");
			return;
		case 1:
			io.println("id?");
			int id = io.requestInt();
			io.println("name?");
			String name = io.requestString();
			if (udao.create(new User(id, name))) io.println("User("+id+","+name+") created.");
			else io.println("Failed to create user.");
			break;
		case 2:
			io.println("id?");
			io.println(udao.read(io.requestInt()));
			break;
		case 3:
			io.println(udao.readAll());
			break;
		case 4:
			io.println("id of user to edit?");
			User user = udao.read(io.requestInt());
			io.println(user);
			io.println("new name?");
			user.setName(io.requestString());
			if (udao.update(user)) io.println("User("+user.getId()+","+user.getName()+") updated.");
			else io.println("Failed to update user.");
			break;
		case 5:
			io.println("id?");
			if (udao.delete(io.requestInt())) io.println("User deleted.");
			else io.println("Failed to delete user.");
			break;
		}
		view();
	}
}
