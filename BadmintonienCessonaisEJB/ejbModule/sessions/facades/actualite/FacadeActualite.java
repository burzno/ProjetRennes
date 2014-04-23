package sessions.facades.actualite;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sessions.dao.DaoActualite;
import entities.actua.Actualite;


@Stateless
public class FacadeActualite {

	@EJB
	private DaoActualite daoActualite;
	
	public void create(Actualite a){
		daoActualite.create(a);
	}
	
	public  Actualite read(Object id){
		return daoActualite.read(id);
	}
	
	public Actualite update(Actualite a){
		return daoActualite.update(a);
	}
	
	public void delete(Actualite a){
		daoActualite.delete(a);
	}
	
	
	public Actualite newInstance() {

		return daoActualite.newInstance();
	}
	
	public Actualite getActualiteByImage(String image){
		return daoActualite.search("image", image).get(0);
	}
	
}
