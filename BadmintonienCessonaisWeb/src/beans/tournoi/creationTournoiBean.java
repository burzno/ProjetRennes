package beans.tournoi;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import org.primefaces.event.DragDropEvent;

import sessions.facades.references.FacadeReferences;
import sessions.facades.utilisateur.FacadeAdherent;
import sessions.facades.utilisateur.FacadeClub;
import sessions.tournoi.FacadeTournoi;
import utils.jsf.JsfUtils;
import beans.utils.Utils;
import entities.reference.Categorie;
import entities.reference.Classement;
import entities.reference.Format;
import entities.tournoi.Tableau;
import entities.tournoi.Tournoi;
import entities.utilisateur.Adherent;

/**
 * ManagedBean permettant de gérer la création de tournois
 * @author g.joseph-mondesir
 *
 */
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
	FacadeClub facadeClub;
	
	@EJB
	FacadeReferences facadeRef;
	List<Format>		formats;
	List<Categorie>		categories;
	List<Classement>	classements;
	
	List<Adherent>		adherents;
	List<Adherent>		adherentsFiltred;
	
	SelectItem[] sexeOptions; 
	SelectItem[] clubOptions;
	SelectItem[] categorieOptions;
	
	
	
	
	
	private final int DUREE_MATCH = 25;
	private final int TPS_RECUP = 20;
	
	/**
	 * Initialisation des paramètres par defaut du tournoi
	 */
	@PostConstruct
	public void init(){
		tournoi = facadeTournoi.getInstance();
		tournoi.setDureeMatch(DUREE_MATCH);
		tournoi.setDureeRecup(TPS_RECUP);
		sexeOptions = Utils.createFilterOptions(facadeAdherent.getListeSexeStringTab());
		clubOptions = Utils.createFilterOptions(facadeClub.listeClubsStringTab());
		categorieOptions = Utils.createFilterOptions(facadeRef.getAllCategorieStringTab());
	}
	
	/**
	 * Initialisation des paramètres du tournoi
	 */
	public void createTournoi(){
		adherents = facadeAdherent.getListeAdherentsActifs();
		formats = facadeRef.getAllFormat();
		categories = facadeRef.getAllCategorie();
		classements = facadeRef.getAllClassement();
	}
	
	public void validerTournoi(){
		//TODO save tournoi
		JsfUtils.sendMessage("Le tournoi "+tournoi.getNom()+" a bien été sauvegardé");
	}
	
	public void initAjoutTableau(){
		tableau = facadeTournoi.newTableau();
	}
	
	/**
	 * Initialisation du tableau en cours
	 */
	public void initAjoutTableauCourant(){
		tableauCourant = facadeTournoi.newTableau();
	}
	
	/**
	 * Permet d'ajouter un participant
	 * @param ddEvent
	 */
   public void addParticipant(DragDropEvent ddEvent) {
	   Adherent ad = ((Adherent) ddEvent.getData());
	   addParticipant(ad);
    } 
   
   /**
    * Permet d'ajouter un participant au tableau
    * @param ad
    */
   public void addParticipant(Adherent ad) {
	   JsfUtils.sendError("Je suis là");
	   if(tableauCourant != null){
		   tableauCourant.getAdherent().add(ad);
		   adherents.remove(ad);  
		   JsfUtils.sendMessage("Ajout de l'adhérent : "+ad.getLicenceFcd()+" au tableau num "+tableauCourant.getNumTab());
	   }else{
		   JsfUtils.sendError("Veuillez sélectionner au préalable un tableau");
	   }
   } 
   
   /**
    * Permet de supprimer un participant du tableau
    * @param ad
    */
   public void removeParticipant(Adherent ad) {
	   JsfUtils.sendError("Je suis là");
	   if(tableauCourant != null){
		   adherents.add(ad);  
		   tableauCourant.getAdherent().remove(ad);
		   JsfUtils.sendMessage("Retrait de l'adhérent : "+ad.getLicenceFcd()+" du tableau num "+tableauCourant.getNumTab());
	   }else{
		   JsfUtils.sendError("Veuillez sélectionner au préalable un tableau");
	   }
   } 
	
   /**
    * permet d'ajouter un tableau
    */
	public void ajouterTableau(){
		tableau.setNumTab(tournoi.getTableaux().size()+1);
		tableau.setTournoi(tournoi);
		tournoi.getTableaux().add(tableau);
		tableauCourant = tableau;
		initAjoutTableau();
	}
	
}

