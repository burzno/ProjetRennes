package sessions.facades.utilisateur;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sessions.dao.DaoUtilisateur;
import entities.utilisateur.Utilisateur;

@Stateless
public class FacadeUtilisateur {


	//Retourne l'adhérent s'il existe
	@EJB
	private DaoUtilisateur daoUtilisateur;
	
	/**
	 * Vérifie les paramètres de connection login et mot de passe
	 * @param login
	 * @param motDePasse
	 * @return
	 */
	public Utilisateur getUtilisateur(String login, String motDePasse){
		return daoUtilisateur.verifConnection(login, motDePasse);
	}
		
}
