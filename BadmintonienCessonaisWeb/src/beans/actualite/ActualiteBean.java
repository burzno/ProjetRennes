package beans.actualite;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import sessions.facades.actualite.FacadeActualite;
import utils.jsf.JsfUtils;
import entities.actualite.Actualite;


/**
 * ManagedBean permettant de gérer les actualités
 * @author g.joseph-mondesir
 *
 */
@ManagedBean
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class ActualiteBean {
	
	@EJB
	FacadeActualite facadeActualite;
	Actualite actu;
	
	@PostConstruct
	public void init(){
		String name = (String) JsfUtils.getFromFlashScope("nameNews");
		name = "galleria1";
		actu = facadeActualite.getActualiteByName(name);
	}

}
