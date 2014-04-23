package sessions.tournoi;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sessions.dao.DaoTournoi;
import entities.tournoi.Tableau;
import entities.tournoi.Tournoi;


@Stateless
public class FacadeTournoi{

	@EJB
	DaoTournoi daoTournoi;
	
	/**
	 * Créatin d'un tournoi dans la dao tournoi
	 * @param tournoi
	 */
	public void createTournoi(Tournoi tournoi){
		daoTournoi.create(tournoi);
	}
	
	/**
	 * Création d'une nouvelle instance de tournoi dans la dao
	 * @return
	 */
	public Tournoi getInstance(){
		return daoTournoi.newInstance();
	}

	/**
	 * instanciation d'un nouveau tableau
	 * @return
	 */
	public Tableau newTableau() {
		return new Tableau();
	}
}
