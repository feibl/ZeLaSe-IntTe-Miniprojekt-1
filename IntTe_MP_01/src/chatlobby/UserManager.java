package chatlobby;

import java.io.*;
import java.util.*;

public class UserManager {
	protected Map<String, User> users = new Hashtable<String, User>();



	public UserManager() {
		
	}

	public String register(RegistrationFormular formular) throws UserException {
		if(!formular.getPw_verification().equals(formular.getPassword())) {
			throw new UserException();
		}
		User user = new User();
		user.setName(formular.getUsername());
		user.setPassword(formular.getPassword());
		user.setLoggedIn(false);
		if (users.get(user.getName()) != null) { // User existiert bereits
			throw new UserException();
		}
		
		if (user.checkEntries()) { // wirft UserException bei Fehler
			users.put(user.getName(), user);
			
			return "ChatLobby.xhtml";
		}
		return "Register.xhtml";
	}

	public void login(User user) throws UserException {
		if ((user.getName() == null && user.getPassword() == null)
				|| (user.getName() == "" && user.getPassword() == "")) {
			throw new UserException();
		}
		if (users.get(user.getName()) != null && user.checkPassword(user.getPassword())) {
			user.setLoggedIn(true);
		}
		else {
			throw new UserException();
		}

	}

	
}
