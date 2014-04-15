package sessions.facades.utilisateur;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sessions.dao.DaoAdherent;
import sessions.facades.Facade;
import entities.utilisateur.Adherent;

/**
 * Exemple D'EJB SESSION
 * @author lucas.guerrot
 *
 */
@Stateless
public class FacadeAdherent implements Facade<Adherent>{

	@EJB
	private DaoAdherent daoAdherent;

	@Override
	public Adherent newInstance() {
		
		return daoAdherent.newInstance();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<Adherent> getBusinessClass() {
		
		return daoAdherent.getBusinessClass();
	}

	@Override
	public void create(Adherent t) {
		daoAdherent.create(t);
		
	}

	@Override
	public Adherent read(Object id) {
		return daoAdherent.read(id);
	}

	@Override
	public List<Adherent> readAll() {
		
		return daoAdherent.readAll();
	}

	@Override
	public List<Adherent> readAll(String... orderBy) {
	
		return daoAdherent.readAll(orderBy);
	}

	@Override
	public Adherent update(Adherent t) {
		
		return daoAdherent.update(t);
	}

	@Override
	public void delete(Adherent t) {
		daoAdherent.delete(t);
		
	}

	@Override
	public List<Adherent> search(String parameterName, Object parameterValue,
			String... orderBy) {
		
		return daoAdherent.search(parameterName, parameterValue, orderBy);
	}

	
	
	
	
	/**
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
	

	
	public boolean isExist(String mailAdherent){

		
		try {
			getAdherentByMail(mailAdherent);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		

	}**/


}

