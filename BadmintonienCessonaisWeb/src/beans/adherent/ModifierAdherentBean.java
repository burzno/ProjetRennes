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
import entities.reference.Classement;
import entities.reference.Format;
import entities.utilisateur.Adherent;
import entities.utilisateur.ClassementFFBA;
import entities.utilisateur.Club;
import entities.utilisateur.Profil;
import entities.utilisateur.Sexe;
import sessions.facades.references.FacadeReferences;

import utils.jsf.JsfUtils;

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
		if (adherent.getLicenceFfba() == null) {
			isClasse = true;
			classementSimple = adherent.getClassement().getClassement().get(Format.SPL);
			classementDouble = adherent.getClassement().getClassement().get(Format.DBL);
			classementDoubleMixte = adherent.getClassement().getClassement().get(Format.DBM);
		}
	}


	public void enregistrerAdherent(){
		try { 
			chercherClassements();
			System.out.println(adherent.toString());
			facadeAdherent.update(adherent);
			JsfUtils.sendMessage("Adhérent bien Modifié !");
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

	public List<Classement> getListClassements(){
		return facadeReferences.getAllClassement();
	}


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

