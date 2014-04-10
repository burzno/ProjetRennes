package sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Adherent;

/**
 * Exemple D'EJB SESSION
 * @author lucas.guerrot
 *
 */
@Stateless
public class FacadeAdherent {

	@PersistenceContext
	private EntityManager em;



	public void ajouterAdherent(Adherent ad){
		em.persist(ad);
	}

	public List<Adherent> getListeAdherents(){
		TypedQuery<Adherent> query = em.createNamedQuery("AllAdherents",Adherent.class);
		return query.getResultList();
	}

	public Adherent newAdherent(){
		return new Adherent();
	}
	

	public Adherent getAdherentByMail(String mailAdherent){
		
		TypedQuery<Adherent> query = em.createNamedQuery("findAdherentByMail",Adherent.class);
		query.setParameter("mailAdherent",mailAdherent);
		
		return  query.getSingleResult();
		
		
	}
	public boolean isExist(String mailAdherent){

		
		try {
			getAdherentByMail(mailAdherent);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		

	}


}

