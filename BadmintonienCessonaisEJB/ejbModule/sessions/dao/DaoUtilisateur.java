package sessions.dao;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import entities.utilisateur.Utilisateur;

/**
 * Dao permettant d'effectuer les requêtes sur la base de données
 * Hérite de la classe AbstractDao
 * @author g.joseph-mondesir
 *
 */
@SuppressWarnings("unchecked")
@Stateless
public class DaoUtilisateur extends AbstractDao<Utilisateur>{

	//Permet d'aller rechercher l'utiisateur avec son mail
	public Utilisateur verifConnection(String mailUtilisateur,String motDePasse){
		TypedQuery<Utilisateur> query = em.createNamedQuery("verifConnection",Utilisateur.class);
		query.setParameter("mailUtilisateur", mailUtilisateur);
		query.setParameter("motDePasse", motDePasse);
		Utilisateur u = null;
		try {
			u = query.getSingleResult();
		} catch (NoResultException e) {
		}
		return u;
	}
	
}
