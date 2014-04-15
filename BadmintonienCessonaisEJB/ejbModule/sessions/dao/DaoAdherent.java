package sessions.dao;


import javax.persistence.TypedQuery;

import entities.utilisateur.Adherent;

@SuppressWarnings("unchecked")
public class DaoAdherent extends AbstractDao<Adherent> {

	public Adherent getAdherentByMail(String mailAdherent){

		TypedQuery<Adherent> query = em.createNamedQuery("findAdherentByMail",Adherent.class);
		query.setParameter("mailAdherent",mailAdherent);

		return  query.getSingleResult();
	}
	

}
