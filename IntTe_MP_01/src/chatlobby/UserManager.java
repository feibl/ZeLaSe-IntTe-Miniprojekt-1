package chatlobby;

import java.io.*;
import java.util.*;

public class UserManager {
	protected Map<String, User> users = new Hashtable<String, User>();

	protected String userFilename = "users.ser";

	protected File userFile;

	public UserManager() {
		userFile = new File(userFilename);
		if (userFile.exists()) {
			try {
				FileInputStream fileIn = new FileInputStream(userFile);
				ObjectInputStream objectIn = new ObjectInputStream(fileIn);
				users = (Map<String, User>) objectIn.readObject();
				objectIn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
			save();
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

	public void save() {
		try {
			FileOutputStream fileOut = new FileOutputStream(userFile);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(users);
			objectOut.flush();
			objectOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
