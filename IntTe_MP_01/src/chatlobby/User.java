package chatlobby;

import java.io.Serializable;

public class User implements Serializable{
	private String name;
	private String password;
	private Boolean loggedIn;
	private Chat selectedChat;
	
	public User() {
		name = "";
		password = "";
		loggedIn = false;
	}
	
	public Chat getSelectedChat() {
		return selectedChat;
	}
	public void setSelectedChat(Chat selectedChat) {
		this.selectedChat = selectedChat;
	}
	
	public String tryToEnterSelectedChat(){
		if(loggedIn){
			if(selectedChat!=null){
				selectedChat.enter(this);
				return "Chat.xhtml";
			}else{
				System.out.println("select chat first");
			}
		}
		return"error";
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
