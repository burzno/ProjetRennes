package beans.utils;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

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
	final String PATH_INIT = "/jsf";
	final String PATH_ADHERENT = "/adherent";
	final String PATH_TOURNOI = "/tournoi";
	//final String PATH_COMMUN = "/commun";
	
	//pretty faces
	String creerAdherent = "/creerAdherent" + FACESREDIRECT;
	String rechercherAdherent = "/rechercherAdherent" + FACESREDIRECT;
	String creerTournoi = "/creationTournoi" + FACESREDIRECT;
	String renseignerAdherent = "/renseignerParticipant" + FACESREDIRECT;

//	//Adherent
//	String creerAdherent = PATH_INIT + PATH_ADHERENT + "/creerAdherent.xhtml" + FACESREDIRECT;
//	String rechercherAdherent = PATH_INIT + PATH_ADHERENT + "/rechercherAdherent.xhtml" + FACESREDIRECT;

	/*
	//Adherent
	String creerAdherent = PATH_INIT + PATH_ADHERENT + "/creerAdherent.xhtml" + FACESREDIRECT;
	String rechercherAdherent = PATH_INIT + PATH_ADHERENT + "/rechercherAdherent.xhtml" + FACESREDIRECT;
	String test = PATH_INIT + PATH_ADHERENT + "/test.xhtml" + FACESREDIRECT;
	
	//Tournoi
//	String creerTournoi = PATH_INIT + PATH_TOURNOI + "/creationTournoi.xhtml" + FACESREDIRECT;
//	String renseignerAdherent = PATH_INIT + PATH_TOURNOI + "/renseignerParticipant.xhtml" + FACESREDIRECT;
	String creerTournoi2 = PATH_INIT + PATH_TOURNOI + "/renseignerParticipant.xhtml" + FACESREDIRECT;
	
	//Commun
	//String erreur = PATH_INIT + PATH_COMMUN + "/erreur.xhtml.xhtml" +FACESREDIRECT;
	*/
}
