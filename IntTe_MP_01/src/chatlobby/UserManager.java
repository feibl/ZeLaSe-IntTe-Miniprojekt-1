package chatlobby;

import java.util.Hashtable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

public class UserManager {
	protected Map<String, User> users = new Hashtable<String, User>();

	public UserManager() {

	}

	public String register(User user) throws UserException {

		if (isUsernameTaken(user.getName())) { // User existiert bereits
			throw new UserException();
		}

		if (user.checkEntries()) { // wirft UserException bei Fehler
			users.put(user.getName(), user);
			return "ChatLobby.xhtml";
		}
		return "Register.xhtml";
	}

	public boolean isUsernameTaken(String name) {
		return users.get(name) != null;
	}

	public void login(User user) throws UserException {
		if ((user.getName() == null && user.getPassword() == null)
				|| (user.getName() == "" && user.getPassword() == "")) {
			throw new UserException();
		}
		if (users.get(user.getName()) != null
				&& user.checkPassword(user.getPassword())) {
			user.setLoggedIn(true);
			FacesContext.getCurrentInstance().getAttributes().put("user", user);
		} else {
			throw new UserException();
		}

	}

	public void validateUserName(FacesContext context, UIComponent toValidate,
			Object value) {

		String username = value.toString();
		if (isUsernameTaken(username)) {
			((UIInput)toValidate).setValid(false);
			context.addMessage(toValidate.getClientId(context),
					new FacesMessage("Username already Taken"));
		}
	}
}
