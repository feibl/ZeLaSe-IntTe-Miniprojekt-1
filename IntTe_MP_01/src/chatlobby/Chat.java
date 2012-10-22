package chatlobby;


public class Chat {
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
