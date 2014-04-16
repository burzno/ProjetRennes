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
	
	public void createTournoi(Tournoi tournoi){
		daoTournoi.create(tournoi);
	}
	
	
	public Tournoi getInstance(){
		return daoTournoi.newInstance();
	}

	public Tableau newTableau() {
		return new Tableau();
	}
}
