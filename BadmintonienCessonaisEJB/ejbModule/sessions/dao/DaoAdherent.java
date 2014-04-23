package sessions.dao;


import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import entities.utilisateur.Adherent;

/**
 * Dao permettant le requettage en base de données
 * @author g.joseph-mondesir
 *
 */
@SuppressWarnings("unchecked")
@Stateless
public class DaoAdherent extends AbstractDao<Adherent> {

	public Adherent getAdherentByMail(String mailAdherent){

		TypedQuery<Adherent> query = em.createNamedQuery("findAdherentByMail",Adherent.class);
		query.setParameter("mailAdherent",mailAdherent);

		return  query.getSingleResult();
	}
	
	public boolean isExistAdherent(String mailAdherent){
		
		try {
			getAdherentByMail(mailAdherent);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
}
