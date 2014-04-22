package beans.adherent;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import lombok.Data;
import sessions.facades.utilisateur.FacadeAdherent;
import sessions.facades.utilisateur.FacadeClub;
import sessions.facades.utilisateur.FacadeProfil;
import entities.utilisateur.Adherent;
import entities.utilisateur.Classement;
import entities.utilisateur.Club;
import entities.utilisateur.Profil;
import entities.utilisateur.Sexe;

@ManagedBean
@Data
@ViewScoped
public class CreationAdherentBean {

	@EJB
	private FacadeAdherent facadeAdherent;
	@EJB
	private FacadeProfil facadeProfil;
	@EJB
	private FacadeClub facadeClub;

	private Adherent adherent;
	
	private boolean isClasse;

	//après construction, init ma méthode
	@PostConstruct
	public void init(){
		adherent = facadeAdherent.newInstance();
	}


	public void enregistrerAdherent(){
		try { 
			chercherClassements();
			facadeAdherent.create(adherent);
		} catch (Exception e) {
			isClasse = true;
		}

	}

	public List<Profil> getListProfils(){
		return facadeProfil.readAll();
	}

	public List<Club> getListClubs(){
		return facadeClub.readAll();
	}

	public List<Sexe> getListSexe(){
		return facadeAdherent.getListeSexeList();
	}

	public void validateAdresseMailBdd(FacesContext context, UIComponent component,Object value) throws ValidatorException {
		String adresseMail = (String) value;
		if (facadeAdherent.isExistAdherent(adresseMail)) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"L'adresse mail a déjà été saisi","Entrée non valide"));
		}


	}

	public void chercherClassements() throws Exception{
		
		
		if (adherent.getLicenceFfba() != "") {
			List<Classement> lc = facadeAdherent.getClassementFFBAWebService(adherent);
			if (lc.get(0).getLibelleClassement() == null) {
				throw new Exception("pas de classements");
			}
			adherent.setListeClassements(lc);
		}
	}
	
} 

