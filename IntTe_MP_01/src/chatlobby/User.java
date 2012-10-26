package chatlobby;

import java.io.Serializable;

public class User implements Serializable{
	private String name;
	private String password;
	private Boolean loggedIn;
	
	public User() {
		name = "";
		password = "";
		loggedIn = false;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean checkPassword(String password) {
		if (this.password.equals(password)) {
			return true;
		}
		return false;
	}

	public boolean checkEntries() throws UserException {
		if (password == null && name == null)
			return false;
		if (password == null || password.equals(""))
			throw new UserException();
		if (name == null || name.equals(""))
			throw new UserException();
		return true;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
}
