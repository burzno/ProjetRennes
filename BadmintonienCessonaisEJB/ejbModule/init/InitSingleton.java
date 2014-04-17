package init;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import sessions.facades.utilisateur.FacadeAdherent;
import sessions.facades.utilisateur.FacadeClub;
import sessions.facades.utilisateur.FacadeProfil;
import entities.utilisateur.Adherent;
import entities.utilisateur.Club;
import entities.utilisateur.Profil;
import entities.utilisateur.Sexe;


/*@SuppressWarnings("serial")
@Singleton
@Startup*/
public class InitSingleton implements Serializable{

	@EJB
	private FacadeAdherent facadeAdherent;
	@EJB
	private FacadeProfil facadeProfil;
	@EJB
	private FacadeClub facadeClub;

	@PostConstruct
	public void init(){

		if(facadeProfil.readAll().isEmpty()){
			System.out.println("creation profils");
			createProfil("Internaute");
			createProfil("Adhérent");
			createProfil("Animateur Principal");
			createProfil("Président");			
		}
		
		if(facadeClub.readAll().isEmpty()){
			System.out.println("creation clubs");
			createClub("Club ETRS");
			createClub("Club NANTES");
			createClub("Club BREST");
		}
		
		if(facadeAdherent.readAll().isEmpty()){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			List<Profil> lp = facadeProfil.readAll();
			List<Club> lc = facadeClub.readAll();
			try {
				System.out.println("creation adhérents début");
				createAdherent("68759812", "14587965", "Guichard", "Jeremy", Sexe.HOMME,sdf.parse("06/11/1990") , true,lp.get(1),lc.get(0));
				createAdherent("41258767", "", "Pommier", "Mathieu", Sexe.HOMME,sdf.parse("06/11/1988") , false,lp.get(2),lc.get(1));
				createAdherent("01578964", "68457879", "Chaveroux", "Chloe", Sexe.FEMME,sdf.parse("06/11/1985") , true,lp.get(3),lc.get(2));
				System.out.println("creation adhérents fin");
			} catch (ParseException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}


	
	private void createProfil(String libelleProfil){
		Profil p = facadeProfil.newInstance();
		p.setLibelleProfil(libelleProfil);
		facadeProfil.create(p);
	}

	private void createClub(String nomClub){
		Club c = facadeClub.newInstance();
		c.setNomClub(nomClub);
		facadeClub.create(c);
		
		
		
	}
	
	private void createAdherent(String licenceFcd,String licenceFfba,String nom,String prenom,Sexe sexe,Date dateNaiss,boolean referent,Profil p,Club c){

		//Categorie categorie;

		Adherent a = facadeAdherent.newInstance();
		a.setLicenceFcd(licenceFcd);
		a.setLicenceFfba(licenceFfba);
		a.setNom(nom);
		a.setPrenom(prenom);
		a.setSexe(sexe);
		a.setDateNaissance(dateNaiss);
		a.setReferent(referent);
		a.setProfil(p);
		a.setClub(c);
		facadeAdherent.create(a);
	}


}

