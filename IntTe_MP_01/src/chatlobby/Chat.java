package chatlobby;

import java.io.Serializable;


public class Chat implements Serializable{
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
}
