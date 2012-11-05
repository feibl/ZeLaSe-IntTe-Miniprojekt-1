package chatlobby;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class ResourceHandler {
	public static String getResourceText(FacesContext context, String key) {
		try {
			ResourceBundle bundle = context.getApplication()
					.getResourceBundle(context, "msg");
			return bundle.getString(key);
		} catch(MissingResourceException e) {
			return "???" + key + "???";
		}

	}
}
