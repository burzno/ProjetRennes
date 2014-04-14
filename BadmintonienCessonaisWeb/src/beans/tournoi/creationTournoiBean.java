package beans.tournoi;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import lombok.Data;
import sessions.tournoi.FacadeTournoi;
import utils.jsf.JsfUtils;
import entities.tournoi.Tournoi;

@ManagedBean
@Data
public class creationTournoiBean {

	@EJB
	private FacadeTournoi facadeTournoi;
	private Tournoi tournoi;
	
	@PostConstruct
	public void init(){
		tournoi = facadeTournoi.getInstance();
	}
	
	public void enregistrerTournoi(){
		System.out.println("ici");
		JsfUtils.sendMessage("Enregistrement du tournoi");
	}
}

