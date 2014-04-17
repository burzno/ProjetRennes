package sessions.facades.references;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sessions.dao.DaoCategorie;
import sessions.dao.DaoClassement;
import sessions.dao.DaoFormat;
import entities.utilisateur.Categorie;
import entities.utilisateur.Classement;
import entities.utilisateur.Format;

@Stateless
public class FacadeReferences {

	@EJB
	private DaoFormat daoFormat;
	@EJB
	private DaoCategorie daoCategorie;
	@EJB
	private DaoClassement daoClassement;
	
	
	public List<Format> getAllFormat(){
		return daoFormat.readAll();
	}
	
	public List<Categorie> getAllCategorie(){
		return daoCategorie.readAll();
	}
	
	public List<Classement> getAllClassement(){
		return daoClassement.readAll();
	}
	
	public Format getFormatByLibelleCourt(String libCourt){
		return daoFormat.search("libelleFormatCourt", libCourt).get(0);
	}
}
