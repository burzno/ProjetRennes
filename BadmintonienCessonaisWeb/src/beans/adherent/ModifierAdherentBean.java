package beans.adherent;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import lombok.Data;
import mail.EnvoiMail;
import sessions.facades.references.FacadeReferences;
import sessions.facades.utilisateur.FacadeAdherent;
import sessions.facades.utilisateur.FacadeClub;
import sessions.facades.utilisateur.FacadeProfil;
import utils.jsf.JsfUtils;
import entities.reference.Classement;
import entities.reference.Format;
import entities.utilisateur.Adherent;
import entities.utilisateur.ClassementFFBA;
import entities.utilisateur.Club;
import entities.utilisateur.Profil;
import entities.utilisateur.Sexe;

/**
 * ManagedBean permettant de gérer les modifications d'un ahdérent
 * @author g.joseph-mondesir
 *
 */
@ManagedBean
@Data
@ViewScoped
public class ModifierAdherentBean {

	@EJB
	private FacadeAdherent facadeAdherent;
	@EJB
	private FacadeReferences facadeReferences;
	@EJB
	private FacadeProfil facadeProfil;
	@EJB
	private FacadeClub facadeClub;

	private Adherent adherent;
	private Classement classementSimple;
	private Classement classementDouble;
	private Classement classementDoubleMixte;

	private boolean isClasse=false;
	

	//après construction, init ma méthode
	@PostConstruct
	public void init(){
		adherent = (Adherent) JsfUtils.getFromFlashScope("ADHERENT_MODIF");
		if (adherent.getLicenceFfba() != "") {
			isClasse = true;
			classementSimple = adherent.getClassement().getClassement().get(Format.SPL);
			classementDouble = adherent.getClassement().getClassement().get(Format.DBL);
			classementDoubleMixte = adherent.getClassement().getClassement().get(Format.DBM);
		}
	}


	/**
	 * Permet d'enregistrer l'adhérnet après mise à jour
	 */
	public void enregistrerAdherent(){
		try { 
			chercherClassements();
			facadeAdherent.update(adherent);
			JsfUtils.sendMessage("Adhérent bien Modifié !");
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			context.redirect(context.getRequestContextPath());
		} catch (Exception e) {
			isClasse = true;
		}

	}

	/**
	 * Récupère tous les profils de la facadeProfil
	 * @return
	 */
	public List<Profil> getListProfils(){
		return facadeProfil.readAll();
	}

	/**
	 * récupère tous les clubs de la facadeClub
	 * @return
	 */
	public List<Club> getListClubs(){
		return facadeClub.readAll();
	}

	/**
	 * Récupère la liste des sexes
	 * @return
	 */
	public List<Sexe> getListSexe(){
		return facadeAdherent.getListeSexeList();
	}

	/**
	 * récupère la liste des classements
	 * @return
	 */
	public List<Classement> getListClassements(){
		return facadeReferences.getAllClassement();
	}


	/**
	 * Permet d'ajouter les classements si le joueur est classé ou de les proposer à l'ajout s'il n'est pas classé
	 * @throws Exception
	 */
	public void chercherClassements() throws Exception{
		if (!isClasse) {
			if (adherent.getLicenceFfba() != "") {
				ClassementFFBA classements = facadeAdherent.getClassementFFBAWebService(adherent);
				adherent.setClassement(classements);
				if (classements.getClassement().isEmpty()) {
					JsfUtils.sendMessage("Pas de classements pré rentré pour ce joueur");
					throw new Exception("pas de classements");
				}
			}
		}else if (adherent.getClassement().getClassement().isEmpty()) {
			adherent.getClassement().getClassement().put(Format.SPL, classementSimple);
			adherent.getClassement().getClassement().put(Format.DBL, classementDouble);
			adherent.getClassement().getClassement().put(Format.DBM, classementDoubleMixte);
		}
	}

} 

