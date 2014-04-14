package sessions.tournoi;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.tournoi.Tournoi;


@Stateless
public class FacadeTournoi{

	@PersistenceContext
	private EntityManager em;
	
	public Tournoi getInstance(){
		return new Tournoi();
	}
}
