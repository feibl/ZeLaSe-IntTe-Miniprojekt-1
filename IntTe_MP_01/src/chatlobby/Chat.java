package chatlobby;

import java.io.Serializable;


public class Chat implements Serializable{
	private static final long serialVersionUID = 1L;
	private String topic;
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return topic;
	}
	
	public String enter(User user){
		
		return "<script>alert('not logged in');</script>";
	}
	
	public String test(){
		return "ok";
	}
}
