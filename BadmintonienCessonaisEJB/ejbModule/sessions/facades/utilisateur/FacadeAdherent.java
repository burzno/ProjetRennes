package sessions.facades.utilisateur;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sessions.dao.DaoAdherent;
import entities.utilisateur.Adherent;

/**
 * Exemple D'EJB SESSION
 * @author lucas.guerrot
 *
 */
@Stateless
public class FacadeAdherent {


	@EJB
	private DaoAdherent daoAdherent;


	public void create(Adherent t) {
		daoAdherent.create(t);
	}



	public Adherent newInstance() {

		return daoAdherent.newInstance();
	}


	public Adherent read(Object id) {
		return daoAdherent.read(id);
	}


	public List<Adherent> readAll() {

		return daoAdherent.readAll();
	}



	public Adherent update(Adherent t) {

		return daoAdherent.update(t);
	}


	public void delete(Adherent t) {
		daoAdherent.delete(t);

	}




}

