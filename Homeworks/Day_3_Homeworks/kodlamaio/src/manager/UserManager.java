package manager;

import model.User;

public class UserManager {
	
	public void getUserInformation(User user) {
		System.out.println("ID: " + user.getId());
		System.out.println("Name: " + user.getName());
		System.out.println("Surname: " + user.getSurname());
	}
	
	public void getUserList(User[] users) {
		for(User user : users) 
			getUserInformation(user);
	}
	
	public void getInformation(User user) {
		System.out.println(user.getName() + " is an user");
	}
}
