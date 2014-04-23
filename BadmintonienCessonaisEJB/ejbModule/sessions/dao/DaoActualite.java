package sessions.dao;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import entities.actualite.Actualite;

/**
 * Dao permettant le requettage en base de données
 * @author g.joseph-mondesir
 *
 */
@SuppressWarnings("unchecked")
@Stateless
public class DaoActualite extends AbstractDao<Actualite>{

	public Actualite trouveActualite(String image){
		TypedQuery<Actualite> query = em.createNamedQuery("findActualiteByImage",Actualite.class);
		query.setParameter("image", image);
		
		return query.getSingleResult();
	}
}
