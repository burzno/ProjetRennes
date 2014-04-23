package init;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map.Entry;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sessions.facades.references.FacadeReferences;
import sessions.facades.utilisateur.FacadeAdherent;
import sessions.facades.utilisateur.FacadeClub;
import sessions.facades.utilisateur.FacadeProfil;
import entities.utilisateur.Adherent;
import entities.utilisateur.Club;
import entities.utilisateur.Profil;
import entities.utilisateur.Sexe;


@SuppressWarnings("serial")
@FieldDefaults(level=AccessLevel.PRIVATE)
@Singleton
@Startup
public class Lancement implements Serializable{

	Log log = LogFactory.getLog(this.getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@EJB
	FacadeAdherent facadeAdherent;
	@EJB
	FacadeProfil facadeProfil;
	@EJB
	FacadeClub facadeClub;
	@EJB
	FacadeReferences facadeReference;

	@PostConstruct
	public void init(){
			try {
				log.debug("--------------------------------------------------------------------");
				log.debug("-------------------------Init chargment BDD-------------------------");
				Properties prop = new Properties();
				prop.load(this.getClass().getResourceAsStream("jeuDeDonnees.properties"));
				genererData(prop);
				log.debug("**************************Partie Adhérents**************************");
				prop.clear();
				prop.load(this.getClass().getResourceAsStream("adherents.properties"));
				genererData(prop);
				log.debug("-------------------------Fin chargment BDD-------------------------");
				log.debug("--------------------------------------------------------------------");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	private void genererData(Properties dataProperties){
			String init = dataProperties.getProperty("init");
			log.debug("Tables chargées : "+init);
			if(init != null && !init.trim().equals("")){
				for (Entry<Object, Object> entry : dataProperties.entrySet()){
					String key = entry.getKey().toString();
					key = key.split("_")[0];
					if(init.contains(key)){
						String[] data = entry.getValue().toString().split(",");
						switch (key) {
							case "Profil":
								creerProfil(data);
								break;
							case "Club":
								creerClub(data);
								break;
							case "Adherent":
								creerAdherent(data);
								break;
							default:
								break;
						}
					}
				}
			}
	}

	private void creerProfil(String[] data){
		log.debug("Chargement table -Profil-");
		Profil p = facadeProfil.newInstance();
		p.setLibelleProfil(data[0]);
		facadeProfil.create(p);
	}
	
	private void creerClub(String[] data){
		log.debug("Chargement table -Club-");
		Club c = facadeClub.newInstance();
		c.setNomClub(data[0]);
		facadeClub.create(c);
	}

	private void creerAdherent(String[] data){
		log.debug("Chargement table -Adhérent-");
		try {
			Adherent a = facadeAdherent.newInstance();
			a.setLicenceFcd(data[0]);
			a.setLicenceFfba(data[1]);
			a.setNom(data[2]);
			a.setPrenom(data[3]);
			a.setSexe(Sexe.valueOf(data[4])); 
			a.setDateNaissance(sdf.parse(data[5]));
			a.setReferent(Boolean.getBoolean(data[6]));
			a.setActif(Boolean.getBoolean(data[7]));
			a.setProfil(facadeProfil.getProfilByLibelle(data[8]));
			a.setClub(facadeClub.getClubByLibelle(data[9]));
			a.setAdresseMail(data[10]);
			a.setMotDePasse(data[11]);
			a.setCategorie(facadeReference.getCategorieByLibelleCourt(data[12]));
			facadeAdherent.create(a);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}


}

