package beans.adherent;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import lombok.Data;
import mail.EnvoiMail;
import sessions.facades.references.FacadeReferences;
import sessions.facades.utilisateur.FacadeAdherent;
import sessions.facades.utilisateur.FacadeClub;
import sessions.facades.utilisateur.FacadeProfil;
import utils.jsf.JsfUtils;
import beans.utils.Utils;
import entities.reference.Classement;
import entities.reference.Format;
import entities.utilisateur.Adherent;
import entities.utilisateur.ClassementFFBA;
import entities.utilisateur.Club;
import entities.utilisateur.Profil;
import entities.utilisateur.Sexe;

/**
 * ManagedBean permettant de gerer les adhérents avec les références, profils, clubs et mail
 * @author g.joseph-mondesir
 *
 */
@ManagedBean
@Data
@ViewScoped
public class CreationAdherentBean {

	@EJB
	private FacadeAdherent facadeAdherent;
	@EJB
	private FacadeReferences facadeReferences;
	@EJB
	private FacadeProfil facadeProfil;
	@EJB
	private FacadeClub facadeClub;
	
	@EJB
	private EnvoiMail envoiMail;

	private Adherent adherent;
	private Classement classementSimple;
	private Classement classementDouble;
	private Classement classementDoubleMixte;

	private boolean isClasse=false;
	

	//après construction, init ma méthode
	@PostConstruct
	public void init(){
		adherent = facadeAdherent.newInstance();
	}

	
	/**
	 * Permet d'enregistrer la création d'un adhérent
	 */
	public void enregistrerAdherent(){
		try { 
			chercherClassements();
			adherent.setMotDePasse(Utils.hash(adherent.getPrenom()));
			facadeAdherent.create(adherent);
			JsfUtils.sendMessage("Adhérent bien enregistré !");
			envoiMail.sendMessage("test@localhost", null, "Creation compte","Un compte viens de vous être créé sur le site du badminton cessonnais");
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			context.redirect(context.getRequestContextPath());
		} catch (Exception e) {
			isClasse = true;
		}

	}

	/**
	 * Permet de lire tous les profils d'une facadeProfil
	 * @return
	 */
	public List<Profil> getListProfils(){
		return facadeProfil.readAll();
	}

	/**
	 * Permet de lire tous les clubs d'une facadeClub
	 * @return
	 */
	public List<Club> getListClubs(){
		return facadeClub.readAll();
	}

	/**
	 * Permet de récupérer la liste des sexes
	 * @return
	 */
	public List<Sexe> getListSexe(){
		return facadeAdherent.getListeSexeList();
	}

	/**
	 * Permet de récupérer tous les classemets
	 * @return
	 */
	public List<Classement> getListClassements(){
		return facadeReferences.getAllClassement();
	}

	/**
	 * Permet de vérifier si l'adresse mail existe dans la base de données
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateAdresseMailBdd(FacesContext context, UIComponent component,Object value) throws ValidatorException {
		String adresseMail = (String) value;
		if (facadeAdherent.isExistAdherent(adresseMail)) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"L'adresse mail a déjà été saisi","Entrée non valide"));
		}
	}


	/**
	 * Permet de récupérer le webservice du classement si l'adhérent possède une licence avec classement ou d'afficher le classement s'il n'en possède pas 
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

