package beans.menu;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import sessions.facades.utilisateur.FacadeUtilisateur;
import utils.jsf.JsfUtils;

@ManagedBean
@SessionScoped
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class AuthentificationBean {

	@EJB
	private FacadeUtilisateur facadeUtilisateur;
	
	String motDePasse;
	String login;
	boolean connecte = false;
	

// 	//authentification avec base de données
//    public void connexion() {
//    	Utilisateur u = null;
//    	u = facadeUtilisateur.getUtilisateur(login, motDePasse);
//    	if (u != null) {
//	    		
//    		setConnecte(true);
//    	
//    	}
//    	else{
//    		JsfUtils.sendMessage("Login ou mot de passe incorrect");
//    		setConnecte(false);
//    	}
//	}
	
	  public void connexion() {
		if (login.equals("root") && (motDePasse.equals("root"))) {
	    		
			setConnecte(true);
		
		}
		else{
			JsfUtils.sendMessage("Login ou mot de passe incorrect");
			setConnecte(false);
		}
	}
    
    
	public void deconnecte(){
		setConnecte(false);
	}
   

	
	
}
