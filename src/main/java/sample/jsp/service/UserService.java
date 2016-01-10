package sample.jsp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import sample.jsp.model.User;

@Component
public class UserService {
	List<User> users = new ArrayList<>();

	public UserService() {
		User mu = new User(0001, "Müller", "Max", "heerstr. 8 12209");
		User seide = new User(0002, "Seide", "Ina", "karl 108");
		users.add(mu);
		users.add(seide);
	}

	public List<User> getUsers() {
		return users;
	}

	public User getUser(long userId) {

		for (User user : users) {
			if (user.getId() == userId) {
				return user;
			}
		}

		return null;
	}

	public void updateUser(long id, String firstname, String lastname, String address) {
		User currentUser = getUser(id);
		
		currentUser.setFirstname(firstname);
		currentUser.setLastname(lastname);
		currentUser.setAddress(address);

		// TODO Auto-generated method stub

	}

	public void saveUser(long id, String firstname, String lastname, String address) {
		User newUser = new User(id, firstname, lastname, address);
		users.add(newUser);
		// TODO Auto-generated method stub

	}

}
