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
	final String PATH_TOURNOI = "/tournoi";
	
	
	
	String creerTournoi = PATH_INIT + PATH_TOURNOI + "/creationTournoi.xhtml" + FACESREDIRECT;
	
}
