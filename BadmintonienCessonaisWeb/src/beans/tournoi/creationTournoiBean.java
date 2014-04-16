package beans.tournoi;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import sessions.facades.references.FacadeReferences;
import sessions.tournoi.FacadeTournoi;
import utils.jsf.JsfUtils;
import entities.tournoi.Tableau;
import entities.tournoi.Tournoi;
import entities.utilisateur.Categorie;
import entities.utilisateur.Classement;
import entities.utilisateur.Format;

@ManagedBean
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class creationTournoiBean {

	@EJB
	FacadeTournoi facadeTournoi;
	Tournoi tournoi;
	Tableau tableau;
	
	@EJB
	FacadeReferences facadeRef;
	List<Format>		formats;
	List<Categorie>		categories;
	List<Classement>	classements;
	
	
	private final int DUREE_MATCH = 25;
	private final int TPS_RECUP = 20;
	
	@PostConstruct
	public void init(){
		tournoi = facadeTournoi.getInstance();
		tournoi.setDureeMatch(DUREE_MATCH);
		tournoi.setDureeRecup(TPS_RECUP);
		
		tableau = facadeTournoi.newTableau();
		formats = facadeRef.getAllFormat();
		categories = facadeRef.getAllCategorie();
		classements = facadeRef.getAllClassement();
	}
	
	public void enregistrerTournoi(){
		facadeTournoi.createTournoi(tournoi);
		JsfUtils.sendMessage("Enregistrement du tournoi");
	}
}

