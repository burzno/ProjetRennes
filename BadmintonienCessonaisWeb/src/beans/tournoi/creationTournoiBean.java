package beans.tournoi;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import org.primefaces.event.DragDropEvent;

import sessions.facades.references.FacadeReferences;
import sessions.facades.utilisateur.FacadeAdherent;
import sessions.tournoi.FacadeTournoi;
import utils.jsf.JsfUtils;
import entities.reference.Categorie;
import entities.reference.Classement;
import entities.reference.Format;
import entities.tournoi.Tableau;
import entities.tournoi.Tournoi;
import entities.utilisateur.Adherent;

@ManagedBean
@ViewScoped
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class creationTournoiBean {

	@EJB
	FacadeTournoi facadeTournoi;
	Tournoi tournoi;
	Tableau tableau;
	Tableau tableauCourant;
	
	@EJB
	FacadeAdherent facadeAdherent;
	@EJB
	
	FacadeReferences facadeRef;
	List<Format>		formats;
	List<Categorie>		categories;
	List<Classement>	classements;
	
	List<Adherent>		adherents;
	
	private final int DUREE_MATCH = 25;
	private final int TPS_RECUP = 20;
	
	@PostConstruct
	public void init(){
		tournoi = facadeTournoi.getInstance();
		tournoi.setDureeMatch(DUREE_MATCH);
		tournoi.setDureeRecup(TPS_RECUP);
	}
	
	
	public void createTournoi(){
		adherents = facadeAdherent.readAll();
		formats = facadeRef.getAllFormat();
		categories = facadeRef.getAllCategorie();
		classements = facadeRef.getAllClassement();
		JsfUtils.sendMessage("initialisation des paramètres du tournoi");
	}
	
	public void initAjoutTableau(){
		tableau = facadeTournoi.newTableau();
	}
	public void initAjoutTableauCourant(){
		tableauCourant = facadeTournoi.newTableau();
	}
	
   public void addParticipant(DragDropEvent ddEvent) {
	  if(tableauCourant != null){
		   Adherent ad = ((Adherent) ddEvent.getData());
		   tableauCourant.getAdherent().add(ad);
		   adherents.remove(ad);  
	   }else{
		   JsfUtils.sendError("Veuillez sélectionner au préalable un tableau");
	   }
    } 
	
	public void ajouterTableau(){
		tableau.setNumTab(tournoi.getTableaux().size()+1);
		tableau.setTournoi(tournoi);
		tournoi.getTableaux().add(tableau);
		tableauCourant = tableau;
		initAjoutTableau();
	}
	
}

