package sessions.facades.utilisateur;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sessions.dao.DaoClub;
import entities.utilisateur.Club;
import entities.utilisateur.Profil;


@Stateless
public class FacadeClub {


	@EJB
	private DaoClub daoClub;


	public void create(Club p) {
		daoClub.create(p);
	}


	public List<Club> readAll() {

		return daoClub.readAll();
	}

	public Club newInstance() {

		return daoClub.newInstance();
	}

	public String[] listeClubsStringTab(){
		List<Club> lc = daoClub.readAll();
		String[] clubs = new String[lc.size()];
		int cpt=0;
		for (Club club : lc) {
			clubs[cpt] = club.getNomClub();
			cpt++;
		}
		return clubs;
	}
	
	public Club getClubByLibelle(String libelle){
		return daoClub.search("nomClub", libelle).get(0);
	}


}
