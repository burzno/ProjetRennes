package sessions.facades.references;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;

import entities.reference.Categorie;
import entities.reference.Classement;
import entities.reference.Format;

@Stateless
public class FacadeReferences {

	
	public List<Format> getAllFormat(){
		return Arrays.asList(Format.values());
	}
	
	public List<Categorie> getAllCategorie(){
		return Arrays.asList(Categorie.values());
	}
	
	public List<Classement> getAllClassement(){
		return Arrays.asList(Classement.values());
	}
	
	public Categorie getCategorieByLibelleCourt(String libCourt){
		return Categorie.valueOf(libCourt);
	}
	
	public Format getFormatByLibelleCourt(String libCourt){
		return Format.valueOf(libCourt);
	}
	
}
