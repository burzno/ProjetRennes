package sessions.facades.actualite;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sessions.dao.DaoActualite;
import entities.actualite.Actualite;
import exceptions.BadmintonException;

/**
 * Facade permettant de faire le lien entre la dao et le managedbean
 * Contient les opérations de base pour la manipulation de la dao à partir de la facade
 * @author g.joseph-mondesir
 *
 */
@Stateless
public class FacadeActualite {

	@EJB
	private DaoActualite daoActualite;
	
	/**
	 * création
	 * @param a
	 */
	public void create(Actualite a){
		daoActualite.create(a);
	}
	
	/**
	 * lecture
	 * @param id
	 * @return
	 */
	public  Actualite read(Object id){
		return daoActualite.read(id);
	}
	
	/**
	 * mise à jour
	 * @param a
	 * @return
	 */
	public Actualite update(Actualite a){
		return daoActualite.update(a);
	}
	
	/**
	 * suppression
	 * @param a
	 */
	public void delete(Actualite a){
		daoActualite.delete(a);
	}
	
	/**
	 * génération d'une nouvelle instance
	 * @return
	 */
	public Actualite newInstance() {

		return daoActualite.newInstance();
	}
	
	/**
	 * rechercher des actualités parleur noms
	 * @param name
	 * @return
	 */
	public Actualite getActualiteByName(String name) throws BadmintonException{
		try{
			return daoActualite.search("name", name).get(0);
		}catch(Exception e){
			throw new BadmintonException("Aucune actualité ne correspond au nom "+name);
		}
	}
	
}
