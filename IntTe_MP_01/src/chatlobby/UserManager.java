package chatlobby;

import java.io.*;
import java.util.*;

public class UserManager {
	protected Map<String, User> users = new Hashtable<String, User>();



	public UserManager() {
		
	}

	public boolean register(RegistrationFormular formular) throws UserException {
		if(!formular.getPw_verification().equals(formular.getPassword())) {
			throw new UserException();
		}
		User user = new User();
		user.setName(formular.getUsername());
		user.setPassword(formular.getPassword());
		if (users.get(user.getName()) != null) { // User existiert bereits
			throw new UserException();
		}
		
		if (user.checkEntries()) { // wirft UserException bei Fehler
			users.put(user.getName(), user);
			
			return true;
		}
		return false;
	}

	public User login(String login, String password) throws UserException {
		if ((login == null && password == null)
				|| (login == "" && password == "")) {
			return null;
		}
		User user = users.get(login);
		if (user != null && user.checkPassword(password)) {
			return user;
		}
		throw new UserException();
	}

	
}
