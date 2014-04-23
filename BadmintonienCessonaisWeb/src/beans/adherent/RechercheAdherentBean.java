package beans.adherent;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import lombok.Data;
import sessions.facades.utilisateur.FacadeAdherent;
import sessions.facades.utilisateur.FacadeClub;
import utils.jsf.JsfUtils;
import beans.utils.Utils;
import entities.utilisateur.Adherent;

/**
 * ManagedBean permettant de rechercher un adhérent
 * @author g.joseph-mondesir
 *
 */
@ManagedBean
@Data
public class RechercheAdherentBean {
	
	@EJB
	private FacadeAdherent facadeAdherent;
	@EJB
	private FacadeClub facadeClub;
	
	private List<Adherent> filteredAdherents;  
	
	private SelectItem[] sexeOptions; 
	
	private SelectItem[] clubOptions; 
	
	private Adherent selectedAdherent;  
	
	@PostConstruct
	public void init(){
		sexeOptions = Utils.createFilterOptions(facadeAdherent.getListeSexeStringTab());
		clubOptions = Utils.createFilterOptions(facadeClub.listeClubsStringTab());
		
	}
	
	/**
	 * Permet de lister tous les adhérents
	 * @return
	 */
	public List<Adherent> getListAdherents(){
		return facadeAdherent.readAll();
	}
	
	/**
	 * 
	 * Permet de lister tous les adhérents actifs
	 * @return
	 */
	public List<Adherent> getListeAdherentsActifs(){
		return facadeAdherent.getListeAdherentsActifs();
	}
	
	/**
	 * Permet de désactiver les adhérents
	 */
	public void desactiverAdherent(){
		Adherent a = getSelectedAdherent(); 
		a.setActif(false);
		facadeAdherent.update(a);
		JsfUtils.sendMessage("Adhérent : "+a.getNom()+" désactivé");
		
	}
	
	/**
	 * permet de selectionner un adhérent et de le mettre en mémoire dans le flashscope
	 */
	public void selectionnerAdherent(){
		JsfUtils.putInFlashScope("ADHERENT_MODIF",getSelectedAdherent());
		
	}

}
