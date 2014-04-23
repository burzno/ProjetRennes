package sessions.facades.utilisateur;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sessions.dao.DaoClub;
import entities.utilisateur.Club;


@Stateless
public class FacadeClub {


	@EJB
	private DaoClub daoClub;

	/**
	 * Création d'un club
	 * @param p
	 */
	public void create(Club p) {
		daoClub.create(p);
	}

	/**
	 * Lecture de tous les clubs
	 * @return
	 */
	public List<Club> readAll() {

		return daoClub.readAll();
	}

	/**
	 * Nouvelle instance d'un club
	 * @return
	 */
	public Club newInstance() {

		return daoClub.newInstance();
	}

	/**
	 * Liste des clubs mise sous forme de tableau
	 * @return
	 */
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
	
	/**
	 * recherche de la liste des clubs par libellé
	 * @param libelle
	 * @return
	 */
	public Club getClubByLibelle(String libelle){
		return daoClub.search("nomClub", libelle).get(0);
	}


}
