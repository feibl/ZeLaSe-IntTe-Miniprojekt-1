package chatlobby;

import java.util.Date;

public class ChatMessage {
	private String message;
	private Date time;
	private User user;
	
	public ChatMessage(String message, User user) {
		this.message = message;
		this.user = user;
		this.time = new Date();
	}
	
	public String getMessage() {
		return message;
	}

	public Date getTime() {
		return time;
	}

	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		return time + " &#60;" + user + "&#62;: " + message;
	}
}
