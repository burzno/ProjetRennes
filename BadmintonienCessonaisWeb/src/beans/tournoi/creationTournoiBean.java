package beans.tournoi;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import lombok.Data;
import sessions.tournoi.FacadeTournoi;
import entities.tournoi.Tournoi;

@ManagedBean
@Data
public class creationTournoiBean {

	@EJB
	private FacadeTournoi facadeTournoi;
	private Tournoi tournoi;
	
	
}

