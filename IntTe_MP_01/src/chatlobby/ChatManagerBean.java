 package chatlobby;

import java.util.ArrayList;
import java.util.List;


public class ChatManagerBean {

	private List<Chat> chatrooms;
	private int numberOfChats;
	private Chat selectedChatRoom;

	public Chat getSelectedChatRoom() {
		return selectedChatRoom;
	}
	

	public void setSelectedChatRoom(Chat selectedChatroom) {
		this.selectedChatRoom = selectedChatroom;
	}



	public ChatManagerBean() {
		chatrooms = new ArrayList<Chat>();
	}
	
	public int getNumberOfChats() {
		return chatrooms.size();
	}
	
	public void createNewChat(String name){
		Chat newChat = new Chat();
		newChat.setTheme(name);
		chatrooms.add(newChat);	
	}


	public List<Chat> getChatrooms() {
		return chatrooms;
	}
	
	
	
}

