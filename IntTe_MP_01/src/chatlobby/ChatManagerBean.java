package chatlobby;

import java.util.Hashtable;
import java.util.Map;

public class ChatManagerBean {
	protected Map<String, Chat> chatrooms = new Hashtable<String, Chat>();


	

	public ChatManagerBean() {
		
	}

	public int getNumberOfChats() {
		return chatrooms.size();
	}


	public Map<String, Chat> getChatrooms() {
		return chatrooms;
	}
	
	public void setChatrooms(Map<String, Chat> chatrooms) {
		this.chatrooms = chatrooms;
	}

	public void createNewChat(String name) throws ChatException {
		if (chatrooms.get(name) != null) { // Chat existiert bereits
			throw new ChatException();
		}
		Chat newChat = new Chat();
		newChat.setTopic(name);
		chatrooms.put(name, new Chat());

		
	}

	

}
