package converters;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import sessions.facades.actualite.FacadeActualite;
import utils.jsf.JsfUtils;
import entities.actua.Actualite;
import exceptions.BadmintonException;

@ManagedBean
public class ActualiteConverter implements Converter {

	@EJB
	FacadeActualite facadeActualite;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,String value) {
		try{
			if(value.contains(".")){
				value = value.replace(".jpg", "");
			}
			return facadeActualite.getActualiteByName(value);
		} catch (BadmintonException e) {
			JsfUtils.sendMessage(e);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) {
		try{
			if(Actualite.class.equals(value.getClass()))
				return ((Actualite) value).getName();
			else
				return null;
		} catch (NullPointerException e) {
			return null;
		}
	}
	
	
	
}
