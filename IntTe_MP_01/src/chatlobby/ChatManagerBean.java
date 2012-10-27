package chatlobby;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

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
		newChat.setTheme(name);
		chatrooms.put(name, new Chat());

		
	}

	

}
