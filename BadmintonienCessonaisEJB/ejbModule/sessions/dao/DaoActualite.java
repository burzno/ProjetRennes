package sessions.dao;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import entities.actua.Actualite;

@SuppressWarnings("unchecked")
@Stateless
public class DaoActualite extends AbstractDao<Actualite>{

	public Actualite trouveActualite(String image){
		TypedQuery<Actualite> query = em.createNamedQuery("findActualiteByImage",Actualite.class);
		query.setParameter("image", image);
		
		return query.getSingleResult();
	}
}
