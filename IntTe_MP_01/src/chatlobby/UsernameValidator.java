package chatlobby;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("usernameValidator")
public class UsernameValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		UserManager manager = (UserManager) FacesContext.getCurrentInstance()
				.getExternalContext().getApplicationMap().get("userManager");

		if (manager.isUsernameTaken(value.toString())) {
			FacesMessage facesMsg = new FacesMessage(
					"Username is already taken");
			facesMsg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(facesMsg);
		}

	}

}
