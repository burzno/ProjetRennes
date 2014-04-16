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
	final String FACESREDIRECT = "?faces-redirect=true";
	
	//PATH générique
	final String PATH_INIT = "/jsf";
	final String PATH_ADHERENT = "/adherent";
	final String PATH_TOURNOI = "/tournoi";
	
	
	//Adherent
	String creerAdherent = PATH_INIT + PATH_ADHERENT + "/creerAdherent.xhtml" + FACESREDIRECT;
	
	//Tournoi
	String creerTournoi = PATH_INIT + PATH_TOURNOI + "/creationTournoi.xhtml" + FACESREDIRECT;
	String renseignerAdherent = PATH_INIT + PATH_TOURNOI + "/renseignerParticipant.xhtml" + FACESREDIRECT;
	
	
	
	
}
