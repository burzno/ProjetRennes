package beans.actualite;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import sessions.facades.actualite.FacadeActualite;
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

}
