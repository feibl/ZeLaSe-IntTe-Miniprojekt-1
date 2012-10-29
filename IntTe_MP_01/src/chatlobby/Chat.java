package chatlobby;

import java.io.Serializable;


public class Chat implements Serializable{
	private static final long serialVersionUID = 1L;
	private String theme;
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}

	@Override
	public String toString() {
		return theme;
	}
	
	public String enter(User user){
		
		return "<script>alert('not logged in');</script>";
	}
	
	public String test(){
		return "ok";
	}
}
