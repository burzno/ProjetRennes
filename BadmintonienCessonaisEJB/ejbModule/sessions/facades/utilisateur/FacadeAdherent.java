package sessions.facades.utilisateur;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sessions.dao.DaoAdherent;
import entities.utilisateur.Adherent;
import entities.utilisateur.Sexe;

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

	public String[] lesSexes(){
		String[] sexes = new String[Sexe.values().length];
		int cpt=0;
		for (Sexe s : Sexe.values()) {
			sexes[cpt] =  s.getLibelle();
			cpt++;
		}
		return sexes;
	}



}

