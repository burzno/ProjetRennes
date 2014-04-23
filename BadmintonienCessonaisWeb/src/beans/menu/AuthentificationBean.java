package beans.menu;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletException;

import beans.spring.SpringSecurityHelper;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import sessions.facades.utilisateur.FacadeUtilisateur;
import utils.jsf.JsfUtils;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class AuthentificationBean implements Serializable {

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
	
	  public void connexion() throws IOException, ServletException {
		  SpringSecurityHelper.login();
			JsfUtils.sendError("Login ou mot de passe incorrect");
//		if (login.equals("root") && (motDePasse.equals("root"))) {
	    		
			setConnecte(true);
//		
//		}
//		else{
//			JsfUtils.sendError("Login ou mot de passe incorrect");
//			setConnecte(false);
//		}
	}
    
    
	public void deconnecte() throws ServletException, IOException{
		SpringSecurityHelper.logout();
		
		setConnecte(false);
	}
   

	
	
}
