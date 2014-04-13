package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class creationTournoiBean {

	@EJB
	private FacadeTournoi facadeTournoi;
	private Tournoi tournoi;
	
	
}
