package chatlobby;

import java.util.Hashtable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

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

	public String login(User user) throws UserException {
		if (users.containsKey(user.getName()) && users.get(user.getName()).getPassword().equals(user.getLoginPassword()) ) {
			user.setLoggedIn(true);
			FacesContext.getCurrentInstance().getAttributes().put("user", user);
			return "ChatLobby.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Unknown login, try again"));
			return null;
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
