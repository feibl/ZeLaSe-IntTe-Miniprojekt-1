package chatlobby;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=Chat.class)
public class ChatConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent arg1, String arg2) {
		// TODO Auto-generated method stub
		ChatManagerBean mgr = context.getApplication().evaluateExpressionGet(context, "#{chatManagerBean}", ChatManagerBean.class);
		return mgr.getChatrooms().get(arg2);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
