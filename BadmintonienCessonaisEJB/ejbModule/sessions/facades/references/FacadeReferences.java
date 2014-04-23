package sessions.facades.references;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;

import entities.reference.Categorie;
import entities.reference.Classement;
import entities.reference.Format;

/**
 * facade permettant les manipulations des enums
 * @author g.joseph-mondesir
 *
 */
@Stateless
public class FacadeReferences {

	/**
	 * Liste des formats
	 * @return
	 */
	public List<Format> getAllFormat(){
		return Arrays.asList(Format.values());
	}
	
	/**
	 * liste des catégories
	 * @return
	 */
	public List<Categorie> getAllCategorie(){
		return Arrays.asList(Categorie.values());
	}
	
	/**
	 * liste des classements
	 * @return
	 */
	public List<Classement> getAllClassement(){
		return Arrays.asList(Classement.values());
	}
	
	/**
	 * récupère la catégorie à partir du libellé court
	 * @param libCourt
	 * @return
	 */
	public Categorie getCategorieByLibelleCourt(String libCourt){
		return Categorie.valueOf(libCourt);
	}
	
	/**
	 * récupère le format à partir du libéellé court
	 * @param libCourt
	 * @return
	 */
	public Format getFormatByLibelleCourt(String libCourt){
		return Format.valueOf(libCourt);
	}
	
	/**
	 * Récupère les différents classements et les place dans un tableau
	 * @return
	 */
	public String[] getAllClassementStringTab(){
		String[] classements = new String[Classement.values().length];
		int cpt=0;
		for (Classement c : Classement.values()) {
			classements[cpt] =  c.name();
			cpt++;
		}
		return classements;
	}
	
	/**
	 * Récupère toutes les catégories et les classe dans un tableau
	 * @return
	 */
	public String[] getAllCategorieStringTab(){
		String[] categories = new String[Categorie.values().length];
		int cpt=0;
		for (Categorie c : Categorie.values()) {
			categories[cpt] =  c.name();
			cpt++;
		}
		return categories;
	}
	
}
