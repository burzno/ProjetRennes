package beans.utils;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import utils.jsf.JsfUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@ManagedBean
@ApplicationScoped
@Getter
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Redirect {

	//Redirection explicite
//	final String FACESREDIRECT = "?faces-redirect=true";
	final String FACESREDIRECT = "";
	
	//PATH générique
//	final String PATH_INIT = "/jsf";
//	final String PATH_ADHERENT = "/adherent";
//	final String PATH_TOURNOI = "/tournoi";
//	final String PATH_COMMUN = "/commun";
	
	//pretty faces
<<<<<<< HEAD
	String accueil = "/accueil" + FACESREDIRECT;
=======
	String index = "/index" + FACESREDIRECT;
>>>>>>> branch 'master' of https://github.com/burzno/ProjetRennes.git
	String creerAdherent = "/creerAdherent" + FACESREDIRECT;
	String rechercherAdherent = "/rechercherAdherent" + FACESREDIRECT;
	String modifierAdherent = "/modifierAdherent" + FACESREDIRECT;
	String creerTournoi = "/creationTournoi" + FACESREDIRECT;
	String renseignerParticipant = "/renseignerParticipant" + FACESREDIRECT;
	String enTravaux = "/enTravaux" + FACESREDIRECT;
	
	public String newsPath(String nameNews){
		JsfUtils.putInFlashScope("nameNews", nameNews);
		return "/consulterNews" + FACESREDIRECT;
	}
}
