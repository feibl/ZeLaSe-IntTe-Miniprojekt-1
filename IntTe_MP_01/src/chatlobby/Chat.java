package chatlobby;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Chat implements Serializable{
	private static final long serialVersionUID = 1L;
	private String topic;
	private List<ChatMessage> chatMessages = new ArrayList<ChatMessage>();;
	private List<User> users = new ArrayList<User>();
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return topic + " ("+users.size()+")";
	}
	
	public String getChatMessages(){
		StringBuilder messages = new StringBuilder();
		for (ChatMessage message : chatMessages) {
			messages.append(message + "<br />");
		}
		return messages.toString();
	}
	
	public String getUsersInChat(){
		StringBuilder usersInChat = new StringBuilder();
		usersInChat.append("<ul>");
		for (User u : users) {
			usersInChat.append("<li>");
			usersInChat.append(u);
			usersInChat.append("</li>");
			usersInChat.append("</br>");
		}
		
		usersInChat.append("</ul>");
		return usersInChat.toString();
	}
	
	public void enter(User user){
		if (!users.contains(user)){
			users.add(user);
			chatMessages.add(new ChatMessage("enters", user));
		}
	}
	
	
	public String leave(User user){
		if(users.contains(user)){
			chatMessages.add(new ChatMessage("leave", user));
			users.remove(user);
		}
		return "ChatLobby.xhtml";
	}
	
	public void postMessage(String message,User user){
		chatMessages.add(new ChatMessage(message, user));
	}
}
