package chatlobby;

import java.io.*;
import java.util.*;

public class UserManager {
	protected Map<String, User> users = new Hashtable<String, User>();

	protected String userFilename = "users.ser";

	protected File userFile;
	
	private String username;
	private String password;
	private String pw_verification;

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

	public boolean register() throws UserException {
		System.out.println("register");
		if(!pw_verification.equals(password)) {
			throw new UserException();
		}
		User user = new User();
		user.setName(username);
		user.setPassword(password);
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

	public String getUsername() {
		System.out.println("hallo");
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPw_verification() {
		return pw_verification;
	}

	public void setPw_verification(String pw_verification) {
		this.pw_verification = pw_verification;
	}
}
