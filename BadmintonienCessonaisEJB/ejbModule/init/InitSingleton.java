package init;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import sessions.facades.utilisateur.FacadeAdherent;
import sessions.facades.utilisateur.FacadeProfil;
import entities.utilisateur.Adherent;
import entities.utilisateur.Profil;
import entities.utilisateur.Sexe;


@SuppressWarnings("serial")
@Singleton
@Startup
public class InitSingleton implements Serializable{

	@EJB
	private FacadeAdherent facadeAdherent;
	@EJB
	private FacadeProfil facadeProfil;

	@PostConstruct
	public void init(){

		if(facadeProfil.readAll().isEmpty()){
			createProfil("Internaute");
			createProfil("Adhérent");
			createProfil("Animateur Principal");
			createProfil("Président");			
		}
		
		if(facadeAdherent.readAll().isEmpty()){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			List<Profil> lp = facadeProfil.readAll();
			try {
				createAdherent("68759812", "14587965", "Guichard", "Jeremy", Sexe.HOMME,sdf.parse("06/11/1990") , true,lp.get(1));
				createAdherent("41258767", "", "Pommier", "Mathieu", Sexe.HOMME,sdf.parse("06/11/1988") , false,lp.get(2));
				createAdherent("01578964", "68457879", "Chaveroux", "Chloe", Sexe.FEMME,sdf.parse("06/11/1985") , true,lp.get(3));
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

	private void createAdherent(String licenceFcd,String licenceFfba,String nom,String prenom,Sexe sexe,Date dateNaiss,boolean referent,Profil p){

		//Categorie categorie;
		//Club club;

		Adherent a = facadeAdherent.newInstance();

		facadeAdherent.create(a);
	}


}

