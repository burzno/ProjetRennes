package converters;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean
@ViewScoped
public class GenericConverter implements Converter{
	
	private Map<UUID, Object> mapTemp = new HashMap<>();

	
	/**
	 * Retourne un UUID auto généré qui est associé à l'objet passé en paramètre
	 * pour pouvoir le récupérer au retour d'une sléection d'un composant de sasi.
	 */
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		UUID cleGeneree = UUID.randomUUID();
		mapTemp.put(cleGeneree, arg2);
		return cleGeneree.toString();
	}


	/**
	 * Retourne l'instance de l'objet associé au UUID passé en paramètre.
	 */
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		return mapTemp.get(UUID.fromString(arg2));
	}

}
