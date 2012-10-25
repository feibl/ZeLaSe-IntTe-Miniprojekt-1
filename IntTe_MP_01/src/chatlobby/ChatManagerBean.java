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
	public Chat selectedChatRoom;

	protected Map<String, Chat> chatrooms = new Hashtable<String, Chat>();

	protected String chatFilename = "chatrooms.ser";

	protected File chatFile;

	public Chat getSelectedChatRoom() {
		return selectedChatRoom;
	}

	public void setSelectedChatRoom(Chat selectedChatroom) {
		this.selectedChatRoom = selectedChatroom;
	}

	public ChatManagerBean() {
		chatFile = new File(chatFilename);
		if (chatFile.exists()) {
			try {
				FileInputStream fileIn = new FileInputStream(chatFile);
				ObjectInputStream objectIn = new ObjectInputStream(fileIn);
				chatrooms = (Hashtable<String, Chat>) objectIn.readObject();
				objectIn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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

		save();
	}

	public void save() {
		try {
			FileOutputStream fileOut = new FileOutputStream(chatFile);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(chatrooms);
			objectOut.flush();
			objectOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
