package chatlobby;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatMessage implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		 SimpleDateFormat formater = new SimpleDateFormat();
		 formater.applyPattern("dd.MM.yyyy 'um' hh:mm:ss" );
		return "<strong>"+formater.format(time.getTime()) + " &#60;" + user + "&#62;:</strong> " + message;
	}
}
